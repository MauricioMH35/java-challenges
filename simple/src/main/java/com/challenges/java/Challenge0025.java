package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;

/**<h1>Desafio 025 - Verificacao de numeros</h1>
 * Faca um algoritmo que leia 20 numeros e, ao final, escreva quantos estao
 * entre 0 e 100, quantos estao entre 101 e 200, e quantos sao maiores de 200.
 *
 * @author Mauricio Mityo Hidani
 * @since November 14, 2022
 * @version 1.0.0
 * */
public class Challenge0025 {

    public static void main(String[] args) {
        final Locale br = new Locale("pt", "BR");
        final Scanner scan = new Scanner(System.in, "UTF-8")
                .useLocale(br);

        int zeroOfOneHundred = 0;
        int oneHundredOneOfTwoHundred = 0;
        int greaterThanTwoHundred = 0;

        System.out.println("Verifique quantos dos 20 numeros que devem ser inseridos, \n" +
                "estao entre 0 e 100, os que estao entre 101 e 200, assim como a \n" +
                "quantidade de numeros que passaram de 200.");

        for (int i = 0; i < 20; i++) {
            int num = 0;

            System.out.print((i +1) + ". Numero: ");
            num = scan.nextInt();

            if (num >= 0 && num <= 100) {
                zeroOfOneHundred++;
            } else if (num >= 101 && num <= 200) {
                oneHundredOneOfTwoHundred++;
            } else if (num > 200) {
                greaterThanTwoHundred++;
            }
        }

        System.out.println("Quantidade de numeros que estao entre os numeros apresentados a seguir:");
        System.out.println("Entre 0 e 100: " + zeroOfOneHundred);
        System.out.println("Entre 101 e 200: " + oneHundredOneOfTwoHundred);
        System.out.println("Passaram de 200: " + greaterThanTwoHundred);
    }

}