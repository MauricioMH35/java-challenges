package com.challenges.java;

import java.util.Locale;
import java.util.Scanner;

/** <h1>Desafio 0001 - Números iguais</h1>
 * Verificar se os números são iguais
 * Imprima se os valores numéricos passados são iguais ou não.
 *
 * @author Mauricio Mityo Hidani
 * @since October 18, 2022
 * @version 1.0.0 */
public class Challenge0001 {

    public static void main(String[] args) {
        final Locale BR = new Locale("pt", "BR");
        final Scanner scan = new Scanner(System.in, "UTF-8").useLocale(BR);

        int[] nums = inputNums(scan);
        boolean result = verifyNums(nums);
        showMessage(result);
    }

    /** <h1>inputNuns</h1>
     * Realiza a entrada de números passados pelo usuário
     *
     * @param scan classe responsável pela captação de entrada de dados
     * @return números captados */
    private static int[] inputNums(Scanner scan) {
        int[] nums = new int[2];
        for (int i = 0; i < 2; i++) {
            try {
                nums[i] = scan.nextInt();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return nums;
    }

    /** <h1>verifyNums</h1>
     * Verifica se os números passados como parâmetros são iguais
     *
     * @param nums números que são verificados
     * @return resultado se os números são iguais */
    private static boolean verifyNums(int... nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[++i]) {
                result++;
            } else {
                result--;
            }
        }

        return result == (nums.length -1) ? true : false;
    }

    /** <h1>showMessage</h1>
     * Mostra a mensagem representando o resultado da verificação
     *
     * @param result valor da verificação */
    private static void showMessage(boolean result) {
        if (result) {
            System.out.println("Sao iguais!");

        } else {
            System.out.println("Nao sao iguais!");

        }
    }

}
