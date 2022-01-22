package com.API.ControleDeGastosMensais.services;

import com.API.ControleDeGastosMensais.models.Conta;
import com.API.ControleDeGastosMensais.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServices {

    @Autowired
    ContaRepository contaRepository;

    public List<Conta> findAll(){
        return contaRepository.findAll();
    }

}
