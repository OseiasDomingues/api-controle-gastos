package com.API.ControleDeGastosMensais.services;

import com.API.ControleDeGastosMensais.repositories.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarioServices {

    @Autowired
    CalendarioRepository calendarioRepository;

}
