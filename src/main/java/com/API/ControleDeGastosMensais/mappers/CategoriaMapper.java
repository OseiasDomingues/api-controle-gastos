package com.API.ControleDeGastosMensais.mappers;

import com.API.ControleDeGastosMensais.models.Categoria;
import com.API.ControleDeGastosMensais.models.requests.CategoriaMovimentRequests;
import com.API.ControleDeGastosMensais.models.responses.CategoriaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaMovimentRequests toDTO(Categoria categoria);

    CategoriaResponse toResponse(Categoria categoria);
}
