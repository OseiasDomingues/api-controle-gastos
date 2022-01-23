package com.API.ControleDeGastosMensais.services;

import com.API.ControleDeGastosMensais.models.Calendario;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CalendarioServices {

    public List<Calendario> findAll();


}
