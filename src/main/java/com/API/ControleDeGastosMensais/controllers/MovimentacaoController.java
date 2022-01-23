package com.API.ControleDeGastosMensais.controllers;

import com.API.ControleDeGastosMensais.mappers.CategoriaMapper;
import com.API.ControleDeGastosMensais.mappers.MovimentacaoMapper;
import com.API.ControleDeGastosMensais.models.Movimentacao;
import com.API.ControleDeGastosMensais.models.requests.MovimentacaoRequests;
import com.API.ControleDeGastosMensais.models.responses.MovimentacaoResponse;
import com.API.ControleDeGastosMensais.services.ContaServices;
import com.API.ControleDeGastosMensais.services.MovimentacaoServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MovimentacaoController {


    private final MovimentacaoMapper movimentacaoMapper = MovimentacaoMapper.INSTANCE;

    @Autowired
    MovimentacaoServices movimentacaoServices;

    @ApiOperation(value = "Retorna todas as movimentações")
    @GetMapping("/movimentacao")
    public ResponseEntity<List<MovimentacaoRequests>> findAll(){
        List<Movimentacao> movimentacaoList = movimentacaoServices.findAll();
        List<MovimentacaoRequests> movimentacaoRequests = movimentacaoList.stream().map(movimentacaoMapper::toDTO).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoRequests);
    }
    @PostMapping("/movimentacao")
    public ResponseEntity<MovimentacaoResponse> insereDespesa(@Valid @RequestBody MovimentacaoRequests movimentacaoRequests, BindingResult bindingResult) {
        MovimentacaoResponse movimentacaoResponse = movimentacaoServices.insereDespesa(movimentacaoRequests,bindingResult);
        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoResponse);
    }
}
