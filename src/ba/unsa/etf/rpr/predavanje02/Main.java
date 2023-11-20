package ba.unsa.etf.rpr.predavanje02;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        KolekcijaImena lista = new KolekcijaImena(List.of("Ema Mehic", "Muhamed Hadziosmanovic", "Alma Duric", "Lena Milic"));
        Pobjednik p = new Pobjednik(lista);
        System.out.println("Najduze ime i prezime zajedno su: " + p.getIme() + " i " + p.getPrezime());
        System.out.println("Najduze ime i prezime imaju " + p.getBrojZnakova() + " znakova");

        KolekcijaImenaIPrezimena lista2 = new KolekcijaImenaIPrezimena(
                List.of("Ema", "Mia", "Azemina", "Muhamed"),
                List.of("Mujic", "Hodzic", "Lalic", "Hasanbegovic"));
        Pobjednik p2 = new Pobjednik(lista2);
        System.out.println("Najduze ime i prezime su " + p2.getIme() + " " + p2.getPrezime());
        System.out.println("Indeks najduzeg para je " + lista2.getIndexNajduzegPara());
    }
}
