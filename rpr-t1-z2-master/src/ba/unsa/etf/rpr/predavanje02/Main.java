package ba.unsa.etf.rpr.predavanje02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Unesite neki integer: ");
	    int broj = scanner.nextInt();
	    for (int i = 1; i < broj; i++) {
	        if (daLiJeDeljivSaSumomCifara(i)) {
	            System.out.println(i);
            }
        }
    }

    private static boolean daLiJeDeljivSaSumomCifara(int broj) {
        int suma = sumaCifara(broj);
        return broj % suma == 0;
    }

    private static int sumaCifara(int broj) {
        int suma = 0;
        while (broj > 0) {
            suma += broj % 10;
            broj = broj / 10;
        }
        return suma;
    }
}
