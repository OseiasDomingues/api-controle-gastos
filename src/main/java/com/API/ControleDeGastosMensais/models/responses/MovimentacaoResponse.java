package com.API.ControleDeGastosMensais.models.responses;

import com.API.ControleDeGastosMensais.models.requests.CategoriaRequests;
import lombok.Data;

@Data
public class MovimentacaoResponse {

    private Long id;
    private String descricao;
    private String valor;
    private String dataMoviment;

}
