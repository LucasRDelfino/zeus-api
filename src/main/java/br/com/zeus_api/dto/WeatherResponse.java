package br.com.zeus_api.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {
    private String cidade;
    private double velocidadeVento;
    private double rajadaVento;
    private int coberturaNuvens;
    private double volumeChuva;
    private String descricao;
    private int umidade;
}