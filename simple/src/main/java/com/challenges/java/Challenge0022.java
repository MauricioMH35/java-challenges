package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;

/**<h1>Desafio 022 - Maiores que 8</h1>
 * Escreva um algoritmo que leia 20 números do usuário e exiba quantos
 * números são maiores do que 8.
 *
 * @author Mauricio Mityo Hidani
 * @since November 14, 2022
 * @version 1.0.0
 * */
public class Challenge0022 {

    public static void main(String[] args) {
        final Locale br = new Locale("pt", "BR");
        final Scanner scan = new Scanner(System.in, "UTF-8")
                .useLocale(br);

        int amountAvarege = 0;
        int targetAvarege = 8;

        System.out.println("Verifique quantos numeros sao maiores do que 8.");
        for (int i = 0; i < 20; i++) {
            int num = 0;

            System.out.print((i +1) + ". Numero: ");
            num = scan.nextInt();

            if (num > targetAvarege) {
                amountAvarege++;
            }
        }

        System.out.println("Dos 20 numeros inseridos, " + amountAvarege + " sao maiores do " +
                "que 8.");
    }

}
