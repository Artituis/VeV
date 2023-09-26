package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.CentroDistribuicao.SITUACAO;
import com.example.CentroDistribuicao.TIPOPOSTO;

public class CentroDistribuicaoTest {
    
    @Test
    void Q2() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        int[] saidaEsperada = {-21};
        Assertions.assertArrayEquals(saidaEsperada, centro.encomendaCombustivel(20000, TIPOPOSTO.COMUM) );

    }

    @Test
    void Q1T1S1() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        int[] saidaEsperada = {495, 9930, 2475};
        Assertions.assertArrayEquals(saidaEsperada, centro.encomendaCombustivel(100, TIPOPOSTO.COMUM) );

    }
    
    @Test
    void Q1T1S2() {
        CentroDistribuicao centro = new CentroDistribuicao(200,10000,2500);
        int[] saidaEsperada = {195, 9930, 2475};
        Assertions.assertArrayEquals(saidaEsperada, centro.encomendaCombustivel(200, TIPOPOSTO.COMUM) );

    }

    @Test
    void Q1T1S3() {
        CentroDistribuicao centro = new CentroDistribuicao(120,10000,2500);
        int[] saidaEsperada = {-14};
        Assertions.assertArrayEquals(saidaEsperada, centro.encomendaCombustivel(60, TIPOPOSTO.COMUM) );

    }

    @Test
    void Q1T2S1() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        int[] saidaEsperada = {495, 9930, 2475};
        Assertions.assertArrayEquals(saidaEsperada, centro.encomendaCombustivel(100, TIPOPOSTO.ESTRATEGICO) );

    }

    @Test
    void Q1T2S2() {
        CentroDistribuicao centro = new CentroDistribuicao(240,10000,2500);
        int[] saidaEsperada = {235, 9930, 2475};
        Assertions.assertArrayEquals(saidaEsperada, centro.encomendaCombustivel(100, TIPOPOSTO.ESTRATEGICO) );

    }

    @Test
    void Q1T2S3() {
        CentroDistribuicao centro = new CentroDistribuicao(100,10000,2500);
        int[] saidaEsperada = {95, 9930, 2475};
        Assertions.assertArrayEquals(saidaEsperada, centro.encomendaCombustivel(200, TIPOPOSTO.ESTRATEGICO) );

    }

    @Test
    void ENTRADA_INVALIDA() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        int[] saidaEsperada = {-7};
        Assertions.assertArrayEquals(saidaEsperada, centro.encomendaCombustivel(-1, TIPOPOSTO.COMUM) );

    }

    @Test
    void L1() {
        CentroDistribuicao centro = new CentroDistribuicao(250,5001,1251);
        Assertions.assertEquals(SITUACAO.NORMAL, centro.getSituacao() );

    }

    @Test
    void L2() {
        CentroDistribuicao centro = new CentroDistribuicao(249,5001,1251);
        Assertions.assertEquals(SITUACAO.SOBRAVISO, centro.getSituacao() );

    }

    @Test
    void L3() {
        CentroDistribuicao centro = new CentroDistribuicao(251,5000,1251);
        Assertions.assertEquals(SITUACAO.NORMAL, centro.getSituacao() );

    }

    @Test
    void L4() {
        CentroDistribuicao centro = new CentroDistribuicao(251,4999,1251);
        Assertions.assertEquals(SITUACAO.SOBRAVISO, centro.getSituacao() );

    }

    @Test
    void L5() {
        CentroDistribuicao centro = new CentroDistribuicao(251,5001,1250);
        Assertions.assertEquals(SITUACAO.NORMAL, centro.getSituacao() );

    }

    @Test
    void L6() {
        CentroDistribuicao centro = new CentroDistribuicao(251,5001,1249);
        Assertions.assertEquals(SITUACAO.SOBRAVISO, centro.getSituacao() );

    }

    @Test
    void L7() {
        CentroDistribuicao centro = new CentroDistribuicao(126,2501,625);
        Assertions.assertEquals(SITUACAO.SOBRAVISO, centro.getSituacao() );

    }

    @Test
    void L8() {
        CentroDistribuicao centro = new CentroDistribuicao(124,2501,626);
        Assertions.assertEquals(SITUACAO.EMERGENCIA, centro.getSituacao() );

    }

    @Test
    void L9() {
        CentroDistribuicao centro = new CentroDistribuicao(126,2500,626);
        Assertions.assertEquals(SITUACAO.SOBRAVISO, centro.getSituacao() );

    }

    @Test
    void L10() {
        CentroDistribuicao centro = new CentroDistribuicao(126,2499,626);
        Assertions.assertEquals(SITUACAO.EMERGENCIA, centro.getSituacao() );

    }

    @Test
    void L11() {
        CentroDistribuicao centro = new CentroDistribuicao(126,2501,626);
        Assertions.assertEquals(SITUACAO.SOBRAVISO, centro.getSituacao() );

    }

    @Test
    void L12() {
        CentroDistribuicao centro = new CentroDistribuicao(126,2501,524);
        Assertions.assertEquals(SITUACAO.EMERGENCIA, centro.getSituacao() );

    }

    @Test
    void M1() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        centro.encomendaCombustivel(100, TIPOPOSTO.COMUM);
        Assertions.assertEquals(SITUACAO.NORMAL, centro.getSituacao());
    }

    @Test
    void M2() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        centro.encomendaCombustivel(5100, TIPOPOSTO.COMUM);
        Assertions.assertEquals(SITUACAO.SOBRAVISO, centro.getSituacao());
    }

    @Test
    void M3() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        centro.encomendaCombustivel(5100, TIPOPOSTO.COMUM);
        centro.recebeAditivo(200);
        centro.recebeAlcool(200);
        Assertions.assertEquals(SITUACAO.NORMAL, centro.getSituacao());
    }

    @Test
    void M4() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        centro.encomendaCombustivel(5100, TIPOPOSTO.COMUM);
        centro.encomendaCombustivel(100, TIPOPOSTO.COMUM);
        Assertions.assertEquals(SITUACAO.SOBRAVISO, centro.getSituacao());
    }

    @Test
    void M5() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        centro.encomendaCombustivel(5100, TIPOPOSTO.COMUM);
        centro.encomendaCombustivel(2500, TIPOPOSTO.ESTRATEGICO); 
        Assertions.assertEquals(SITUACAO.EMERGENCIA, centro.getSituacao());
    }
    
    @Test
    void M6() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        centro.encomendaCombustivel(7600, TIPOPOSTO.COMUM);
        Assertions.assertEquals(SITUACAO.EMERGENCIA, centro.getSituacao());
    }

    @Test
    void M7() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        centro.encomendaCombustivel(7600, TIPOPOSTO.COMUM);
        centro.recebeAditivo(100);
        centro.recebeGasolina(500);
        centro.recebeAlcool(500);
        Assertions.assertEquals(SITUACAO.SOBRAVISO, centro.getSituacao());
    }

    @Test
    void M8() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        centro.encomendaCombustivel(7600, TIPOPOSTO.COMUM);
        centro.recebeAditivo(1);
        Assertions.assertEquals(SITUACAO.EMERGENCIA, centro.getSituacao());
    }

    @Test
    void M9() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        centro.encomendaCombustivel(7600, TIPOPOSTO.COMUM);
        centro.recebeAditivo(200);
        centro.recebeAlcool(2000);
        centro.recebeGasolina(1000);
        Assertions.assertEquals(SITUACAO.NORMAL, centro.getSituacao());
    }

    @Test
    void C1() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        centro.recebeGasolina(1000);
        Assertions.assertEquals(SITUACAO.NORMAL, centro.getSituacao());
    }

    @Test
    void C2() {
        CentroDistribuicao centro = new CentroDistribuicao(500,10000,2500);
        centro.recebeAlcool(1000);
        Assertions.assertEquals(SITUACAO.NORMAL, centro.getSituacao());
    }

}
