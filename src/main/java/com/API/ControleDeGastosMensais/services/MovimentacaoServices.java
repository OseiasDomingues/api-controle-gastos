package com.API.ControleDeGastosMensais.services;

import com.API.ControleDeGastosMensais.models.Movimentacao;
import com.API.ControleDeGastosMensais.models.requests.MovimentacaoRequests;
import com.API.ControleDeGastosMensais.models.responses.MovimentacaoResponse;
import org.springframework.validation.BindingResult;

import java.util.List;


public interface MovimentacaoServices {

    List<Movimentacao> findAll();

    MovimentacaoResponse insereDespesa(MovimentacaoRequests movimentacaoRequests, BindingResult bindingResult);

}
