package ba.unsa.etf.rpr.predavanje02;

import java.io.File;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        File serializableFile = new File("laptopi.txt");
        LaptopDaoSerializableFile serializableDao = new LaptopDaoSerializableFile(serializableFile);

        File jsonFile = new File("laptopi.json");
        LaptopDaoJSONFile jsonDao = new LaptopDaoJSONFile(jsonFile);

        File xmlFile = new File("laptopi.xml");
        LaptopDaoXMLFile xmlDao = new LaptopDaoXMLFile(xmlFile);

        // Dodajte testne podatke
        ArrayList<Laptop> laptopi = new ArrayList<>();
        laptopi.add(new Laptop("Dell", "Abc", 1200.0, 8, 500, 0, "Intel i5", "sldjsld", 15.6));
        laptopi.add(new Laptop("HP", "Def", 900.0, 16, 256, 512, "AMD Ryzen 7", ",aaaa5897", 14.0));

        serializableDao.napuniListu(laptopi);
        jsonDao.napuniListu(laptopi);
        xmlDao.napuniListu(laptopi);

        // Testiranje dodavanja laptopa u datoteke
        serializableDao.dodajLaptopUFile(new Laptop("Lenovo", "skdjlaj", 1500.0, 16, 1000, 0, "Intel i7", "lksfjlasj", 17.3));
        jsonDao.dodajLaptopUFile(new Laptop("Asus", "sdmnlkan", 1300.0, 8, 512, 256, "Intel i5", "dfhfhf", 13.3));
        xmlDao.dodajLaptopUFile(new Laptop("Acer", "jsadk", 1100.0, 12, 256, 0, "AMD Ryzen 5", "AMD Radeon", 14.0));

        // Testiranje čitanja podataka iz datoteka
        ArrayList<Laptop> procitaniLaptopi = new ArrayList<>();
        serializableDao.vratiPodatkeIzDatoteke();
        procitaniLaptopi.addAll(serializableDao.getLaptopi());

        jsonDao.vratiPodatkeIzDatoteke();
        procitaniLaptopi.addAll(jsonDao.getLaptopi());

        xmlDao.vratiPodatkeIzDatoteke();
        procitaniLaptopi.addAll(xmlDao.getLaptopi());

        // Ispisivanje podataka
        for (Laptop laptop : procitaniLaptopi) {
            System.out.println(laptop);
        }

        // Testiranje traženja laptopa po procesoru
        try {
            Laptop trazeniLaptop = serializableDao.getLaptop("Intel i7");
            System.out.println("Traženi laptop: " + trazeniLaptop);
        } catch (NeodgovarajuciProcesorException e) {
            System.err.println(e.getMessage());
        }
    }
}
