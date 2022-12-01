package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;

/** <h1>Desafio 007 - DIO Somatório de N</h1>
 * Imprima o somatório de N (utilize o método "somatorio") de todos seus números
 * anteriores.
 *
 * @author Mauricio Mityo Hidani
 * @since October 15, 2022
 * @version 1.0.0
 * */
public class Challenge0007 {

    public static void main(String[] args) {
        final Locale BR = new Locale("pt", "br");
        final Scanner numero = new Scanner(System.in, "UTF-8")
                .useLocale(BR);

        int resultado = somatorio(numero.nextInt());
        System.out.println(resultado);
    }

    /** <h2>somatorio</h2>
     * Realiza a soma do número que decresce a cada processo até que ele chegue a 1.
     *
     * @param numero Número utilizado para a realização do somatório
     * @return Resultado da soma decrescente do número até 1
     * */
    private static int somatorio(int numero) {
        if (numero == 0) {
            return 0;
        } else {
            return numero + somatorio(numero - 1);
        }
    }

}
