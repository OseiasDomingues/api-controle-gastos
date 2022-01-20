package com.API.ControleDeGastosMensais.config;

import com.API.ControleDeGastosMensais.models.Calendario;
import com.API.ControleDeGastosMensais.models.Conta;
import com.API.ControleDeGastosMensais.models.Despesa;
import com.API.ControleDeGastosMensais.models.Mes;
import com.API.ControleDeGastosMensais.repositories.CalendarioRepository;
import com.API.ControleDeGastosMensais.repositories.ContaRepository;
import com.API.ControleDeGastosMensais.repositories.DespesaRepository;
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
    DespesaRepository despesaRepository;

    @PostConstruct
    public void mock(){
        Despesa d1 = new Despesa(null, "Haburger", 50.0);
        Despesa d2 = new Despesa(null, "Haburger", 50.0);
        Despesa d3 = new Despesa(null, "Haburger", 50.0);
        Despesa d4 = new Despesa(null, "Haburger", 50.0);
        Despesa d5 = new Despesa(null, "Haburger", 50.0);
        Despesa d6 = new Despesa(null, "Haburger", 50.0);

        List<Despesa> despesas1 = new ArrayList<>();
        List<Despesa> despesas2 = new ArrayList<>();
        List<Despesa> despesas3 = new ArrayList<>();


        despesas1.addAll(Arrays.asList(d1,d2));
        despesas2.addAll(Arrays.asList(d3,d4));
        despesas3.addAll(Arrays.asList(d5,d6));

        despesaRepository.saveAll(Arrays.asList(d1,d2,d3,d4,d5,d6));

        Conta acc1 = new Conta(null,"Conta Lazer", 100.00,100.00,despesas1,null);
        Conta acc2 = new Conta(null,"Conta Ajusda", 100.00,100.00,despesas2,null);
        Conta acc3 = new Conta(null,"Conta Parcela", 100.00,100.00,despesas3,null);

        List<Conta> contas = new ArrayList<>();

        contas.add(acc1);
        contas.add(acc2);
        contas.add(acc3);

        contaRepository.saveAll(Arrays.asList(acc1,acc2,acc3));

        Calendario c1 = new Calendario(null, "2020",Mes.JANEIRO ,2000.10,contas);

        calendarioRepository.save(c1);


    }
}
