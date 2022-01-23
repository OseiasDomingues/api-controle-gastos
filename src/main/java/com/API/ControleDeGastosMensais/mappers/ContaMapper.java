package com.API.ControleDeGastosMensais.mappers;

import com.API.ControleDeGastosMensais.models.Conta;
import com.API.ControleDeGastosMensais.models.responses.ContaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContaMapper {

    ContaMapper INSTANCE = Mappers.getMapper(ContaMapper.class);

    ContaResponse toResponse(Conta conta);
}
