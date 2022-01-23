package com.API.ControleDeGastosMensais.models;

import com.API.ControleDeGastosMensais.utils.MoneyUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Table(name = "Categoria")
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
    private BigDecimal valorInicial;
    private BigDecimal valorFinal;
    @OneToMany
    @JoinTable(joinColumns = @JoinColumn, inverseJoinColumns = @JoinColumn)
    @ToString.Exclude
    private List<Movimentacao> movimentacao = new ArrayList<>();
    @ManyToOne
    private Conta conta;


    public Categoria(Long id, String name, String valorInicial, String valorFinal, List<Movimentacao> movimentacao,Conta conta ) {
        this.id = id;
        this.name = name;
        this.valorInicial = new BigDecimal(valorInicial);
        this.valorFinal = new BigDecimal(valorFinal);
        this.movimentacao = movimentacao;
        this.conta = conta;

    }

    /*VALOR INICIAL*/

    //Valor com cifrão
    public String getValorInicial() {
        return MoneyUtils.formatMoney(valorInicial);
    }

    public void setValorInicial(String valorInicial) {
        this.valorInicial = MoneyUtils.setMoney(valorInicial);
    }
    //Valor string para Set com Get
    @JsonIgnore
    public String getValorInicialForSet() {
        return valorInicial.toString();
    }
    //Valor para calculos
    @JsonIgnore
    public BigDecimal getValorInicialForCalc() {
        return valorInicial;
    }

    /*VALOR FINAL*/

    //Valor com cifrão
    public String getValorFinal() {
        return MoneyUtils.formatMoney(valorFinal);
    }

    public void setValorFinal(String valorInicial) {
        this.valorFinal = MoneyUtils.setMoney(valorInicial);
    }
    //Valor string para Set com Get
    @JsonIgnore
    public String getValorFinalForSet() {
        return valorFinal.toString();
    }
    //Valor para calculos
    @JsonIgnore
    public BigDecimal getValorFinalForCalc() {
        return valorFinal;
    }


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
