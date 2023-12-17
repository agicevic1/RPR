package com.example.lv7lv8z3;

import javafx.beans.property.Property;

public class Korisnik {
    private String ime;
    private String prezime;
    private String email;
    private String korisnickoIme;
    private String lozinka;
    private String korisnikPoRedu;

    public Korisnik(String ime, String prezime, String email, String korisnickoIme, String lozinka) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Property<String> getIme() {
        return ime;
    }

    public Property<String> getPrezime() {
        return prezime;
    }

    public Property<String> getEmail() {
        return email;
    }

    public Property<String> getKorisnickoIme() {
        return korisnickoIme;
    }

    public Property<String> getLozinka() {
        return lozinka;
    }

    @Override
    public String toString() {
        String s = "Korisnik";
        return s;
    }

}
