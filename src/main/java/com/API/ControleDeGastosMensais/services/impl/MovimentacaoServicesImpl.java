package com.API.ControleDeGastosMensais.services.impl;

import com.API.ControleDeGastosMensais.models.Movimentacao;
import com.API.ControleDeGastosMensais.repositories.MovimentacaoRepository;
import com.API.ControleDeGastosMensais.services.MovimentacaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovimentacaoServicesImpl implements MovimentacaoServices {

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @Override
    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }
}
