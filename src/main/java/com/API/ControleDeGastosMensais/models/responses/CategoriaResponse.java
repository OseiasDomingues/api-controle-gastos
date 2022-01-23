package com.API.ControleDeGastosMensais.models.responses;

import com.API.ControleDeGastosMensais.models.Despesa;
import com.API.ControleDeGastosMensais.models.Movimentacao;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class CategoriaResponse {

    private Long id;
    private String name;
    private String valorInicial;
    private String valorFinal;
    private List<MovimentacaoResponse> movimentacao;
    private String novaDespesa;

}
