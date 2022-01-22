package com.API.ControleDeGastosMensais.controllers;

import com.API.ControleDeGastosMensais.models.Conta;
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
@Api
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ContaController {

    @Autowired
    ContaServices contaServices;

    @ApiOperation(value = "Retorna todas as contas")
    @GetMapping("/contas")
    public ResponseEntity<List<Conta>> findAll(){
        List<Conta> contaList = contaServices.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(contaList);
    }

}
