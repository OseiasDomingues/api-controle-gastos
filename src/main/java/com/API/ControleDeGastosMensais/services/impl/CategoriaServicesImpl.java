package com.API.ControleDeGastosMensais.services.impl;

import com.API.ControleDeGastosMensais.mappers.CategoriaMapper;
import com.API.ControleDeGastosMensais.models.Categoria;
import com.API.ControleDeGastosMensais.repositories.CategoriaRepository;
import com.API.ControleDeGastosMensais.services.CategoriaServices;
import com.API.ControleDeGastosMensais.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicesImpl implements CategoriaServices {

    @Autowired
    CategoriaRepository categoriaRepository;

    private final CategoriaMapper categoriaMapper = CategoriaMapper.INSTANCE;


    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

}
