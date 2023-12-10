package com.example.lv7lv8z2;

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

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    @Override
    public String toString() {
        String s = "Korisnik";
        return s;
    }

}
