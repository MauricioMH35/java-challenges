package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;

/**<h1>Desafio 017 - Soma de idades</h1>
 * Leia a idade de 20 pessoas e exiba a soma das idades.
 *
 * @author Mauricio Mityo Hidani
 * @since November 14, 2022
 * @version 1.0.0
 * */
public class Challenge0017 {

    public static void main(String[] args) {
        final Locale br = new Locale("pt", "BR");
        final Scanner scan = new Scanner(System.in, "UTF-8")
                .useLocale(br);

        int ages[] = new int[20];
        int sum = 0;

        System.out.println("Insira a idade de 20 pessoas para saber a soma " +
                "de todas elas.");

        for (int i = 0; i < ages.length; i++) {
            System.out.print((i +1) + ". Insira a idade: ");
            ages[i] = scan.nextInt();

            sum += ages[i];
        }

        System.out.println("O resultado da soma das idades é de " + sum);
    }

}
