package com.example.lv7lv8z3;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

class KorisniciApplication extends Application {
    ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    ListView<Korisnik> listaKorisnika = new ListView<>(korisnici);

    TextField imePolje = new TextField();
    TextField prezimePolje = new TextField();
    TextField emailPolje = new TextField();
    TextField korisnickoImePolje = new TextField();
    PasswordField lozinkaPolje = new PasswordField();
    Label imeLabel = new Label("Ime:");
    Label prezimeLabel = new Label("Prezime:");
    Label emailLabel = new Label("E-mail:");
    Label korsinickoImeLabel = new Label("Korisničko ime:");
    Label lozinkaLabel = new Label("Lozinka:");

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Korisnici");

        Button dodaj = new Button("Dodaj");
        dodaj.setOnAction(e -> dodajKorisnikaUListu());

        Button kraj = new Button("Kraj");
        kraj.setOnAction(e -> stage.close());

        listaKorisnika.setOnMouseClicked(e -> naSelektovanogKorisnika());

        GridPane tabela = new GridPane();
        tabela.setHgap(10);
        tabela.setVgap(10);
        tabela.setPadding(new Insets(10, 10, 10, 10));
        tabela.add(listaKorisnika, 0, 0, 1, 6);
        tabela.add(imeLabel, 1, 0);
        tabela.add(prezimeLabel, 1, 1);
        tabela.add(emailLabel, 1, 2);
        tabela.add(korsinickoImeLabel, 1, 3);
        tabela.add(lozinkaLabel, 1, 4);
        tabela.add(imePolje, 2, 0, 2, 1);
        tabela.add(prezimePolje, 2, 1, 2, 1);
        tabela.add(emailPolje, 2, 2, 2, 1);
        tabela.add(korisnickoImePolje, 2, 3, 2, 1);
        tabela.add(lozinkaPolje, 2, 4, 2, 1);
        tabela.add(dodaj, 2, 5);
        tabela.add(kraj, 3, 5);

        Scene scene = new Scene(tabela, 500, 250);
        stage.setScene(scene);
        stage.show();

    }

    public void dodajKorisnikaUListu() {
        Korisnik noviKorisnik = new Korisnik(
                imePolje.getText(),
                prezimePolje.getText(),
                emailPolje.getText(),
                korisnickoImePolje.getText(),
                lozinkaPolje.getText()
        );

        korisnici.add(noviKorisnik);
        listaKorisnika.getSelectionModel().select(noviKorisnik);
        obrisiTekstUPoljima();

    }

    public void obrisiTekstUPoljima() {
        imePolje.clear();
        prezimePolje.clear();
        emailPolje.clear();
        korisnickoImePolje.clear();
        lozinkaPolje.clear();
    }

    public void naSelektovanogKorisnika() {
        Korisnik selektovaniKorisnik = listaKorisnika.getSelectionModel().getSelectedItem();
        if (selektovaniKorisnik != null) {
            prikaziPodatke(selektovaniKorisnik);
        }
    }

    public void prikaziPodatke(Korisnik k) {
        imePolje.setText(k.getIme());
        prezimePolje.setText(k.getPrezime());
        emailPolje.setText(k.getEmail());
        korisnickoImePolje.setText(k.getKorisnickoIme());
        lozinkaPolje.setText(k.getLozinka());
    }

    public static void main(String[] args) {
        launch();
    }
}
