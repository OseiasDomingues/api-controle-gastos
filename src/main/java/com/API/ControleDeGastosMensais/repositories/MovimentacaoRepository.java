package com.API.ControleDeGastosMensais.repositories;

import com.API.ControleDeGastosMensais.models.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao,Long> {
}
