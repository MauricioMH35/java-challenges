package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;

/**<h1>Desafio 020 - A mais nova</h1>
 * Leia o nome e a idade de 10 pessoas e exiba o nome da pessoa mais nova.
 *
 * @author Mauricio Mityo Hidani
 * @since November 14, 2022
 * @version 1.0.0
 * */
public class Challenge0020 {

    public static void main(String[] args) {
        final Locale br = new Locale("pt", "BR");
        final Scanner scan = new Scanner(System.in, "UTF-8")
                .useLocale(br);

        int personOfAmount = 5;
        String names[] = new String[personOfAmount];
        int ages[] = new int[personOfAmount];

        for (int i = 0; i < personOfAmount; i++) {
            int index = i +1;
            System.out.print(index + ". Insira o nome da pessoa: ");
            names[i] = scan.next();

            System.out.print(index + ". Insira a idade: ");
            ages[i] = scan.nextInt();
        }

        String nameAssitant = "";
        int ageAssistant = 0;
        for (int i = 0; i < ages.length; i++) {
            for (int j = 0; j < ages.length; j++) {
                if (ages[j] > ages [i]) {
                    ageAssistant = ages[i];
                    ages[i] = ages[j];
                    ages[j] = ageAssistant;

                    nameAssitant = names[i];
                    names[i] = names[j];
                    names[j] = nameAssitant;
                }
            }
        }

        System.out.println("A pessoa com a menor idade e o(a) " + names[0] +
                " com uma idade de " + ages[0]);
    }

}
