package com.API.ControleDeGastosMensais.config;

import com.API.ControleDeGastosMensais.models.*;
import com.API.ControleDeGastosMensais.repositories.CalendarioRepository;
import com.API.ControleDeGastosMensais.repositories.CategoriaRepository;
import com.API.ControleDeGastosMensais.repositories.ContaRepository;
import com.API.ControleDeGastosMensais.repositories.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    CalendarioRepository calendarioRepository;
    @Autowired
    ContaRepository contaRepository;
    @Autowired
    MovimentacaoRepository movimentacaoRepository;
    @Autowired
    CategoriaRepository categoriaRepository;

    @PostConstruct
    public void mock(){
        Movimentacao d1 = new Despesa(null, "Haburger", 50.0);
        Movimentacao d2 = new Despesa(null, "Haburger", 50.0);
        Movimentacao d3 = new Despesa(null, "Haburger", 50.0);
        Movimentacao d4 = new Despesa(null, "Haburger", 50.0);
        Movimentacao d5 = new Despesa(null, "Haburger", 50.0);
        Movimentacao d6 = new Despesa(null, "Haburger", 50.0);

        List<Movimentacao> m1 = new ArrayList<>();
        List<Movimentacao> m2 = new ArrayList<>();
        List<Movimentacao> m3 = new ArrayList<>();


        m1.addAll(Arrays.asList(d1,d2));
        m2.addAll(Arrays.asList(d3,d4));
        m3.addAll(Arrays.asList(d5,d6));

        movimentacaoRepository.saveAll(Arrays.asList(d1,d2,d3,d4,d5,d6));

        Categoria cat1 = new Categoria(null,"Conta Lazer", 100.00,100.00,m1,null);
        Categoria cat2 = new Categoria(null,"Conta Ajusda", 100.00,100.00,m2,null);
        Categoria cat3 = new Categoria(null,"Conta Parcela", 100.00,100.00,m3,null);

        List<Categoria> categorias = new ArrayList<>();

        categorias.add(cat1);
        categorias.add(cat2);
        categorias.add(cat3);

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        Calendario c1 = new Calendario(null, "2020",Mes.JANEIRO ,2000.10, categorias);

        List<Calendario> calendarioList = new ArrayList<>();

        calendarioList.add(c1);

        calendarioRepository.save(c1);

        Conta caju = new Conta(null, "Caju",calendarioList);

        contaRepository.save(caju);
    }
}
