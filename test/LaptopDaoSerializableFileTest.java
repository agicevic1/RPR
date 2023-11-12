import ba.unsa.etf.rpr.predavanje02.Laptop;
import ba.unsa.etf.rpr.predavanje02.LaptopDaoSerializableFile;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoSerializableFileTest {

    private static final String TEST_FILE_PATH = "test_laptops.txt";

    @Test
    void testDodajLaptopUListu() {
        LaptopDaoSerializableFile dao = new LaptopDaoSerializableFile(new File(TEST_FILE_PATH));

        // Postavljanje test podataka u datoteku
        ArrayList<Laptop> testLaptopi = new ArrayList<>();
        testLaptopi.add(new Laptop("Dell", "Inspiron", 1200.0, 8, 500, 0, "Intel i5", "abc", 15.6));
        testLaptopi.add(new Laptop("HP", "hgjhkjhg", 900.0, 16, 256, 512, "AMD Ryzen 7", "kjhgf", 14.0));

        for (Laptop laptop : testLaptopi) {
            dao.dodajLaptopUFile(laptop);
        }

        // Učitaj podatke iz datoteke
        dao.vratiPodatkeIzDatoteke();

        // Dodaj novi laptop u listu
        Laptop noviLaptop = new Laptop("Lenovo", "Tjhgjhg", 1500.0, 16, 1000, 0, "Intel i7", "Nhgiuho", 17.3);
        dao.dodajLaptopUListu(noviLaptop);

        // Proveri da li se novi laptop nalazi u listi
        ArrayList<Laptop> listaLaptopa = dao.getLaptopi();
        assertTrue(listaLaptopa.contains(noviLaptop));
    }

    @Test
    void testGetLaptop() {
        LaptopDaoSerializableFile dao = new LaptopDaoSerializableFile(new File(TEST_FILE_PATH));

        // Postavljanje test podataka u datoteku
        ArrayList<Laptop> testLaptopi = new ArrayList<>();
        testLaptopi.add(new Laptop("Dell", "Inspiron", 1200.0, 8, 500, 0, "Intel i5", "ANBJKAB", 15.6));
        testLaptopi.add(new Laptop("HP", "Pavilion", 900.0, 16, 256, 512, "AMD Ryzen 7", "AMOJSKA45ay", 14.0));

        dao.napuniListu(testLaptopi);
        for (Laptop laptop : testLaptopi) {
            dao.dodajLaptopUFile(laptop);
        }

        // Testiranje getLaptop metode
        try {
            Laptop trazeniLaptop = dao.getLaptop("Intel i5");
            assertNotNull(trazeniLaptop);
            assertEquals("Dell", trazeniLaptop.getBrend());
        } catch (NeodgovarajuciProcesorException e) {
            fail("Ne bi trebalo baciti izuzetak");
        }
    }

    @Test
    void testNapuniListu() {
        LaptopDaoSerializableFile dao = new LaptopDaoSerializableFile(new File(TEST_FILE_PATH));

        // Postavljanje test podataka u datoteku
        ArrayList<Laptop> testLaptopi = new ArrayList<>();
        testLaptopi.add(new Laptop("Dell", "Inspiron", 1200.0, 8, 500, 0, "Intel i5", "NVIDIA", 15.6));
        testLaptopi.add(new Laptop("HP", "Pavilion", 900.0, 16, 256, 512, "AMD Ryzen 7", "AMD Radeon", 14.0));

        for (Laptop laptop : testLaptopi) {
            dao.dodajLaptopUFile(laptop);
        }

        // Učitaj podatke iz datoteke
        dao.vratiPodatkeIzDatoteke();

        // Kreiraj novu instancu LaptopDaoSerializableFile i koristi metodu napuniListu
        LaptopDaoSerializableFile daoNapuniListu = new LaptopDaoSerializableFile(new File(TEST_FILE_PATH));
        ArrayList<Laptop> napunjenaLista = new ArrayList<>();
        daoNapuniListu.napuniListu(napunjenaLista);

        // Proveri da li se lista pravilno popunila
        assertEquals(testLaptopi.size(), napunjenaLista.size());
        assertTrue(napunjenaLista.containsAll(testLaptopi));
    }

    @Test
    void testVratiPodatkeIzDatoteke() throws IOException, ClassNotFoundException {
        // Kreiraj privremeni direktorijum i datoteku za testiranje
        File tempFile = File.createTempFile("test", ".txt");
        LaptopDaoSerializableFile dao = new LaptopDaoSerializableFile(tempFile);

        // Postavi test podatke u datoteku
        ArrayList<Laptop> testLaptopi = new ArrayList<>();
        testLaptopi.add(new Laptop("Dell", "OP8ssn", 1200.0, 8, 500, 0, "Intel i5", "asjdhkjas", 15.6));
        testLaptopi.add(new Laptop("HP", "aslkd", 900.0, 16, 256, 512, "AMD Ryzen 7", "Akajsdh", 14.0));
        dao.napuniListu(testLaptopi);
        dao.dodajLaptopUFile(new Laptop("Lenovo", "k78njd", 1500.0, 16, 1000, 0, "Intel i7", "Nsad45a", 17.3));

        // Učitaj podatke iz datoteke
        dao.vratiPodatkeIzDatoteke();

        // Proveri da li se lista pravilno popunila
        ArrayList<Laptop> procitaniLaptopi = dao.getLaptopi();
        assertEquals(3, procitaniLaptopi.size());
        assertTrue(procitaniLaptopi.containsAll(testLaptopi));
    }
}
