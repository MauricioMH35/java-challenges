package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;

/**<h1>Desafio 021 - Tabuada</h1>
 * Crie um algoritmo que leia 20 números do usuário e exiba a sua tabuada
 * de multiplicação.
 *
 * @author Mauricio Mityo Hidani
 * @since November 24, 2022
 * @version 1.0.0
 * */
public class Challenge0021 {

    public static void main(String[] args) {
        final Locale br = new Locale("pt", "BR");
        final Scanner scan = new Scanner(System.in, "UTF-8")
                .useLocale(br);

        int nums[] = new int[20];

        System.out.println("Descubra a tabuada de 20 numeros de sua escolha.");
        System.out.println("Insira os numeros que deseja saber sua tabuada.");

        for (int i = 0; i < nums.length; i++) {
            System.out.print((i +1) + ". Insira o numero: ");
            nums[i] = scan.nextInt();
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Tabuada de " + nums[i] + ':');
            for (int j = 0; j < 11; j++) {
                int result = nums[i] * j;
                System.out.println(nums[i] + "x" + j + " = " + result);
            }
        }
    }

}