package ba.unsa.etf.rpr.predavanje02;

import java.util.List;
import java.util.ArrayList;
public class InformacijeONastavniku extends LicneInformacije implements MozeOcijeniti {
    private String titula;
    private ArrayList<Integer> ocjene = new ArrayList<Integer>();

    InformacijeONastavniku(String ime, String prezime, String titula) {
        super(ime, prezime);
        this.titula = titula;
        this.ocjene = new ArrayList<Integer>();
    }
    @Override
    public Ocjena ocijeni(int ocjena) {
        Ocjena o = new Ocjena((LicneInformacije) this, ocjena);
        ocjene.add(o.getOcjena());
        return o;
    }
    public void setTitula(String titula) {
        this.titula = titula;
    }
    public String getTitula() {
        return titula;
    }
    public ArrayList<Integer> getOcjene() {
        return ocjene;
    }
}
