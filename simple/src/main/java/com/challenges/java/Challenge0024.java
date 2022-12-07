package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;

/**<h1>Desafio 024 - Entre zero e 100</h1>
 * Escreva um algoritmo que leia 20 numeros do usuario e exiba quantos
 * estao entre 0 e 100.
 *
 * @author Mauricio Mityo Hidani
 * @since November 14, 2022
 * @version 1.0.0
 * */
public class Challenge0024 {

    public static void main(String[] args) {
        final Locale br = new Locale("pt", "BR");
        final Scanner scan = new Scanner(System.in, "UTF-8")
                .useLocale(br);

        int numberOfNumbers = 0;

        System.out.println("Verifique quantos números estão entre 0 e 100.");

        for (int i = 0; i < 20; i++) {
            int num = 0;

            System.out.print((i +1) + ". Numero: ");
            num = scan.nextInt();

            if (num >= 0 && num <= 100) {
                numberOfNumbers++;
            }
        }

        System.out.println("A quantidade de numero que estao entre 0 e 100 e de " +
                numberOfNumbers + ".");
    }

}