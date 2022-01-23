package com.API.ControleDeGastosMensais.models.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MovimentacaoRequests {

    private Long id;
    @NotEmpty
    private String descricao;
    @NotEmpty
    private String valor;
    @NotEmpty
    private String dataMoviment;
    @NotNull
    private CategoriaMovimentRequests categoria;
    @NotEmpty
    private String tipo;

}
