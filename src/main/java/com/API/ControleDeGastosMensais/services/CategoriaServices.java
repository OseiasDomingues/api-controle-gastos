package com.API.ControleDeGastosMensais.services;

import com.API.ControleDeGastosMensais.models.Categoria;
import com.API.ControleDeGastosMensais.models.requests.MovimentacaoRequests;
import com.API.ControleDeGastosMensais.models.responses.MovimentacaoResponse;
import org.springframework.validation.BindingResult;

import java.util.List;


public interface CategoriaServices {

    List<Categoria> findAll();
    Categoria findById(Long id);
    Categoria save(Categoria categoria);
}
