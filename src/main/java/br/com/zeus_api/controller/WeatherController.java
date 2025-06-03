package br.com.zeus_api.controller;

import br.com.zeus_api.dto.WeatherResponse;
import br.com.zeus_api.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/weather")
    public WeatherResponse getWeather(@RequestParam String cidade) {
        return weatherService.getWeather(cidade);
    }
}
