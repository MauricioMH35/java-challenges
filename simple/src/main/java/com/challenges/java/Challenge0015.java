package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;

/**<h1>Desafio 015 - Repetição de nome</h1>
 * Leia o nome e um número do usuário, um número N e escreva o nome dele na
 * tela N vezes.
 *
 * @autor Mauricio Mityo Hidani
 * @since November 14, 2022
 * @version 1.0.0
 * */
public class Challenge0015 {

    public static void main(String[] args) {
        final Locale BR = new Locale("pt", "BR");
        final Scanner scan = new Scanner(System.in, "UTF-8")
                .useLocale(BR);

        int num = 0;
        String name = "";

        System.out.print("Escreva seu nome: ");
        name = scan.next();

        System.out.print("Escreva um numero: ");
        num = scan.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.println((i +1) + ". " + name);
        }
    }

}
