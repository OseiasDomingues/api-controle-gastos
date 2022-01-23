package com.API.ControleDeGastosMensais.controllers;

import com.API.ControleDeGastosMensais.mappers.MovimentacaoMapper;
import com.API.ControleDeGastosMensais.models.Movimentacao;
import com.API.ControleDeGastosMensais.models.requests.MovimentacaoRequests;
import com.API.ControleDeGastosMensais.services.MovimentacaoServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MovimentacaoController {
    @Autowired
    MovimentacaoServices movimentacaoServices;

    private final MovimentacaoMapper movimentacaoMapper = MovimentacaoMapper.INSTANCE;

    @ApiOperation(value = "Retorna todas as movimentações")
    @GetMapping("/moviment")
    public ResponseEntity<List<MovimentacaoRequests>> findAll(){
        List<Movimentacao> movimentacaoList = movimentacaoServices.findAll();
        List<MovimentacaoRequests> movimentacaoRequests = movimentacaoList.stream().map(movimentacaoMapper::toDTO).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoRequests);
    }
}
