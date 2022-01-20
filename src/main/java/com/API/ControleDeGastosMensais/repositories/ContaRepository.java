package com.API.ControleDeGastosMensais.repositories;

import com.API.ControleDeGastosMensais.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
