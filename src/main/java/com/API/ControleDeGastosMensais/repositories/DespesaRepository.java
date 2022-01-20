package com.API.ControleDeGastosMensais.repositories;

import com.API.ControleDeGastosMensais.models.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa,Long> {
}
