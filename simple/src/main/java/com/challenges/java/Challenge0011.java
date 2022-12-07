package com.challenges.java;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**<h1>Desafio 011 - DIO Combinação de Caracteres</h1>
 * Dada uma string com apenas os seguintes caracteres
 * '(', ')', '{', '}', '[', ']' determine se uma
 * determinada string é válida.
 *
 * Entrada
 * Uma string é considerada válida se:
 * Caracteres de abertura devem ser fechadas pelo
 * mesmo tipo. Abertura devem ser fechados com uma
 * chave correspondente. Uma string vazia é
 * considerada válida.
 *
 * @author Mauricio Mityo Hidani
 * @since October 15, 2022
 * @version 1.0.0
 * */
public class Challenge0011 {

    public static void main(String[] args) {
        final Scanner scanner= new Scanner(System.in);
        boolean caracter = ehValido(scanner.nextLine());

        System.out.println(caracter);
    }

    /** <h2>ehValido</h2>
     * Verifica por meio de regex se o valor da string informada atende ao
     * padrão estabelecido: '(', ')'; '{', '}'; '[', ']', devendo ter seu
     * valor de abertura e fechamento correspondente.
     *
     * @param s Valor que será verificado se possuí o padrão especificado
     * @return Resultado da verificação se a entrada corresponde ao padrão de
     * abertura e fechamento de caracteres que correspondam a caracteristica
     * */
    public static boolean ehValido(String s) {
        //TODO: implemente a lógica de caracteres válidos e retorne se a string é valida ou não.
        if (s.equals("")) {
            return true;
        }

        final Pattern pattern = Pattern.compile("(\\[\\])|(\\(\\))|(\\{\\})");
        final Matcher matcher = pattern.matcher(s);

        return matcher.find();
    }

}
