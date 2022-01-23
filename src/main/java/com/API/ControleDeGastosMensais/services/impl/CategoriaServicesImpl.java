package com.API.ControleDeGastosMensais.services.impl;

import com.API.ControleDeGastosMensais.models.Categoria;
import com.API.ControleDeGastosMensais.models.Despesa;
import com.API.ControleDeGastosMensais.models.Movimentacao;
import com.API.ControleDeGastosMensais.repositories.CategoriaRepository;
import com.API.ControleDeGastosMensais.repositories.MovimentacaoRepository;
import com.API.ControleDeGastosMensais.services.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CategoriaServicesImpl implements CategoriaServices {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

 /*   public Categoria findById(Long id){
        return categoriaRepository.findBy(id);
    }*/

    @Override
    public Movimentacao novaMovimentacao(Movimentacao movimentacao,Long id) {
        Categoria categoria = categoriaRepository.getById(movimentacao.getCategoria().getId());
        Movimentacao nova = new Despesa(null, movimentacao.getDescricao(), movimentacao.getValorForSet(), "22-01-2022 13:46:55",categoria);
        Movimentacao movimentacaoSalva = movimentacaoRepository.save(nova);
        categoria.getMovimentacao().add(nova);
        categoriaRepository.save(categoria);
        return movimentacaoSalva;


    }
}
