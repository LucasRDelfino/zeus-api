package br.com.zeus_api.service;


import br.com.zeus_api.dto.OpenWeatherResponse;
import br.com.zeus_api.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    @Value("${openweather.api.key}")
    private String apiKey;

    private final WebClient webClient = WebClient.create("https://api.openweathermap.org");

    public WeatherResponse getWeather(String cidade) {
        OpenWeatherResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/data/2.5/weather")
                        .queryParam("q", cidade)
                        .queryParam("appid", apiKey)
                        .queryParam("units", "metric")
                        .queryParam("lang", "pt_br")
                        .build())
                .retrieve()
                .bodyToMono(OpenWeatherResponse.class)
                .onErrorResume(e -> Mono.error(new RuntimeException("Erro ao consultar a API de clima: " + e.getMessage())))
                .block();

        if (response == null) {
            throw new RuntimeException("Dados não encontrados para a cidade: " + cidade);
        }

        double velocidadeVento = ((Number) response.getWind().getOrDefault("speed", 0)).doubleValue() * 3.6;
        double rajadaVento = ((Number) response.getWind().getOrDefault("gust", 0)).doubleValue() * 3.6;
        int coberturaNuvens = ((Number) response.getClouds().getOrDefault("all", 0)).intValue();
        double volumeChuva = response.getRain() != null ?
                ((Number) response.getRain().getOrDefault("1h", 0)).doubleValue() :
                0.0;
        String descricao = (String) response.getWeather().get(0).get("description");
        String nomeCidade = response.getName();
        int umidade = ((Number) response.getMain().getOrDefault("humidity", 0)).intValue();

        return new WeatherResponse(
                nomeCidade,
                velocidadeVento,
                rajadaVento,
                coberturaNuvens,
                volumeChuva,
                descricao,
                umidade
        );
    }
}
