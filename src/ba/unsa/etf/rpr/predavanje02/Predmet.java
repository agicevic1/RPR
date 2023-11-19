package ba.unsa.etf.rpr.predavanje02;

import java.util.List;
import java.util.ArrayList;

public class Predmet implements MozeOcijeniti {
    private String naziv;
    private String opis;
    private ArrayList<Integer> ocjene = new ArrayList<>();

    Predmet(String naziv) {
        this.naziv = naziv;
        this.opis = "";
        this.ocjene = new ArrayList<Integer>();
    }
    Predmet(String naziv, String opis) {
        this.naziv = naziv;
        this.opis = opis;
        this.ocjene = new ArrayList<Integer>();
    }

    @Override
    public Ocjena ocijeni(int ocjena) {
        Ocjena o = new Ocjena(null, ocjena);
        ocjene.add(o.getOcjena());
        return o;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public void setOpis(String opis) {
        this.opis = opis;
    }
    public String getNaziv() {
        return naziv;
    }
    public String getOpis() {
        return opis;
    }
}
