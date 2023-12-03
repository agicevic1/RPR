package com.example.lv6z1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private TextField ispis = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Kalkulator");
        GridPane tabela = new GridPane();
        tabela.setVgap(5);
        tabela.setHgap(5);
        tabela.setPadding(new Insets(5));
        tabela.setAlignment(Pos.CENTER);
        tabela.setStyle("-fx-background-color: #e8dbda;");
        ispis.setStyle("-fx-background-color: #e8dbda");

        // redovi - sirenje
        for (int i = 0; i < 5; i++) {
            RowConstraints redoviRast = new RowConstraints();
            redoviRast.setVgrow(Priority.ALWAYS);
            tabela.getRowConstraints().add(redoviRast);
            tabela.getRowConstraints().add(redoviRast);
        }

        // kolone - sirenje
        for (int i = 0; i < 4; i++) {
            ColumnConstraints koloneRast = new ColumnConstraints();
            koloneRast.setHgrow(Priority.ALWAYS);
            tabela.getColumnConstraints().add(koloneRast);
        }

        // ispis
        //TextField ispis = new TextField();
        ispis.setMinHeight(20);
        ispis.setMaxWidth(Double.MAX_VALUE);
        ispis.setPrefHeight(70);
        ispis.setEditable(false);
        GridPane.setColumnSpan(ispis, 4);
        tabela.add(ispis, 0, 0);

        // buttons 1 2 3 4 5 6 7 8 9
        Button[] dugmad = new Button[9];
        for (int i = 0; i < 9; i++) {
            dugmad[i] = new Button(Integer.toString(i+1));
            dugmad[i].setMinSize(0, 0);
            dugmad[i].setPrefHeight(70);
            dugmad[i].setPrefWidth(50);
            dugmad[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            int finalI = i;
            dugmad[i].setOnAction(e -> appendText(dugmad[finalI].getText()));
        }
        tabela.add(dugmad[0], 0, 4); // 1
        tabela.add(dugmad[1], 1, 4); // 2
        tabela.add(dugmad[2], 2, 4); // 3
        tabela.add(dugmad[3], 0, 3); // 4
        tabela.add(dugmad[4], 1, 3); // 5
        tabela.add(dugmad[5], 2, 3); // 6
        tabela.add(dugmad[6], 0, 2); // 7
        tabela.add(dugmad[7], 1, 2); // 8
        tabela.add(dugmad[8], 2, 2); // 9

        // dodajemo '0'
        Button nula = new Button("0");
        nula.setMinSize(0, 0);
        nula.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nula.setPrefHeight(70);
        nula.setPrefWidth(50);
        nula.setOnAction(e -> appendText(nula.getText()));
        tabela.add(nula, 0, 5, 2, 1);

        // dodajemo '.'
        Button tacka = new Button(".");
        tacka.setMinSize(0,0);
        tacka.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        tacka.setPrefHeight(70);
        tacka.setPrefWidth(50);
        tabela.add(tacka, 2, 5);

        // dodajemo '%'
        Button procenat = new Button("%");
        procenat.setMinSize(0,0);
        procenat.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        procenat.setPrefHeight(70);
        procenat.setPrefWidth(50);
        tabela.add(procenat, 0, 1);

        // dodajemo '/'
        Button crta = new Button("/");
        crta.setMinSize(0,0);
        crta.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        crta.setPrefHeight(70);
        crta.setPrefWidth(50);
        crta.setOnAction(e -> appendText(" " + crta.getText() + " "));
        tabela.add(crta, 1, 1);

        // dodajemo 'x'
        Button puta = new Button("x");
        puta.setMinSize(0,0);
        puta.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        puta.setPrefHeight(70);
        puta.setPrefWidth(50);
        puta.setOnAction(e -> appendText(" " + puta.getText() + " "));
        tabela.add(puta, 2, 1);

        // dodajemo '-'
        Button minus = new Button("-");
        minus.setMinSize(0,0);
        minus.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        minus.setPrefHeight(70);
        minus.setPrefWidth(50);
        minus.setOnAction(e -> appendText(" " + minus.getText() + " "));
        tabela.add(minus, 3, 1);

        // dodajemo '+'
        Button plus = new Button("+");
        plus.setMinSize(0,0);
        plus.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        plus.setPrefHeight(70);
        plus.setPrefWidth(50);
        plus.setOnAction(e -> appendText(" " + plus.getText() + " "));
        tabela.add(plus,3, 2, 1, 2);

        // dodajemo '='
        Button jednako = new Button("=");
        jednako.setMinSize(0,0);
        jednako.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        jednako.setPrefHeight(70);
        jednako.setPrefWidth(50);
        jednako.setOnAction(e -> izracunaj());
        tabela.add(jednako,3, 4, 1, 2);
        jednako.setStyle("-fx-background-color: #b38282");

        Scene scene = new Scene(tabela, 400, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void appendText(String text) {
        ispis.appendText(text);
    }

    private void izracunaj() {
        try {
            String rezultat = String.valueOf(eval(ispis.getText()));
            ispis.setText(rezultat);
        } catch (Exception e) {
            ispis.setText("Error");
        }
    }

    private double eval(String expression) {
        return new Object() {
            int pos = -1, ch;
            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }
            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }
            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Parsing operacija
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // Dodavanje
                    else if (eat('-')) x -= parseTerm(); // Oduzimanje
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) x *= parseFactor(); // Množenje
                    else if (eat('/')) x /= parseFactor(); // Deljenje
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // Unarni plus
                if (eat('-')) return -parseFactor(); // Unarni minus
                    double x;
                    int startPos = this.pos;
                    if (eat('(')) { // Otvorena zagrada
                        x = parseExpression();
                        eat(')');
                    } else if ((ch >= '0' && ch <= '9') || ch == '.') { // Broj
                        while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                        x = Double.parseDouble(expression.substring(startPos, this.pos));
                    } else {
                        throw new RuntimeException("Unexpected: " + (char)ch);
                    }
                    if (eat('^')) x = Math.pow(x, parseFactor()); // Stepenovanje
                    return x;
                }
            }.parse();
        }


    public static void main (String[] args){
        launch();
    }

}