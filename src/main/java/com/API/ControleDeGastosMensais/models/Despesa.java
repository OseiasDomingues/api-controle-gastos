package com.API.ControleDeGastosMensais.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Despesa extends Movimentacao implements Serializable {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Despesa despesa = (Despesa) o;
        return getId() != null && Objects.equals(getId(), despesa.getId());
    }

    public Despesa(Long id, String name, String valor, String data, Categoria categoria, String tipo) {
        super(id, name, valor, data, categoria, tipo);
    }


    @Override
    public int hashCode() {
        return 0;
    }
}
