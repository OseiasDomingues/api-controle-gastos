package com.API.ControleDeGastosMensais.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Table(name = "Conta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Conta implements Serializable {

    @Serial
    private static final long serialVersionUID = 2079414738731575051L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double valorInicial;
    private Double valorFinal;
    @OneToMany
    @JoinTable(joinColumns = @JoinColumn, inverseJoinColumns = @JoinColumn)
    private List<Despesa> despesas = new ArrayList<>();
    private Double novaDespesa;


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
