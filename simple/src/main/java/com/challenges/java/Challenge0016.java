package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;

/**<h1>Desafio 016 - Soma de numeros</h1>
 * Escreva um algoritmo que leia 10 números do usuário e calcule a soma
 * desses números.
 *
 * @author Mauricio Mityo Hidani
 * @since November 14, 2022
 * @version 1.0.0
 * */
public class Challenge0016 {

    public static void main(String[] args) {
        final Locale BR = new Locale("pt", "BR");
        final Scanner SCAN = new Scanner(System.in, "UTF-8")
                .useLocale(BR);

        int nums[] = new int[10];
        int sum = 0;

        System.out.println("Insira 10 numeros para averiguar a soma entre eles");
        for (int i = 0; i < nums.length; i++) {
            System.out.print((i +1) + ". Numero: ");
            nums[i] = SCAN.nextInt();

            sum += nums[i];
        }

        System.out.println("A soma dos numeros inseridos foi de " + sum);
    }

}
