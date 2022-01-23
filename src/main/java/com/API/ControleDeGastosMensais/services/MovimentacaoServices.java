package com.API.ControleDeGastosMensais.services;

import com.API.ControleDeGastosMensais.models.Movimentacao;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MovimentacaoServices {

    public List<Movimentacao> findAll();
}
