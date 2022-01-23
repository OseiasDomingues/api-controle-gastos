package com.API.ControleDeGastosMensais.controllers;

import com.API.ControleDeGastosMensais.mappers.CategoriaMapper;
import com.API.ControleDeGastosMensais.mappers.ContaMapper;
import com.API.ControleDeGastosMensais.models.Conta;
import com.API.ControleDeGastosMensais.models.responses.ContaResponse;
import com.API.ControleDeGastosMensais.services.ContaServices;
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
public class ContaController {

    @Autowired
    ContaServices contaServices;

    private final ContaMapper contaMapper = ContaMapper.INSTANCE;

    @ApiOperation(value = "Retorna todas as contas")
    @GetMapping("/contas")
    public ResponseEntity<List<ContaResponse>> findAll(){
        List<Conta> contaList = contaServices.findAll();
        List<ContaResponse> contaResponses = contaList.stream().map(contaMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(contaResponses);
    }

}
