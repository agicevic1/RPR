package ba.unsa.etf.rpr.predavanje02;

import java.util.List;
import java.util.ArrayList;

public class KolekcijaImenaIPrezimena implements KolekcijaViseKolekcija {
    private List<String> imena = new ArrayList<>();
    private List<String> prezimena = new ArrayList<>();

    KolekcijaImenaIPrezimena(List<String> imena, List<String> prezimena) {
        this.imena = imena;
        this.prezimena = prezimena;
    }
    @Override
    public String getNajduzeIme() {
        String najduzeIme = imena.get(0) + " " + prezimena.get(0);
        for (int i = 1; i < imena.size(); i++) {
            String imePrezime = imena.get(i) + " " + prezimena.get(i);
            if (imePrezime.length() > najduzeIme.length()) {
                najduzeIme = imePrezime;
            }
        }
        return najduzeIme;
    }
    @Override
    public int getIndexNajduzegPara() {
        int indeks = 0;
        int najduziParDuzina = (imena.get(0) + prezimena.get(0)).length();
        for (int i = 1; i < imena.size(); i++) {
            String imePrezime = imena.get(i) + prezimena.get(i);
            if (imePrezime.length() > najduziParDuzina) {
                najduziParDuzina = imePrezime.length();
                indeks = i;
            }
        }
        return indeks;
    }
    public String getImeiPrezime(int i) {
        return imena.get(i) + " " + prezimena.get(i);

    }
}
