package br.com.zeus_api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskResponse {
    private String cidade;
    private double probabilidadeQuedaEnergia;
}

