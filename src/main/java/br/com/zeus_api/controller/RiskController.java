package br.com.zeus_api.controller;

import br.com.zeus_api.dto.RiskResponse;
import br.com.zeus_api.dto.WeatherResponse;
import br.com.zeus_api.service.EnergyRiskService;
import br.com.zeus_api.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RiskController {

    private final WeatherService weatherService;
    private final EnergyRiskService energyRiskService;

    public RiskController(WeatherService weatherService, EnergyRiskService energyRiskService) {
        this.weatherService = weatherService;
        this.energyRiskService = energyRiskService;
    }

    @GetMapping("/risk")
    public RiskResponse getRisco(@RequestParam String cidade) {
        WeatherResponse weather = weatherService.getWeather(cidade);
        return energyRiskService.calcularRisco(weather);
    }
}

