package com.API.ControleDeGastosMensais.controllers;

import com.API.ControleDeGastosMensais.mappers.CategoriaMapper;
import com.API.ControleDeGastosMensais.mappers.MovimentacaoMapper;
import com.API.ControleDeGastosMensais.models.Categoria;
import com.API.ControleDeGastosMensais.models.Movimentacao;
import com.API.ControleDeGastosMensais.models.requests.MovimentacaoRequests;
import com.API.ControleDeGastosMensais.models.responses.CategoriaResponse;
import com.API.ControleDeGastosMensais.models.responses.MovimentacaoResponse;
import com.API.ControleDeGastosMensais.services.CategoriaServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CategoriaController {

    @Autowired
    CategoriaServices categoriaServices;

    private final CategoriaMapper categoriaMapper = CategoriaMapper.INSTANCE;

    private final MovimentacaoMapper movimentacaoMapper = MovimentacaoMapper.INSTANCE;


    @ApiOperation(value = "Retorna todas as categorias")
    @GetMapping("/categoria")
    public ResponseEntity<List<CategoriaResponse>> findAll(){
        List<Categoria> categoriaList = categoriaServices.findAll();
        List<CategoriaResponse> categoriaResponses = categoriaList.stream().map(categoriaMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(categoriaResponses);
    }
    @PostMapping("/categoria")
    public ResponseEntity<MovimentacaoResponse> novaMovimentacao(@RequestBody MovimentacaoRequests movimentacaoRequests) {
        System.out.println(movimentacaoRequests.toString());
        Movimentacao movimentacao = movimentacaoMapper.toModel(movimentacaoRequests);
        Movimentacao movimentacaoFinal = categoriaServices.novaMovimentacao(movimentacao, movimentacao.getId());
        MovimentacaoResponse movimentacaoResponse = movimentacaoMapper.toResponse(movimentacaoFinal);
        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoResponse);
    }

}
