package br.com.zeus_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class BrazilWeatherAlert {
    @JsonProperty("codigo")
    private String alertCode;

    @JsonProperty("titulo")
    private String title;

    @JsonProperty("severidade")
    private String severityLevel;

    @JsonProperty("descricao")
    private String detailedDescription;

    @JsonProperty("dataEmissao")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime issueTime;

    @JsonProperty("dataValidade")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime expirationTime;

    @JsonProperty("tipo")
    private String hazardType;

    @JsonProperty("uf")
    private String state;

    @JsonProperty("municipiosAfetados")
    private List<String> affectedCities;

    @JsonProperty("intensidade")
    private String intensity;

    @JsonProperty("probabilidade")
    private Integer probability;

    @JsonProperty("recomendacoes")
    private List<String> recommendations;

    @JsonProperty("fontes")
    private List<String> sources;

    @JsonProperty("geometria")
    private Map<String, Object> geoData;
}