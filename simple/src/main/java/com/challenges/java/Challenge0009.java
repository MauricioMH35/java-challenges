package com.challenges.java;

import java.util.Scanner;

/** <h1>Desafio 009 - DIO Encontre o número no array</h1>
 * Retorne o valor do elemento no Array junto de sua respectiva posição.
 *
 * @author Mauricio Mityo Hidani
 * @since October 15, 2022
 * @version 1.0.0
 * */
public class Challenge0009 {

    public static void main(String[] args) throws NumberFormatException {
        final Scanner leitor = new Scanner(System.in);

        int[] elementos = {64, 137, -16, 43, 67, 81, -90, 212, 10, 75};
        int numeroAlvo = leitor.nextInt();

        //TODO: Retorne o valor do elemento no Array junto de sua respectiva posição.
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] == numeroAlvo) {
                final String RESULTADO = String.format("Achei %d na posicao %d", elementos[i], i);
                System.out.println(RESULTADO);
                return;

            }
        }

        final String RESULTADO = String.format("Numero %d nao encontrado!", numeroAlvo);
        System.out.println(RESULTADO);
    }

}
