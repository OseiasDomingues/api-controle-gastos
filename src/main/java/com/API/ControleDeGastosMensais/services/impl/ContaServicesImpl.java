package com.API.ControleDeGastosMensais.services.impl;

import com.API.ControleDeGastosMensais.models.Conta;
import com.API.ControleDeGastosMensais.repositories.ContaRepository;
import com.API.ControleDeGastosMensais.services.ContaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContaServicesImpl implements ContaServices {

    @Autowired
    ContaRepository contaRepository;

    @Override
    public List<Conta> findAll() {
        return contaRepository.findAll();
    }
}
