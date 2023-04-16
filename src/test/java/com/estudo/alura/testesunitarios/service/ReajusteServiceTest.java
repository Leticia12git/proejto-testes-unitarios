package com.estudo.alura.testesunitarios.service;

import com.estudo.alura.testesunitarios.enumerado.Desempenho;
import com.estudo.alura.testesunitarios.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReajusteServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("Fulano", LocalDate.now(), new BigDecimal("2000.00"));
    }

    @Test
     void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("2060.00"), funcionario.getSalario());
    }

    @Test
     void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("2300.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo() {
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("2400.00"), funcionario.getSalario());
    }

}