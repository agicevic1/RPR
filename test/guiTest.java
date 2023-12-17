import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;

public class guiTest extends ApplicationTest {

    @Override
    public void start(Stage stage) {
        // Ovdje inicijalizirajte svoju aplikaciju
        // Na primjer, ako imate metodu za pokretanje aplikacije u klasi Main, možete je pozvati ovde
    }

    @Test
    public void testDodajKorisnika(FxRobot robot) {
        // Simuliramo korisničko sučelje
        // Ovo pretpostavlja da postoje određeni FXML elementi s ID-ovima na sučelju

        // Klikamo na dugme Dodaj
        robot.clickOn("#dodajButton");

        // Provjeravamo da li se polja pravilno resetiraju na prazne vrijednosti
        robot.clickOn("#fldIme").write("Novi");
        robot.clickOn("#fldPrezime").write("Korisnik");
        robot.clickOn("#fldEmail").write("novi.korisnik@example.com");
        robot.clickOn("#fldKorisnickoIme").write("novi_korisnik");
        robot.clickOn("#fldLozinka").write("nova_lozinka");

        // Klikamo na dugme Dodaj
        robot.clickOn("#dodajButton");

        // Provjeravamo da li su polja ponovno prazna
        robot.clickOn("#fldIme").hasText("");
        robot.clickOn("#fldPrezime").hasText("");
        robot.clickOn("#fldEmail").hasText("");
        robot.clickOn("#fldKorisnickoIme").hasText("");
        robot.clickOn("#fldLozinka").hasText("");
    }

    @Test
    public void testSelektujKorisnika(FxRobot robot) {
        // Pretpostavljamo da postoje određeni FXML elementi s ID-ovima na sučelju
        // Na primjer, ListView s ID-om listKorisnici

        // Selektujemo drugog korisnika u listi
        robot.clickOn("#listKorisnici").type(KeyCode.DOWN);

        // Provjeravamo da li se podaci trenutnog korisnika prikazuju na sučelju
        robot.clickOn("#fldIme").hasText("Ime2");
        robot.clickOn("#fldPrezime").hasText("Prezime2");
        robot.clickOn("#fldEmail").hasText("ime2.prezime2@example.com");
        robot.clickOn("#fldKorisnickoIme").hasText("korisnik2");
        robot.clickOn("#fldLozinka").hasText("lozinka2");
    }
}
