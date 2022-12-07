package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;

/**<h1>Desafio 023 - Todos os pares</h1>
 * Escreva um algoritmo que leia 20 numeros do usuario e exiba quantos sao
 * pares.
 *
 * @author Mauricio Mityo Hidani
 * @since November 14, 2022
 * @version 1.0.0
 * */
public class Challenge0023 {

    public static void main(String[] args) {
        final Locale br = new Locale("pt", "BR");
        final Scanner scan = new Scanner(System.in, "UTF-8")
                .useLocale(br);

        int numberOfPairs = 0;

        System.out.println("Insira numeros para averiguar quantos deles sao numeros pares.");

        for (int i = 0; i < 20; i++) {
            int num = 0;

            System.out.print((i +1) + ". Numero: ");
            num = scan.nextInt();

            if (num % 2 == 0) {
                numberOfPairs++;
            }
        }

        System.out.println("A quantidade dos 20 numeros inseridos que sao pares, " +
                "e de " + numberOfPairs + ".");
    }

}
