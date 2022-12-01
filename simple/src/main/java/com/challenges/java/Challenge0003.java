package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** <h1>Desafio 003 - Media final</h1>
 * Faça um algoritmo que leia as 3 notas de um aluno e calcule a média final deste aluno.
 * Considerando que a média é ponderada e que o peso das notas é: 2, 3 e 5,
 * respectivamente.
 *
 * @author  Mauricio Mityo Hidani
 * @since October 26, 2022
 * @version 1.0.0
 * */
public class Challenge0003 {


    final private static float[] weights = { 2, 3, 5 };

    public static void main(String[] args) {
        final Locale BR = new Locale("pt", "BR");
        final Scanner scan = new Scanner(System.in, "UTF-8")
                .useLocale(BR);

        System.out.println("Calcule média ponderada inserindo suas 3 notas.");
        showWeights(weights);

        float[] notes = getNotes(scan);
        float weightedAverage = getWeightedAverage(notes);
        System.out.println(String.format("Sua média final será: %.2f", weightedAverage));
    }

    /** <h1>getNotes</h1>
     * Captura as 3 notas que serão inseridas pelo usuário.
     *
     * @param scan usado para conseguir capturar as informações inseridas pelo usuário
     * @return as notas inseridas pelo usuário
     * */
    private static float[] getNotes(Scanner scan) {
        float[] notes = new float[3];

        for (int i = 0; i < notes.length; i++) {
            boolean exit = false;
            do {
                System.out.print(String.format("Insira sua %dº nota: ", (i +1)));
                String note = scan.next();
                if (isADecimalNumber(note)) {
                    notes[i] = Float.parseFloat(note);
                    exit = true;

                } else {
                    System.out.println("O valor informado não pode ser considerado um " +
                            "número");

                }

            } while(!exit);
        }

        return notes;
    }

    /** <h1>getWeightedAverage</h1>
     * Calcula a média ponderada usando dos pesos estipulados pelo exercício, além das
     * notas informadas pelo usuário.
     *
     * @param notes todas as 3 notas inseridas pelo usuário
     * @return resultado da média ponderada
     * */
    private static float getWeightedAverage(float[] notes) {
        float result = 0;
        float allNotes = 0;

        for (int i = 0; i < notes.length; i++) {
            result += notes[i] * weights[i];
            allNotes += weights[i];
        }

        result /= allNotes;
        return result;
    }

    /** <h1>isADecimalNumber</h1>
     * Verifica se a informação inserida é realmente um número, que pode ser considerado
     * também como um número decimal.
     *
     * @param input entrada da informação inserida pelo usuário
     * @return a verificação se a informação inserida corresponde a um número
     * */
    private static boolean isADecimalNumber(String input) {
        final Pattern pattern = Pattern.compile("^\\d+\\.?\\d*$");
        final Matcher matcher = pattern.matcher(input);
        final boolean result = matcher.find();

        return result;
    }

    /** <h1>showWeights</h1>
     * Mostra os pesos das que serão usados no calculo da média ponderada.
     *
     * @param weights referece aos pesos que serão mostrados ao usuário
     * */
    private static void showWeights(float[] weights) {
        System.out.print("Os pesos para suas notas serão respectivamente: ");
        for (int i = 0; i < weights.length; i++) {
            System.out.print(weights[i] + ", ");
        }
        System.out.println();
    }

}
