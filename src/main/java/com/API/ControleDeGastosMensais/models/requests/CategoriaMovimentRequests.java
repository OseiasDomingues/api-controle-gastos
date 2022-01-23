package com.API.ControleDeGastosMensais.models.requests;

import com.API.ControleDeGastosMensais.models.Conta;
import com.API.ControleDeGastosMensais.models.responses.ContaResponse;
import lombok.Data;

@Data
public class CategoriaMovimentRequests {

    private Long id;
    private ContaMovimentRequests conta;

}
