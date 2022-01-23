package com.API.ControleDeGastosMensais.services.impl;

import com.API.ControleDeGastosMensais.mappers.MovimentacaoMapper;
import com.API.ControleDeGastosMensais.models.Categoria;
import com.API.ControleDeGastosMensais.models.Despesa;
import com.API.ControleDeGastosMensais.models.Movimentacao;
import com.API.ControleDeGastosMensais.models.requests.MovimentacaoRequests;
import com.API.ControleDeGastosMensais.models.responses.MovimentacaoResponse;
import com.API.ControleDeGastosMensais.repositories.MovimentacaoRepository;
import com.API.ControleDeGastosMensais.services.CategoriaServices;
import com.API.ControleDeGastosMensais.services.MovimentacaoServices;
import com.API.ControleDeGastosMensais.services.exceptions.FieldInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
@Service
public class MovimentacaoServicesImpl implements MovimentacaoServices {

    private final MovimentacaoMapper movimentacaoMapper = MovimentacaoMapper.INSTANCE;

    @Autowired
    MovimentacaoRepository movimentacaoRepository;
    @Autowired
    CategoriaServices categoriaServices;

    @Override
    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    @Override
    public MovimentacaoResponse insereDespesa(MovimentacaoRequests movimentacaoRequests, BindingResult bindingResult) {
        validarCampos(movimentacaoRequests, bindingResult);

        Movimentacao movimentacaoModel = movimentacaoMapper.toModel(movimentacaoRequests);//DTO para Model

        Categoria categoriaModel = categoriaServices.findById(movimentacaoModel.getCategoria().getId());//Buscas categoria

        //Cria e salva a nova despesa
        Movimentacao novaDespesa = new Despesa(null, movimentacaoModel.getDescricao(), movimentacaoModel.getValorForSet(), "22-01-2022 13:46:55",categoriaModel,"D");
        Movimentacao despesaSalva = movimentacaoRepository.save(novaDespesa);

        //Adicionar a nova despesa a categoria buscada e salva
        categoriaModel.getMovimentacao().add(despesaSalva);
        categoriaServices.save(categoriaModel);

        //model para DTO
        return movimentacaoMapper.toResponse(despesaSalva);
    }

    private void validarCampos(MovimentacaoRequests movimentacaoRequests, BindingResult bindingResult) {
        if(movimentacaoRequests == null){
            throw new NullPointerException("Este objeto retornou null!");
        }
        if(bindingResult.hasErrors()){
            throw new FieldInvalidException("Algum campo está invalido!");
        }
    }
}
