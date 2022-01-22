package com.API.ControleDeGastosMensais.repositories;

import com.API.ControleDeGastosMensais.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
