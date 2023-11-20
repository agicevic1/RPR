package ba.unsa.etf.rpr.predavanje02;

import java.util.ArrayList;

public class Pobjednik {
    private String ime;
    private String prezime;
    private int brojZnakova;
    KolekcijaImena lista;

    Pobjednik(Kolekcija lista) {
        if (lista instanceof KolekcijaViseKolekcija) {
            int indexNajduzegPara = ((KolekcijaViseKolekcija) lista).getIndexNajduzegPara();
        }
        String najduzeIme = lista.getNajduzeIme();
        int razmak = najduzeIme.indexOf(' ');
        String ime = new String();
        ime = najduzeIme.substring(0, razmak);
        String prezime = new String();
        prezime = najduzeIme.substring(razmak+1, najduzeIme.length());
        this.ime = ime;
        this.prezime = prezime;
        brojZnakova = najduzeIme.length();
    }
    public String getIme() {
        return ime;
    }
    public String getPrezime() {
        return prezime;
    }
    public int getBrojZnakova() {
        return brojZnakova;
    }
}
