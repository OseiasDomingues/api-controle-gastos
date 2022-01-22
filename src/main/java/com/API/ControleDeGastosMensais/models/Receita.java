package com.API.ControleDeGastosMensais.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class Receita extends Movimentacao{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Receita receita = (Receita) o;
        return getId() != null && Objects.equals(getId(), receita.getId());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
