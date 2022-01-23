package com.API.ControleDeGastosMensais.mappers;

import com.API.ControleDeGastosMensais.models.Despesa;
import com.API.ControleDeGastosMensais.models.Movimentacao;
import com.API.ControleDeGastosMensais.models.requests.MovimentacaoRequests;
import com.API.ControleDeGastosMensais.models.responses.MovimentacaoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovimentacaoMapper {

    MovimentacaoMapper INSTANCE = Mappers.getMapper(MovimentacaoMapper.class);

    MovimentacaoRequests toDTO(Movimentacao movimentacao);

    Despesa toModel(MovimentacaoRequests movimentacaoRequests);

    MovimentacaoResponse toResponse(Movimentacao movimentacao);
}

