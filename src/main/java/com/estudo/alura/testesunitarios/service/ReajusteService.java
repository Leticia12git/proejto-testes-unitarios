package com.estudo.alura.testesunitarios.service;

import com.estudo.alura.testesunitarios.enumerado.Desempenho;
import com.estudo.alura.testesunitarios.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal reajuste = desempenho.percentualReajuste();
        funcionario.reajustarSalario(reajuste);
    }
}
