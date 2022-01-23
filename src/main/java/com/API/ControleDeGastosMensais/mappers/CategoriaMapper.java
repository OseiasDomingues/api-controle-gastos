package com.API.ControleDeGastosMensais.mappers;

import com.API.ControleDeGastosMensais.models.Categoria;
import com.API.ControleDeGastosMensais.models.requests.CategoriaRequests;
import com.API.ControleDeGastosMensais.models.responses.CategoriaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaRequests toDTO(Categoria categoria);

    Categoria toModel(CategoriaRequests categoriaRequests);

    CategoriaResponse toResponse(Categoria categoria);
}
