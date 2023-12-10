package com.example.lv7lv8z3;

import javafx.beans.property.ObjectProperty;
        import javafx.beans.property.SimpleObjectProperty;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;

public class KorisniciModel {

    private final ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private final ObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();

    public KorisniciModel() {
        // Konstruktor bez argumenata
    }

    // Get-set metode za korisnici
    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici.setAll(korisnici);
    }

    // Get-set metode za trenutniKorisnik
    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public void setTrenutniKorisnik(Korisnik korisnik) {
        trenutniKorisnik.set(korisnik);
    }

    public ObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    // Metoda za popunjavanje liste podacima
    public void napuni() {
        korisnici.add(new Korisnik("Korisnik1", "NovoIme1"));
        korisnici.add(new Korisnik("Korisnik2", "NovoIme2"));
        korisnici.add(new Korisnik("Korisnik3", "NovoIme3"));
    }
}
