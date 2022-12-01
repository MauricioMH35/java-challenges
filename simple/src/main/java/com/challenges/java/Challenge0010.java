package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;

/** <h1>Desafio 010 - DIO Palíndromo</h1>
 * Neste desafio você deverá construir uma função que recebe
 * uma String e identifique se a mesma é um palíndromo, ou seja,
 * se a String é igual a ela mesma invertida.
 * Dado que temos a String "digital" uma vez invertida temos
 * "latigid" que são diferentes.
 * Logo, NÃO é um Palíndromo.
 * Já se recebemos a string "radar" uma vez invertida temos
 * "radar" que são iguais.
 *
 *@author Mauricio Mityo Hidani
 *@since October 15, 2022
 *@version 1.0.0
 * */
public class Challenge0010 {

    public static void main(String[] args) {

        final Locale BR = new Locale("pt", "BR");
        final Scanner sc = new Scanner(System.in, "UTF-8")
                .useLocale(BR);

        final String palavra = sc.nextLine();

        //TODO: Retorne TRUE ou FALSE, caso a "palavra" seja ou não um Palíndromo.
        String reverso = "";
        final char[] letras = palavra.toCharArray();
        final int qtdLetras = letras.length;
        for (int i = (qtdLetras -1); i >= 0; i--) {
            reverso += letras[i];
        }

        final String resultado = palavra.equals(reverso) ?
                "TRUE" : "FALSE";

        System.out.println(resultado);

    }

}
