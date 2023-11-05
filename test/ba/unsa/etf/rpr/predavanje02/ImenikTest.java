package ba.unsa.etf.rpr.predavanje02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

/*
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
*/

class ImenikTest {

    @Test
    void dodaj() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ajla Alic", new MedunarodniBroj("+1", "23 45-67-89"));
        imenik.dodaj("Ema Hodzic", new FiksniBroj(Grad.SARAJEVO, "123-156"));
        imenik.dodaj("Lejla Mehic", new FiksniBroj(Grad.SARAJEVO, "123-456"));
        assertEquals("033/123-456", imenik.dajBroj("Lejla Mehic"));
    }

    @Test
    public void dodajFiksniIzuzetak(){
        assertThrows(BrojException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new FiksniBroj(null, "123-123");
            }
        });
        assertThrows(BrojException.class, () -> {new FiksniBroj(null, "123-123");});
    }

    @Test
    void naSlovo() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Alma Mehic", new FiksniBroj(Grad.SARAJEVO, "123-156"));
        imenik.dodaj("Mujo Mujic", new FiksniBroj(Grad.SARAJEVO, "123-656"));
        imenik.dodaj("Ina Ilic", new MobilniBroj(61, "321-645"));
        imenik.dodaj("Tea Muhovic", new MobilniBroj(64, "987-654"));
        imenik.dodaj("Edina Husic", new MedunarodniBroj("+1", "23 45-67-89"));
        assertEquals( "5. Ina Ilic - 061/321-645", imenik.naSlovo('I').trim());
    }


    @Test
    void izGrada() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ina Ilic", new FiksniBroj(Grad.SARAJEVO, "123-456"));
        imenik.dodaj("Alma Mehic", new FiksniBroj(Grad.SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(Grad.SARAJEVO, "123-656"));
        imenik.dodaj("Pero Peric", new MobilniBroj(64, "987-654"));
        imenik.dodaj("Edina Husic", new MedunarodniBroj("+1", "23 45-67-89"));
        java.util.Set<String> set = imenik.izGrada(Grad.SARAJEVO);
        String result = "";
        for (String ime: set) {
            result += ime + ",";
        }
        assertEquals("Alma Mehic,Ina Ilic,Meho Mehic,", result);
    }

    /*
    @Test
    public void testIzGrada() {
        // Mockiramo mapu sa nekoliko unosa
        when(mockMap.get("Alma Hodzic")).thenReturn(new FiksniBroj(Grad.SARAJEVO, "123-456"));
        when(mockMap.get("Lejla Mehic")).thenReturn(new FiksniBroj(Grad.TUZLA, "987-654"));

        // Pozivamo metodu izGrada
        Set<String> imenaIzSarajeva = imenik.izGrada(Grad.SARAJEVO);

        // Proveravamo da li su očekivanja ispunjena
        verify(mockMap).get("Alma Hodzic");
        verify(mockMap).get("Lejla Mehic");

        // Provjeravamo rezultate
        assertTrue(imenaIzSarajeva.contains("Alma Hodzic"));
        assertFalse(imenaIzSarajeva.contains("Lejla Mehic"));
    }
     */

}