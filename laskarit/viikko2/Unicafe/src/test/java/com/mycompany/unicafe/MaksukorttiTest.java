package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    Maksukortti kortti2;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
        kortti2 = new Maksukortti(1050);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void saldoAlussaOikeinToisellaKortilla() {
        assertEquals("saldo: 10.50", kortti2.toString());
    }

    @Test
    public void saldoMetodiToimii() {
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void lataaminenToimii() {
        kortti.lataaRahaa(100);
        assertEquals("saldo: 1.10", kortti.toString());
    }

    @Test
    public void lataaminenNegatiivisellaEiToimi() {
        kortti.lataaRahaa(-100);
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void otaRahaaToimii() {
        kortti2.otaRahaa(100);
        assertEquals("saldo: 9.50", kortti2.toString());
    }

    @Test
    public void saldoEiMuutuKunLiianVahanRahaa() {
        kortti.otaRahaa(100);
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void otaRahaaPalauttaaTrueKunToimii() {
        boolean arvo = kortti2.otaRahaa(100);
        assertEquals(true, arvo);
    }

    @Test
    public void otaRahaaPalauttaaFalseKunEiToimi() {
        boolean arvo = kortti.otaRahaa(100);
        assertEquals(false, arvo);
    }

}
