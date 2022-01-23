package com.API.ControleDeGastosMensais.models.responses;

import com.API.ControleDeGastosMensais.models.Mes;
import lombok.Data;

import java.util.List;

@Data
public class CalendarioResponse {

    private Long id;
    private String ano;
    private Mes mes;
    private Double salario;
    private List<CalendarioResponse> categorias;
}
