package ba.unsa.etf.rpr.predavanje02;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, laptopi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new NeodgovarajuciProcesorException("Nema laptopa sa traženim procesorom.");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }

    @Override
    public void vratiPodatkeIzDatoteke() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            laptopi = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Laptop.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
