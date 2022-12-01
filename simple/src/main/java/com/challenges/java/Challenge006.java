package com.challenges.java;

import java.util.Scanner;

/** <h1>Desafio 006 - DIO Somar múltiplos</h1>
 * Retorne o valor da soma de todos múltiplos de "A" até o seu limite "N"
 *
 * @author Mauricio Mityo Hidani
 * @since October 15, 2022
 * @version 1.0.0
 * */
public class Challenge006 {

    public static void main(String[] args) {
        int A, N;
        int mult = 0;
        int sum = 0;

        Scanner input = new Scanner(System.in);
        A = input.nextInt();
        N = input.nextInt();

        for (int i = 0; mult <= N; i++) {
            mult = A * i;
            sum += mult;
            if (mult == N) { break; }
        }

        System.out.println(sum);
    }

}
