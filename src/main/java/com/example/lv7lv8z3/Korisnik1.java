package com.example.lv7lv8z3;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Korisnik1 {

    private final StringProperty korisnickoIme = new SimpleStringProperty();
    private final StringProperty novoIme = new SimpleStringProperty();

    public Korisnik1() {
        // Konstruktor bez argumenata
    }

    public Korisnik1(String korisnickoIme, String novoIme) {
        this.korisnickoIme.set(korisnickoIme);
        this.novoIme.set(novoIme);
    }

    // Get-set metode za korisnickoIme
    public String getKorisnickoIme() {
        return korisnickoIme.get();
    }

    public void setKorisnickoIme(String value) {
        korisnickoIme.set(value);
    }

    public StringProperty korisnickoImeProperty() {
        return korisnickoIme;
    }

    // Get-set metode za novoIme
    public String getNovoIme() {
        return novoIme.get();
    }

    public void setNovoIme(String value) {
        novoIme.set(value);
    }

    public StringProperty novoImeProperty() {
        return novoIme;
    }
}
