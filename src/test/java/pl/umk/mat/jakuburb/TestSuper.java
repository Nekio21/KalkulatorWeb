package pl.umk.mat.jakuburb;

import org.junit.Assert;
import org.junit.Test;

public class TestSuper {

    @Test
    public void wynikDOBRY() throws Exception {

        Kalkulator kalkulator = new Kalkulator("2 12 + 3 / 14 3 - 4 x + 2 /".trim());

        Ulamek ulamek = kalkulator.wynik();

        Ulamek ulamek2 = new Ulamek(73, 3);

        Assert.assertEquals(ulamek.getLicznik(), ulamek2.getLicznik());
        Assert.assertEquals(ulamek.getMianownik(), ulamek2.getMianownik());
    }

    @Test
    public void wynikZLY() throws Exception {

        Kalkulator kalkulator = new Kalkulator("2 3 +".trim());

        Ulamek ulamek = kalkulator.wynik();

        Ulamek ulamek2 = new Ulamek(33, 44);

        Assert.assertNotEquals(ulamek.getLicznik(),ulamek.getMianownik());
        Assert.assertNotEquals(ulamek2.getLicznik(), ulamek2.getMianownik());
    }

    @Test
    public void blednyZapis()  {
        try {
            Kalkulator k = new Kalkulator("2 12 + 3 / 14 3 - 4 x + 2 /edsa".trim());
        } catch (Exception e) {
            Assert.assertEquals(e.toString(), new Exception("Zle dane :<").toString());
        }
    }

    @Test
    public void ulamekSprawdzOK(){
        Ulamek ulamek = new Ulamek(12,3);

        Assert.assertEquals(ulamek.getLicznik(), 4);
        Assert.assertEquals(ulamek.getMianownik(), 1);
    }

    @Test
    public void ulamekSprawdzNOT(){
        Ulamek ulamek = new Ulamek(12,3);

        Assert.assertNotEquals(ulamek.getLicznik(), 55);
        Assert.assertNotEquals(ulamek.getMianownik(), 2);
    }
}