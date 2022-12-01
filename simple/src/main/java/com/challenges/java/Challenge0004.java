package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** <h1>Desafio 004 - Investimento em juros compostos</h1>
 * Crie um sistema onde o usuário possa ser capaz de calcular um investimento
 * realizado atravez de juros composto.
 *
 * @author Mauricio Mityo Hidani
 * @version 1.0.0
 * @since October 26, 2022
 */
public class Challenge0004 {

    public static void main(String[] args) {
        final Locale BR = new Locale("pt", "BR");
        final Scanner scan = new Scanner(System.in, "UTF-8")
                .useLocale(BR);

        System.out.println("Calcule o montente final investido baseado em juros " +
                "composto.");

        final double[] values = setValues(scan);
        final double amount = getCalcAmount(values);

        final String message = String.format("O capital de R$ %.2f investido com uma taxa %.2f%% ao mês, " +
                "em %.0f mes(es). Resulta em um montante de R$ %.2f.", values[0], values[1], values[2], amount);
        System.out.println(message);

    }

    /** <h1>setValues</h1>
     * Pega os valores que serão usados no calculo dos juros compostos, como o Capital
     * que será investido, Taxa ao qual o Capital será aplicado e também o Tempo em
     * que o investimento estará investido.
     *
     * @param scan Usado para conseguir capturar os valores que serão inseridos pelo
     *             usuário
     * @return Os valores em um double[] que representa respectivamente: Capital,
     *         Taxa e Tempo
     * */
    private static double[] setValues(Scanner scan) {
        boolean exit = false;

        final String inCapitalMsg = "Capital que será investido";
        final String inTaxMsg = "Taxa em porcentagem (%) aplicada ao mes";
        final String inTimeMsg = "Tempo de aplicação em meses";

        double capital = -1;
        double tax = -1;
        double time = -1;

        do {
            if (capital == -1) {
                capital = setValidInputValue(inCapitalMsg, scan);
            }

            if (tax == -1) {
                tax = setValidInputValue(inTaxMsg, scan);
            }

            if (time == -1) {
                time = setValidInputValue(inTimeMsg, scan);
            }

            exit = capital != -1 && tax != -1 && time != -1;
            System.out.println();

        } while (!exit);

        return new double[] { capital, tax, time };
    }

    /** <h1>setValidInputValue</h1>
     * Pega valores decimais válidos inseridos pelo usuário.
     *
     * @param message Mensagem que será mostrada para referência da entrada do
     *                valor inserido pelo usuário
     * @param scan    Usado para conseguir capturar as informações digitadas
     *                pelo usuário
     *
     * @return Valor que foi verificado e representa a entrada do usuário
     * */
    private static double setValidInputValue(String message, Scanner scan) {
        System.out.print(message + ": ");
        String capitalStr = scan.next();
        if (isDecimalNumber(capitalStr)) {
            return Double.parseDouble(capitalStr);

        } else {
            System.out.println("o valor inserido não é válido!");

            return -1;
        }
    }

    /** <h1>getCalcAmount</h1>
     * Realiza o calculo dos Juros Compostos com os valores apresentados,
     * sendo eles representados respectivamente: Capital, Taxa e Tempo.
     *
     * @param values Valores que serão utilizados para o cálculo, sendo
     *               respectivamente: Capital, Taxa e Tempo
     *
     * @return Resultado do Calculo dos Juros Compostos
     * */
    private static double getCalcAmount(double[] values) {
        return values[0] * Math.pow((1 + (values[1] / 100)), values[2]);
    }

    /** <h1>isDecimalNumber</h1>
     * Verifica se o valor é um número decimal valido.
     *
     * @param number Valor que será verificado
     * @return A validação da verificação se o valor é um número decimal
     * */
    private static boolean isDecimalNumber(String number) {
        final Pattern pattern = Pattern.compile("^\\d+\\.?\\d*$");
        final Matcher matcher = pattern.matcher(number);

        return matcher.find();
    }

}
