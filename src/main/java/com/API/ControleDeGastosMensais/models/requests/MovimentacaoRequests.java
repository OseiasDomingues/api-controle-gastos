package com.API.ControleDeGastosMensais.models.requests;

import lombok.Data;

@Data
public class MovimentacaoRequests {

    private Long id;
    private String descricao;
    private String valor;
    private String dataMoviment;
    private CategoriaRequests categoria;

}
