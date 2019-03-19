package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;
    Maksukortti kortti2;

    @Before
    public void setUp() {
        this.kassa = new Kassapaate();
        this.kortti = new Maksukortti(1000);
        this.kortti2 = new Maksukortti(10);
    }

    @Test
    public void luotuKassaOlemassa() {
        assertTrue(kassa != null);
    }

    @Test
    public void KassaRahaAlussaOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void edllisetAlussaOikein() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void maukkaatAlussaOikein() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void syoEdullisestiLisaarahaaKassaan() {
        kassa.syoEdullisesti(300);
        assertEquals(100240, kassa.kassassaRahaa());
    }

    @Test
    public void syoMaukkaastiLisaarahaaKassaan() {
        kassa.syoMaukkaasti(600);
        assertEquals(100400, kassa.kassassaRahaa());
    }

    @Test
    public void syoEdullisestiPalauttaaVaihtoRahan() {
        assertEquals(60, kassa.syoEdullisesti(300));
    }

    @Test
    public void syoMaukkaastiPalauttaaVaihtoRahan() {
        assertEquals(200, kassa.syoMaukkaasti(600));
    }

    @Test
    public void syoEdullisestiPalauttaaRahatKunEiTarpeeksi() {
        assertEquals(10, kassa.syoEdullisesti(10));
    }

    @Test
    public void syoMaukkaastiPalauttaaRahatKunEiTarpeeksi() {
        assertEquals(10, kassa.syoMaukkaasti(10));
    }

    @Test
    public void syoEdullisestiVieRahaaKortilta() {
        kassa.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
    }

    @Test
    public void syoMaukkaastiVieRahaaKortilta() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
    }

    @Test
    public void syoEdullisestiPalauttaaTrueKunOnnistuu() {
        assertEquals(true, kassa.syoEdullisesti(kortti));
    }

    @Test
    public void syoMaukkaastiPalauttaaTrueKunOnnistuu() {
        assertEquals(true, kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void syoEdullisestiEiVieRahaaKortiltaKunEiTarpeeksi() {
        kassa.syoEdullisesti(kortti2);
        assertEquals(10, kortti2.saldo());
    }

    @Test
    public void syoMaukkaastiEiVieRahaaKortiltaKunEiTarpeeksi() {
        kassa.syoMaukkaasti(kortti2);
        assertEquals(10, kortti2.saldo());
    }

    @Test
    public void syoEdullisestiPalauttaaFalseKunEiOnnistu() {
        assertEquals(false, kassa.syoEdullisesti(kortti2));
    }

    @Test
    public void syoMaukkaastiPalauttaaFalseKunEiOnnistu() {
        assertEquals(false, kassa.syoMaukkaasti(kortti2));
    }

    @Test
    public void LataaRahaaLisaaKortinSaldoa() {
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(1100, kortti.saldo());
    }

    @Test
    public void LataaRahaaVahentaaKassanSaldoa() {
        kassa.lataaRahaaKortille(kortti, 1);
        assertEquals(99999, kassa.kassassaRahaa());
    }

    @Test
    public void LataaRahaaEiLisaaKortinSaldoaNegatiivisella() {
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(1000, kortti.saldo());
    }

    @Test
    public void EdullistenLukumaaraPaivittyy() {
        kassa.syoEdullisesti(300);
        kassa.syoEdullisesti(10);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti2);
        assertEquals(2, kassa.edullisiaLounaitaMyyty());
    }
    
        @Test
    public void MaukkaidenLukumaaraPaivittyy() {
        kassa.syoMaukkaasti(600);
        kassa.syoMaukkaasti(10);
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti2);
        assertEquals(2, kassa.maukkaitaLounaitaMyyty());
    }

}
