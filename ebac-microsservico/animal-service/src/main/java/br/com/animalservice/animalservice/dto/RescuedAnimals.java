package br.com.animalservice.animalservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RescuedAnimals {

    @JsonProperty("nomeRecebedor")
    private String nomeRecebedor;
    @JsonProperty("qtdAnimais")
    private Long qtdAnimais;

    public RescuedAnimals(String nomeRecebedor, Long qtdAnimais) {
        this.nomeRecebedor = nomeRecebedor;
        this.qtdAnimais = qtdAnimais;
    }

}
