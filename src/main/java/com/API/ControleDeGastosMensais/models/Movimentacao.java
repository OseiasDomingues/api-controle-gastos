package com.API.ControleDeGastosMensais.models;

import com.API.ControleDeGastosMensais.utils.DateUtils;
import com.API.ControleDeGastosMensais.utils.MoneyUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private String dataMoviment;
    @OneToOne
    private Categoria categoria;

    public Movimentacao(Long id, String descricao, String valor, String dataMoviment, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = new BigDecimal(valor);
        this.dataMoviment = DateUtils.formatDate(dataMoviment);
        this.categoria = categoria;
    }

    public String getValor() {
        return MoneyUtils.formatMoney(valor);
    }

    @JsonIgnore
    public String getValorForSet() {
        return valor.toString();
    }

    @JsonIgnore
    public BigDecimal getValorForCalc() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = MoneyUtils.setMoney(valor);
    }
}
