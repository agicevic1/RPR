package ba.unsa.etf.rpr.predavanje02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Zadatak 1.

        InformacijeOStudentu student1 = new InformacijeOStudentu("Ema", "Hadzic", "2023", "123456");
        InformacijeONastavniku nastavnik1 = new InformacijeONastavniku("Ajla", "Mehic", "dr");
        System.out.println("Ime studenta je " + student1.getIme() + ", \n" +
                           "prezime je " + student1.getPrezime() + ", \n" +
                           "godina studija " + student1.getGodinaStudija() + ", \n" +
                           "broj indeksa " + student1.getBrojIndexa() + "\n");
        System.out.println("Ime nastavnika je " + nastavnik1.getIme() + ", \n" +
                           "prezime je " + nastavnik1.getPrezime() + ", \n" +
                           "titula je " + nastavnik1.getTitula() + "\n");

        // Zadatak 2.

        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite naziv predmeta: ");
        String nazivPredmeta = ulaz.nextLine();
        Predmet predmet = new Predmet(nazivPredmeta);

        System.out.println("Unesite ime nastavnika: ");
        String imeNastavnika = ulaz.nextLine();
        System.out.println("Unesite prezime nastavnika: ");
        String prezimeNastavnika = ulaz.nextLine();
        System.out.println("Unesite titulu nastavnika: ");
        String titula = ulaz.nextLine();
        InformacijeONastavniku nastavnik = new InformacijeONastavniku(imeNastavnika, prezimeNastavnika, titula);

        System.out.println("Unesite ime studenta: ");
        String imeStudenta = ulaz.nextLine();
        System.out.println("Unesite prezime studenta: ");
        String prezimeStudenta = ulaz.nextLine();
        System.out.println("Unesite godinu studija");
        String godina = ulaz.nextLine();
        System.out.println("Unesite broj indeksa");
        String indeks = ulaz.nextLine();
        InformacijeOStudentu student = new InformacijeOStudentu(imeStudenta, prezimeStudenta, godina, indeks);

        System.out.println("Ocijenite predmet, unesite ocjenu: ");
        int ocjena = ulaz.nextInt();
        Ocjena ocjenaPredmeta = predmet.ocijeni(ocjena);
        System.out.println("Predmet je ocijenjen sa " + ocjenaPredmeta.getOcjena());

        System.out.println("Ocijenite nastavnika, unesite ocjenu: ");
        int ocjena2 = ulaz.nextInt();
        Ocjena ocjenaNastavnika = nastavnik.ocijeni(ocjena2);
        System.out.println("Nastavnik je ocijnjen ocjenom " + ocjenaNastavnika.getOcjena());
    }
}
