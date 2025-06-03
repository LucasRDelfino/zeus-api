package br.com.zeus_api.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OpenWeatherResponse {
    private Map<String, Object> wind;
    private List<Map<String, Object>> weather;
    private Map<String, Object> main;
    private String name;
}

