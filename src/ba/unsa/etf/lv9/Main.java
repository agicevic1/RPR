package ba.unsa.etf.lv9;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String ispisiGradove() {
        GeografijaDAO dao = GeografijaDAO.getInstance();
        String rezultat = "";
        for (Grad grad : dao.gradovi())
            rezultat += grad.getNaziv() + " (" + grad.getDrzava().getNaziv() + ") - " + grad.getBrojStanovnika() + "\n";
        return rezultat;
    }

    public static void glavniGrad() {
        GeografijaDAO dao = GeografijaDAO.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite naziv drzave: ");
        String naziv = sc.nextLine();
        Grad grad = dao.glavniGrad(naziv);
        if (grad == null)
            System.out.println("Nepostojeca drzava");
        else
            System.out.println("Glavni grad drzave " + naziv + " je " + grad.getNaziv());
    }

    public static void main(String[] args) {
        System.out.println("Gradovi su:\n" + ispisiGradove());
        glavniGrad();
    }
}
