package com.API.ControleDeGastosMensais.controllers;

import com.API.ControleDeGastosMensais.mappers.CategoriaMapper;
import com.API.ControleDeGastosMensais.mappers.MovimentacaoMapper;
import com.API.ControleDeGastosMensais.models.Categoria;
import com.API.ControleDeGastosMensais.models.requests.MovimentacaoRequests;
import com.API.ControleDeGastosMensais.models.responses.CategoriaResponse;
import com.API.ControleDeGastosMensais.models.responses.MovimentacaoResponse;
import com.API.ControleDeGastosMensais.services.CategoriaServices;
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

@Api(value = "Controller Categoria")
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CategoriaController {

    @Autowired
    CategoriaServices categoriaServices;

    private final CategoriaMapper categoriaMapper = CategoriaMapper.INSTANCE;



    @ApiOperation(value = "Retorna todas as categorias")
    @GetMapping("/categoria")
    public ResponseEntity<List<CategoriaResponse>> findAll(){
        List<Categoria> categoriaList = categoriaServices.findAll();
        List<CategoriaResponse> categoriaResponses = categoriaList.stream().map(categoriaMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(categoriaResponses);
    }


}
