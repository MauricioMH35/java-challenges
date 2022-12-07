package com.challenges.java;

import java.util.Scanner;

/**<h1>Desafio 013 - DIO Organizando Pares e Ímpares</h1>
 * Mova todos os inteiros pares para o inicio do array,
 * seguido por todos os números ímpares
 *
 * @author Mauricio Mityo Hidani
 * @since October 16, 2022
 * @version 2.0.0
 * */
public class Challenge0013 {

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = input.nextInt();
        }

        final int indice = 0;
        for (int n : organizandoPares(nums, indice)) {
            System.out.println(n);
        }

    }

    /** <h2>organizandoPares</h2>
     * Organiza todos os números inteiros pares usando uma iteração
     * com recursividade, que os irá alocar para o inicio do array.
     *
     * @param nums Array de números que deverão ser organizados os
     *             pares para o inicio.
     * @param indice Usado para identificar no processo de
     *               recursividade o elemento que está sendo trabalhado
     *               dentro do array
     *
     * @return Retorna um array com os números pares organizados no
     * inicio do array
     * */
    private static int[] organizandoPares(int nums[], int indice) {
        for (int i = indice; i < nums.length; i++) {
            if (nums[indice] % 2 == 0) {
                if (indice >= nums.length) {
                    break;
                }

                return organizandoPares(nums, ++indice);
            }

            if (nums[i] % 2 == 0) {
                int corrente = nums[i];
                int atual = nums[indice];
                nums[i] = atual;
                nums[indice] = corrente;

                if (indice >= nums.length) {
                    break;
                }

                return organizandoPares(nums, ++indice);
            }
        }
        return nums;
    }

}
