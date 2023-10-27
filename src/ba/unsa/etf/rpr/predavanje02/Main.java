package ba.unsa.etf.rpr.predavanje02;

import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Double> brojevi = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Unesite broj (ili 'stop' za kraj unosa): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("stop")) {
                if (brojevi.isEmpty()) {
                    System.out.println("Nema unesenih brojeva.");
                } else {
                    double min = findMin(brojevi);
                    double max = findMax(brojevi);
                    double mean = calculateMean(brojevi);
                    double stdDevijacija = calculateStandardDeviation(brojevi);

                    System.out.println("Minimum: " + min);
                    System.out.println("Maksimum: " + max);
                    System.out.println("Srednja vrijednost: " + mean);
                    System.out.println("Standardna devijacija: " + stdDevijacija);
                }
                break;
            } else {
                try {
                    double broj = Double.parseDouble(input);
                    brojevi.add(broj);
                } catch (NumberFormatException e) {
                    System.out.println("Unesite validan broj ili 'stop' za kraj unosa.");
                }
            }
        }

        scanner.close();
    }

    public static double findMin(List<Double> brojevi) {
        double min = Double.MAX_VALUE;
        for (double num : brojevi) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static double findMax(List<Double> brojevi) {
        double max = Double.MIN_VALUE;
        for (double num : brojevi) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static double calculateMean(List<Double> brojevi) {
        double sum = 0;
        for (double num : brojevi) {
            sum += num;
        }
        return sum / brojevi.size();
    }

    public static double calculateStandardDeviation(List<Double> brojevi) {
        double mean = calculateMean(brojevi);
        double sumSquaredDifferences = 0;

        for (double num : brojevi) {
            double difference = num - mean;
            sumSquaredDifferences += difference * difference;
        }

        double variance = sumSquaredDifferences / brojevi.size();
        return Math.sqrt(variance);
    }
}
