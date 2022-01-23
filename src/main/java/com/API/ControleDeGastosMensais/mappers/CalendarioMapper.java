package com.API.ControleDeGastosMensais.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CalendarioMapper {

    CalendarioMapper INSTANCE = Mappers.getMapper(CalendarioMapper.class);
}
