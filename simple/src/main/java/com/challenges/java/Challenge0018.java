package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;

/**<h1>Desafio 018 - Media de idade</h1>
 * Leia a idade de 20 pessoas e exiba a média das idades.
 *
 * @author Mauricio Mityo Hidani
 * @since November 14, 2022
 * @version 1.0.0
 * */
public class Challenge0018 {

    public static void main(String[] args) {
        final Locale br = new Locale("pt", "BR");
        final Scanner scan = new Scanner(System.in, "UTF-8")
                .useLocale(br);

        int ages[] = new int[20];
        int sum = 0;
        int average = 0;

        System.out.println("Calcule a media das idades de 20 pessoas.");

        for (int i = 0; i < ages.length; i++) {
            System.out.print((i +1) + ". Insira a idade: ");
            ages[i] = scan.nextInt();

            sum += ages[i];
        }

        average = sum / ages.length;
        System.out.println("A media das idades e de " + average);
    }

}
