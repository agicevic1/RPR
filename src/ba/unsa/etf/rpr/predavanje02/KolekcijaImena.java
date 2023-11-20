package ba.unsa.etf.rpr.predavanje02;

import java.util.List;
import java.util.ArrayList;

public class KolekcijaImena implements Kolekcija {
    private List<String> lista = new ArrayList<>();

    KolekcijaImena(List<String> lista) {
        this.lista = lista;
    }

    @Override
    public String getNajduzeIme() {
        String najduzeIme = lista.get(0);
        for (String x : lista) {
            if (x.length() > najduzeIme.length()) {
                najduzeIme = x;
            }
        }
        return najduzeIme;
    }
}
