package com.challenges.java;

/** <h1>Desafio 008 - DIO Entre Múltiplos de dois números</h1>
 * Procure pelo múltiplo entre dois valores inteiros e apresente
 * a mensagem "FizzBuzz" se os dois valores possuirem o mesmo
 * múltiplo, "Fizz" caso apenas o primerio número possuir o
 * múltiplo indicado e "Buzz" se apenas o segundo número
 * possuir esse múltiplo.
 *
 * @author Mauricio Mityo Hidani
 * @since October 15, 2022
 * @version 1.2.0
 * */
public class Challenge0008 {

    public static void main(String[] args) {
        int multiple = 15;
        int numA = 3;
        int numB = 5;

        boolean isMultipleNumA = multiple % numA == 0;
        boolean isMultipleNumB = multiple % numB == 0;
        boolean isMultipleBetween = isMultipleNumA && isMultipleNumB;

        if (isMultipleBetween) {
            System.out.println("FizzBuzz");

        } else if (isMultipleNumA) {
            System.out.println("Fizz");

        } else if (isMultipleNumB) {
            System.out.println("Buzz");

        } else {
            System.out.println(multiple);

        }
    }

    /** @deprecated <h2>isMultipleBetween</h2>
     * Verifica se dois números possuem um múltiplo em comum.
     *
     * @param multiple Múltiplo que será verificado
     * @param numA Primeiro número que será verificado se possuí o múltiplo
     *             em comum
     * @param numB Segundo número que será verificado se possuí o múltiplo em
     *             comum
     *
     * @return Resultado da verificação se os dois números possuem um múltiplo
     * entre sí
     * */
    @Deprecated
    private static boolean isMultipleBetween(int multiple, int numA, int numB) {
        boolean isMultipleNumA = isMultiple(multiple, numA);
        boolean isMultipleNumB = isMultiple(multiple, numB);

        return isMultipleNumA && isMultipleNumB;
    }

    /** @deprecated <h2>isMultiple</h2>
     * Verifica se um número possí o múltiplo indicado.
     *
     * @param multiple Múltiplo utilizado para a verificação
     * @param num Número que será verificado se possuí o múltiplo indicado
     * @return Verificação se o número possuí o múltiplo
     * */
    @Deprecated
    private static boolean isMultiple(int multiple, int num) {
        int index = 0;

        if (multiple == num) {
            return true;
        }

        int sqrt = num * num;
        if (multiple < sqrt) {
            index = num - 1;
            return  (getMultipleDecreasing(multiple, num, index) != -1) ? true : false;

        } else {
            index = num + 1;
            return (getMultipleIncreasing(multiple, num, index) != -1) ? true : false;
        }
    }

    /** @deprecated  <h2>getMultipleIncreasing</h2>
     * Tenta encontrar usando recursividade o fator que corresponde ao múltiplo
     * indicado, percorrendo os possiveis fatores de determinado número de
     * forma crescente.
     *
     * @param multiple Múltiplo que será procurado dentro dos múltiplos de um
     *                 número
     * @param num Número ao qual será verificado se possuí o múltiplo
     * @param index Representação do fator que será percorrido para se
     *              encontrar o múltiplo correspondente
     *
     * @return Mútiplo correspondente dentro dos múltiplos que determinado
     * número que o possa possuir. Sendo retornado -1 caaso não o encotre
     * */
    @Deprecated
    private static int getMultipleIncreasing(int multiple, int num, int index) {
        if (multiple == (num * index)) {
            return index;
        } else if (multiple > (num * index)) {
            return getMultipleIncreasing(multiple, num, ++index);
        } else {
            return -1;
        }
    }

    /** @deprecated  <h2>getMultipleDecreasing</h2>
     * Tenta encontrar usando recursividade o fator que corresponde ao múltiplo
     * indicado, percorrendo os possiveis fatores de determinado número de
     * forma decrescente.
     *
     * @param multiple Múltiplo que será procurado dentro dos múltiplos de um
     *                 número
     * @param num Número ao qual será verificado se possuí o múltiplo
     * @param index Representação do fator que será percorrido para se
     *              encontrar o múltiplo correspondente
     *
     * @return Mútiplo correspondente dentro dos múltiplos que determinado
     * número que o possa possuir. Sendo retornado -1 caaso não o encotre
     * */
    private static int getMultipleDecreasing(int multiple, int num, int index) {
        if (multiple == (num * index)) {
            return index;
        } else if (multiple < (num * index)) {
            return getMultipleDecreasing(multiple, num, --index);
        } else {
            return -1;
        }
    }

}
