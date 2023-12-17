import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KorisniciModelTest {

    @Test
    public void testDodajNovogKorisnika() {
        KorisniciModel model = new KorisniciModel();
        model.napuni(); // Puni listu s primjerima korisnika

        // Dodajemo novog korisnika s praznim podacima
        model.dodajNovogKorisnika();

        // Provjeravamo da li se korisnik dodao na listu
        ObservableList<Korisnik> korisnici = model.getKorisnici();
        assertEquals(4, korisnici.size()); // 4 jer smo već napunili listu s tri korisnika

        // Provjeravamo da li su podaci novog korisnika prazni
        Korisnik noviKorisnik = korisnici.get(3); // Zadnji korisnik u listi
        assertEquals("", noviKorisnik.getIme());
        assertEquals("", noviKorisnik.getPrezime());
        assertEquals("", noviKorisnik.getEmail());
        assertEquals("", noviKorisnik.getKorisnickoIme());
        assertEquals("", noviKorisnik.getLozinka());
    }
}
