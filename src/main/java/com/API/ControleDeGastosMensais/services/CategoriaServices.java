package com.API.ControleDeGastosMensais.services;

import com.API.ControleDeGastosMensais.models.Categoria;
import com.API.ControleDeGastosMensais.models.Movimentacao;

import java.util.List;


public interface CategoriaServices {

    public List<Categoria> findAll();
    public Movimentacao novaMovimentacao(Movimentacao movimentacao,Long id);
}
