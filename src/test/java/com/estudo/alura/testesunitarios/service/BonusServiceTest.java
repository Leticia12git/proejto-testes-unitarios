package com.estudo.alura.testesunitarios.service;

import com.estudo.alura.testesunitarios.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;



class BonusServiceTest {

    private BonusService bonusService;

    @BeforeEach
    public void inicializa() {
        this.bonusService = new BonusService();
    }

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        try {
            bonusService.calcularBonus(criarFuncionario(new BigDecimal("25000")));
            fail("nao deu exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Funcionario com salario maior do que R$1000 nao pode receber bonus!", e.getMessage());
        }
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));
        assertEquals(new BigDecimal("250.00"), bonus);

    }


    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.00"), bonus);

    }

        private Funcionario criarFuncionario(BigDecimal salario) {
            return new Funcionario("Rodrigo", LocalDate.now(), salario);
        }


    }