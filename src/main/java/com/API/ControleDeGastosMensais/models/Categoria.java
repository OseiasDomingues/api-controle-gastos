package com.API.ControleDeGastosMensais.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Table(name = "Categoria")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Categoria implements Serializable {

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
    @ToString.Exclude
    private List<Movimentacao> movimentacao = new ArrayList<>();
    private Double novaDespesa;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Categoria categoria = (Categoria) o;
        return id != null && Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
