package com.API.ControleDeGastosMensais.services;

import com.API.ControleDeGastosMensais.models.Conta;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ContaServices {

    public List<Conta> findAll();

}
