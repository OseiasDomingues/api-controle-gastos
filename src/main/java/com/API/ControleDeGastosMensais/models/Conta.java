package com.API.ControleDeGastosMensais.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Conta implements Serializable {

    @Serial
    private static final long serialVersionUID = 6693762186166765711L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal total;
    @OneToMany
    @JoinTable(joinColumns = @JoinColumn, inverseJoinColumns = @JoinColumn)
    @ToString.Exclude
    List<Movimentacao> movimentacao = new ArrayList<>();
    @OneToMany
    @JoinTable(joinColumns = @JoinColumn, inverseJoinColumns = @JoinColumn)
    @ToString.Exclude
    List<Calendario> calendarios = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Conta conta = (Conta) o;
        return id != null && Objects.equals(id, conta.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
