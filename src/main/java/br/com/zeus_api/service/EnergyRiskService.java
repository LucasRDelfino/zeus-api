package br.com.zeus_api.service;

import br.com.zeus_api.dto.WeatherResponse;
import br.com.zeus_api.dto.RiskResponse;
import org.springframework.stereotype.Service;

@Service
public class EnergyRiskService {

    public RiskResponse calcularRisco(WeatherResponse weather) {

        double velocidadeVento = weather.getVelocidadeVento();
        double rajadaVento = weather.getRajadaVento();
        int coberturaNuvens = weather.getCoberturaNuvens();
        double volumeChuva = weather.getVolumeChuva();

        double risco = 0;

        risco += Math.min(velocidadeVento / 100, 0.3);
        risco += Math.min(rajadaVento / 80, 0.25);


        risco += (coberturaNuvens / 100.0) * 0.15;


        risco += Math.min(volumeChuva / 50.0, 0.3);


        risco = Math.min(risco, 1.0);

        double percentual = risco * 100;

        return new RiskResponse(weather.getCidade(), percentual);
    }
}

