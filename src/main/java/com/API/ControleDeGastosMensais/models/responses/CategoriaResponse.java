package com.API.ControleDeGastosMensais.models.responses;

import lombok.Data;

import java.util.List;

@Data
public class CategoriaResponse {

    private Long id;
    private String name;
    private String valorInicial;
    private String valorFinal;
    private List<MovimentacaoResponse> movimentacao;

}
