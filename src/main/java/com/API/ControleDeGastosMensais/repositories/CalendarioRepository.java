package com.API.ControleDeGastosMensais.repositories;

import com.API.ControleDeGastosMensais.models.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarioRepository extends JpaRepository<Calendario, Long> {
}
