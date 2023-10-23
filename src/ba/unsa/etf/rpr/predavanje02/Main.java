package ba.unsa.etf.rpr.predavanje02;

import java.util.Scanner;

class FaktorijelRacunalo {
    public static long izracunajFaktorijel(int broj) {
        if (broj == 0 || broj == 1) {
            return 1;
        } else {
            long faktorijel = 1;
            for (int i = 2; i <= broj; i++) {
                faktorijel *= i;
            }
            return faktorijel;
        }
    }
}

class SinusRacunalo {
    public static double izracunajSinus(double broj) {
        return Math.sin(broj);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Unesite broj za koji zelite izracunati faktorijel: ");
        int brojZaFaktorijel = scanner.nextInt();

        long faktorijel = FaktorijelRacunalo.izracunajFaktorijel(brojZaFaktorijel);
        System.out.println("Faktorijel broja " + brojZaFaktorijel + " je " + faktorijel);

        System.out.print("Unesite broj za koji zelite izracunati sinus: ");
        double brojZaSinus = scanner.nextDouble();

        double sinus = SinusRacunalo.izracunajSinus(brojZaSinus);
        System.out.println("Sinus broja " + brojZaSinus + " je " + sinus);

        scanner.close();
    }
}
