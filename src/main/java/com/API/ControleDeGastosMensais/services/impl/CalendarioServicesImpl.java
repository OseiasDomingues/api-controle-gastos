package com.API.ControleDeGastosMensais.services.impl;

import com.API.ControleDeGastosMensais.models.Calendario;
import com.API.ControleDeGastosMensais.repositories.CalendarioRepository;
import com.API.ControleDeGastosMensais.services.CalendarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarioServicesImpl implements CalendarioServices {

    @Autowired
    CalendarioRepository calendarioRepository;

    @Override
    public List<Calendario> findAll() {

        return calendarioRepository.findAll();
    }
}
