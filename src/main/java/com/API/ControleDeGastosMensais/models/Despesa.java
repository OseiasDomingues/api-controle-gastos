package com.API.ControleDeGastosMensais.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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

    public Despesa(Long id, String name, String valor, String data,Categoria categoria) {
        super(id, name, valor, data, categoria);
    }


    @Override
    public int hashCode() {
        return 0;
    }
}
