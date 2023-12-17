package com.example.lv7lv8z3;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ListView<String> listKorisnici;

    @FXML
    private TextField fldIme;

    @FXML
    private TextField fldPrezime;

    @FXML
    private TextField fldEmail;

    @FXML
    private TextField fldKorisnickoIme;

    @FXML
    private TextField fldLozinka;

    private KorisniciModel model;

    public void setModel(KorisniciModel model) {
        this.model = model;
        initialize();
    }

    @FXML
    public void initialize() {
        // Povezivanje svakog polja sa odgovarajućim property-em trenutnog korisnika
        fldIme.textProperty().bindBidirectional(model.trenutniKorisnikProperty().get().getIme());
        fldPrezime.textProperty().bindBidirectional(model.trenutniKorisnikProperty().get().getPrezime());
        fldEmail.textProperty().bindBidirectional(model.trenutniKorisnikProperty().get().getEmail());
        fldKorisnickoIme.textProperty().bindBidirectional(model.trenutniKorisnikProperty().get().getKorisnickoIme());
        fldLozinka.textProperty().bindBidirectional(model.trenutniKorisnikProperty().get().getLozinka());

        // Povezivanje ListView kontrole sa spiskom korisnika
        listKorisnici.setItems((ObservableList<String>) model.getTrenutniKorisnik());

        // Dodavanje listenera za promjenu izabranog korisnika u listi
        listKorisnici.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            model.setTrenutniKorisnik(newKorisnik);
            listKorisnici.refresh();
        });
    }

    // Metoda za dodavanje novog korisnika
    @FXML
    public void dodajKorisnika() {
        model.dodajNovogKorisnika();
    }
}
