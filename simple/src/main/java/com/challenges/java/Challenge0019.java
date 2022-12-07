package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;

/**<h1>Desafio 019 - Maiores de idade</h1>
 * Leia a idade de 20 pessoas e exiba quantas pessoas são maiores de idade.
 *
 * @author Mauricio Mityo Hidani
 * @since November 14, 2022
 * @version 1.0.0
 * */
public class Challenge0019 {

    public static void main(String[] args) {
        final Locale br = new Locale("pt", "BR");
        final Scanner scan = new Scanner(System.in, "UTF-8")
                .useLocale(br);

        int ages[] = new int[20];
        int olderAmount = 0;

        System.out.println("Verifique quantas das 20 pessoas sao maiores de idade.");

        for (int i = 0; i < ages.length; i++) {
            System.out.print((i +1) + ". Insira a idade: ");
            ages[i] = scan.nextInt();

            if (ages[i] >= 18) {
                olderAmount++;
            }
        }

        System.out.println("A quantidade das 20 pessoas que sao maiores de idade e de " +
                olderAmount);
    }

}