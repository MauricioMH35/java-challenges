package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** <h1>Desafio 005 - Custo carro novo</h1>
 * O custo ao consumidor de um carro novo é a soma do custo de fábrica
 * com a percentagem do distribuidor e dos impostos (aplicados ao custo
 * de fábrica). Supondo que a percentagem do distribuidor seja de 28%
 * e os impostos de 45%, escreva um algoritmo que leia o custo de
 * fábrica de um carro e escreva o custo ao consumidor.
 *
 * @author Mauricio Mityo Hidani
 * @since 0ctober 27, 2022
 * @version 1.0.0
 * */
public class Challenge0005 {

    final static Locale BR = new Locale("pt", "BR");
    final static Scanner SCAN = new Scanner(System.in, "UTF-8").useLocale(BR);

    private static final float DISTRIBUTOR_FEE = 0.28f;
    private static final float TAX_RATE = 0.45f;

    public static void main(String[] args) {
        showMainMessage();
        final double FACTORY_COST = setFactoryCost(SCAN);
        final double CONSUMER_COST = getConsumerCost(
                DISTRIBUTOR_FEE, TAX_RATE, FACTORY_COST);

        showMessageConsumerCost(FACTORY_COST, CONSUMER_COST);
        showMessageFormula(CONSUMER_COST, FACTORY_COST);

    }

    /** <h1>setFactoryCost</h1>
     * Pega o valor do Custo de Fábrica inseridos pelo usuário.
     *
     * @param scan usado para conseguir capturar informações do usuário
     * @return custo de fábrica inserido pelo usuário
     * */
    private static double setFactoryCost(Scanner scan) {
        double factoryCost = -1;

        do {
            System.out.print("Informe o custo de fabrica: ");
            final String factoryCostStr = scan.next();
            if (isDecimalNumber(factoryCostStr)) {
                factoryCost = Double.parseDouble(factoryCostStr);
                break;

            } else {
                System.out.println("O valor inserido não corresponde a um valor válido!");

            }

        } while(true);

        return factoryCost;
    }

    /** <h1>getConsumerCost</h1>
     * Calcula o Custo ao Consumidor usando o Custo de Fábrica e a aplicação das
     * Taxas do Distribuidor e Taxa de Imposto.
     *
     * @param distributorFee taxa cobrada pelo distribuidor do veículo
     * @param taxRate taxa de impostos cobrados ao consumidor
     * @param factoryCost custo de fábrica do carro
     * @return custo ao consumidor
     * */
    private static double getConsumerCost(float distributorFee, float taxRate, double factoryCost) {
        return factoryCost * (1 + distributorFee + taxRate);
    }

    /** <h1>showMainMessage</h1>
     * Mostra a mensagem principal do desafio.
     * */
    private static void showMainMessage() {
        final String mainMessage = String.format(
                "Consulte o custo do seu novo veículo, usando o Custo de Fábrica e as taxas cobradas.\n" +
                        "Taxas Cobradas: \n" +
                        "\t- Taxa do Distribuidor: %.0f%%\n" +
                        "\t- Taxa de Impostos: %.0f%%\n",
                (DISTRIBUTOR_FEE * 100),
                (TAX_RATE * 100)
        );
        System.out.println(mainMessage);
    }

    /** <h1>showMessageConsumerCost</h1>
     * Mostra a mensagem do resultado de forma de texto corrido sobre o Custo ao Consumidor
     * do seu carro novo.
     *
     * @param factoryCost valor do custo de fábrica que será mostrado
     * @param consumerCost valor do custo ao consumidor que será mostrado
     * */
    private static void showMessageConsumerCost(double factoryCost, double consumerCost) {
        final String CONSUMER_COST_MESSAGE = String.format(
                "O custo do seu carro novo usando a Taxa do Distribuidor de %.0f%% mais a Taxa de \n" +
                        "Impostos %.0f%%, e é claro o Custo de Fábrica R$ %.2f.\n" +
                        "Resultará no valor de R$ %.2f.\n",
                (DISTRIBUTOR_FEE * 100),
                (TAX_RATE * 100),
                factoryCost,
                consumerCost
        );
        System.out.println(CONSUMER_COST_MESSAGE);
    }

    /** <h1>showMessageFormula</h1>
     * Mostra a formula matemática utilizada até chegar ao Custo ao Consumidor do seu
     * carro novo, usando das Taxas e Custo de Fábrica.
     *
     * @param consumerCost valor do custo ao consumidor que será mostrado
     * @param factoryCost valor do custo de fábrica que será mostrado
     * */
    private static void showMessageFormula(double consumerCost, double factoryCost) {
        final String FORMULA_USE_MESSAGE = String.format(
                "CUSTO_AO_CONSUMIDOR = CUSTO_FABRICA * (1 + TAXA_DISTRIBUIDOR + TAXA_IMPOSTOS) \n" +
                        "R$ %.2f = R$ %.2f * (1 + %.2f + %.2f)",
                consumerCost, factoryCost, DISTRIBUTOR_FEE, TAX_RATE
        );
        System.out.println(FORMULA_USE_MESSAGE);
    }

    /** <h1>isDecimalNumber</h1>
     * Verifica se o valor de uma String é um número decimal.
     *
     * @param numberStr valor que será verificado
     * @return a verificação do valor inserido
     * */
    private static boolean isDecimalNumber(String numberStr) {
        final Pattern pattern = Pattern.compile("^\\d+\\.?\\d*$");
        final Matcher matcher = pattern.matcher(numberStr);

        return matcher.find();
    }

}
