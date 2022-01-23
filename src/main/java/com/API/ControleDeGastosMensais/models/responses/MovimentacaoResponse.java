package com.API.ControleDeGastosMensais.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovimentacaoResponse {

    private Long id;
    private String descricao;
    private String valor;
    @JsonProperty(value = "DataMovimentacao")
    private String dataMoviment;
    private String tipo;

}
