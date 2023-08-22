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
    
}
