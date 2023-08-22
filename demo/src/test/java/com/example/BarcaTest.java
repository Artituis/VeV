package com.example;

import org.junit.jupiter.api.Assertions; 
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test;

public class BarcaTest {
    private Barca barca = null;
    
    @BeforeEach
    void setUp(){
        barca = new Barca();
    }

    @Test
    public void testeAssentoOcupadoA1(){
        Assertions.assertEquals(3, barca.ocupaLugar("F01A01"));
    }
    @Test
    public void testeAssentoOcupadoA2(){
        barca.ocupaLugar("F01A01");
        Assertions.assertEquals(1, barca.ocupaLugar("F01A01"));
    }
    
    @Test
    public void testeAssentoValidoA1B1(){
        Assertions.assertEquals(3, barca.ocupaLugar("F01A01"));
    }
    
    @Test
    public void testeAssentoValidoA1B2(){
        Assertions.assertEquals(0, barca.ocupaLugar("F01A00"));
    }
    
    @Test
    public void testeAssentoValidoA1B3(){
        Assertions.assertEquals(0, barca.ocupaLugar("F01A21"));
    }
    
    @Test
    public void testeAssentoValidoA2B1(){
        Assertions.assertEquals(0, barca.ocupaLugar("F00A01"));
    }

    @Test
    public void testeAssentoValidoA2B2(){
        Assertions.assertEquals(0, barca.ocupaLugar("F00A00"));
    }

    @Test
    public void testeAssentoValidoA2B3(){
        Assertions.assertEquals(0, barca.ocupaLugar("F00A21"));
    }

    @Test
    public void testeAssentoValidoA3B1(){
        Assertions.assertEquals(0, barca.ocupaLugar("F61A01"));
    }

    @Test
    public void testeAssentoValidoA3B2(){
        Assertions.assertEquals(0, barca.ocupaLugar("F61A00"));
    }

    @Test
    public void testeAssentoValidoA3B3(){
        Assertions.assertEquals(0, barca.ocupaLugar("F61A21"));
    }

    @Test 
    public void testeDistribuicaoPesoA1B1(){
        Assertions.assertEquals(3, barca.ocupaLugar("F01A01"));
    }

    @Test 
    public void testeDistribuicaoPesoA1B2(){
        for(int fila=2; fila<8; fila++){
            for(int assento = 1; assento<=20; assento++){
                barca.ocupaLugarSemVerificacao(fila, assento);
            }
        }
        Assertions.assertEquals(2, barca.ocupaLugar("F01A01"));
    }

    @Test 
    public void testeDistribuicaoPesoA1B3(){
        for(int fila=2; fila<13; fila++){
            for(int assento = 1; assento<=20; assento++){
                barca.ocupaLugarSemVerificacao(fila, assento);
            }
        }
        Assertions.assertEquals(3, barca.ocupaLugar("F01A01"));
    }

    @Test 
    public void testeDistribuicaoPesoA2B1(){
        Assertions.assertEquals(2, barca.ocupaLugar("F21A01"));
    }

    @Test 
    public void testeDistribuicaoPesoA2B2(){
        for(int fila=2; fila<8; fila++){
            for(int assento = 1; assento<=20; assento++){
                barca.ocupaLugarSemVerificacao(fila, assento);
            }
        }
        Assertions.assertEquals(2, barca.ocupaLugar("F21A01"));
    }

    @Test 
    public void testeDistribuicaoPesoA2B3(){
        for(int fila=2; fila<13; fila++){
            for(int assento = 1; assento<=20; assento++){
                barca.ocupaLugarSemVerificacao(fila, assento);
            }
        }
        Assertions.assertEquals(3, barca.ocupaLugar("F21A01"));
    }

    @Test 
    public void testeDistribuicaoPesoA3B1(){
        Assertions.assertEquals(2, barca.ocupaLugar("F40A01"));
    }

    @Test 
    public void testeDistribuicaoPesoA3B2(){
        for(int fila=2; fila<8; fila++){
            for(int assento = 1; assento<=20; assento++){
                barca.ocupaLugarSemVerificacao(fila, assento);
            }
        }
        Assertions.assertEquals(3, barca.ocupaLugar("F40A01"));
    }

    @Test 
    public void testeDistribuicaoPesoA3B3(){
        for(int fila=2; fila<13; fila++){
            for(int assento = 1; assento<=20; assento++){
                barca.ocupaLugarSemVerificacao(fila, assento);
            }
        }
        Assertions.assertEquals(3, barca.ocupaLugar("F40A01"));
    }
}
