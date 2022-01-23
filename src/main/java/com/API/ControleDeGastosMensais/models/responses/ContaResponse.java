package com.API.ControleDeGastosMensais.models.responses;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ContaResponse {

    private Long id;
    private String name;
    private BigDecimal total;
    List<MovimentacaoResponse> movimentacao;

}
