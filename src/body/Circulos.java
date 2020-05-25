package body;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Circulos {
    private static final double MAX_RADIO = 1;
    private static final double MIN_RADIO = 0.01;
    private static final int TIME_SLEEP_WRITE = 50;
    private static final Scanner INPUT = new Scanner(System.in);

    private static ArrayList<ModelCirculo> circulos = new ArrayList<>();

    public static void main(String[] args) {
        double rnd = generateRandomRadio();

        while (rnd >= MIN_RADIO && rnd < MAX_RADIO) {
            ModelCirculo circulo = new ModelCirculo(rnd);
            circulos.add(circulo);

            rnd = generateRandomRadio();
        }
        writeCirculos();
        userOrden();
    }

    private static double generateRandomRadio() {
        return Math.random();
    }

    private static void writeCirculos() {
        circulos.forEach((item) -> {
            try {
                System.out.println(item);
                System.out.println("----------------------");
                Thread.sleep(TIME_SLEEP_WRITE);
            } catch (InterruptedException ex) {
                Logger.getLogger(Circulos.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private static void userOrden() {
        boolean userQuestion = true;

        while (userQuestion) {
            try {
                System.out.printf(
                        "%s%n%s%n%s%n",
                        Colors.botString("Para ordenar por el radio ascendente imprime \"" + Sort.RADIO_ASC.getId() + "\"."),
                        Colors.botString("Para ordenar por el radio descendente imprime \"" + Sort.RADIO_DESC.getId() + "\"."),
                        Colors.botString("Para salir, imprime [Y\\n].")
                );
                String quest = INPUT.nextLine();
                if (quest.trim().toUpperCase().equals("Y")) {
                    userQuestion = false;
                    System.out.println(Colors.botString("Adios!!!"));
                } else {
                    int ordenNumber = Integer.parseInt(quest);
                    orderCirculos(ordenNumber);
                }
            } catch (NumberFormatException e) {
                System.out.println(Colors.errorString("No entiendo, puedes imprimir otra vez."));
            }
        }
    }

    private static void orderCirculos(int ordenId) {
        if (ordenId == Sort.RADIO_ASC.getId()) {
            circulos.sort(Comparator.comparing(ModelCirculo::getRadio));
            writeCirculos();
        } else if (ordenId == Sort.RADIO_DESC.getId()) {
            circulos.sort(Comparator.comparing(ModelCirculo::getRadio).reversed());
            writeCirculos();
        } else {
            System.out.println(Colors.errorString("No conozco este numero del orden."));
        }
    }
}
