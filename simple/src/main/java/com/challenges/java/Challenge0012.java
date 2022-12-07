package com.challenges.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/** <h1>Desafio 0012 - DIO Quantidade de Soma de Quadrados Perfeitos</h1>
 * Dado um inteiro n, retorne o menor número de
 * números quadrados perfeitos cuja soma seja n.
 * Um quadrado perfeito é um inteiro que é o
 * quadrado de um inteiro; em outras palavras,
 * é o produto de algum inteiro consigo mesmo.
 * Por exemplo, 1, 4, 9 e 16 são quadrados
 * perfeitos, enquanto 3 e 11 não são.
 *
 * @author Mauricio Mityo Hidani
 * @since October 18, 2022
 * @version 2.3.0
 * */
public class Challenge0012 {

    public static void main(String[] args) {
        int numero = Integer.parseInt(new Scanner(System.in).nextLine());

        List<Integer> quadsPerfeitos = pegaQuadsPerfeitos(numero);
        List<Integer> resultados = new ArrayList<>();

        //TODO: Com base no valor total, retorne o menor número de quadrados perfeitos.
        resultados.add(somatorio(numero, quadsPerfeitos));
        resultados.add(somatorioPercorreQuadsPerfeitos(numero, quadsPerfeitos));
        resultados.add(somatorioPrimeiroEUltimo(numero, quadsPerfeitos));

        resultados = resultados.stream()
                .filter(resultado -> resultado != -1)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(resultados.get(0));
    }

    /** <h2>pegaQuadsPerfeitos</h2>
     * Encontra os quadrados perfeitos até um determinado número de
     * referência.
     *
     * @param numeroAlvo Número que será utilizado como especie de
     *                   ponto parada ao tentar encontrar os
     *                   quadrados perfeitos existentes
     *
     * @return Lista de quadrados perfeitos encontrados
     * */
    private static List<Integer> pegaQuadsPerfeitos(int numeroAlvo) {
        List<Integer> quadsPerfeitos = new ArrayList<>();
        quadsPerfeitos.add(1);
        int qtdVerifQuadPerfeito = numeroAlvo +1;

        for (int i = 4; i < qtdVerifQuadPerfeito; i++) {
            double raizQuad = Math.sqrt(i);
            double resto = raizQuad - Math.floor(raizQuad);
            if (resto == 0) {
                quadsPerfeitos.add(i);
            }
        }
        return quadsPerfeitos;
    }

    /** <h2>somatorio</h2>
     * Realiza várias somas de quadrados perfeitos que resultem em um número
     * especifico, sendo que pode-se ser somada varias vezes o mesmo quadrado
     * perfeito para averiguar se a soma dos quadrados perfeitos já somados
     * mais a repetição de um mesmo quadrado perfeito possa resultar ao
     * número procurado. Devendo se retornar a quantidade de somas realizadas
     * para se encontrar o quadrado perfeito.
     * Exp Tipo 1: Q₁ + Q₂ + Q₃ = número
     * Exp Tipo 2: Q₁ + Q₂ + (Q₃ + Q₃ + Q₃) = número
     *
     * @param numero Número que está sendo procurado na combinação de somas
     *               de quadrados perfeitos
     * @param quadsPerfeitos Lista de quadrados perfeitos que serão utilizados
     *                       para encontrar o número
     *
     * @return Quantidade de somas realizadas para se encontrar o número,
     * sendo que caso não o encontre deve-se retornar -1
     * */
    private static int somatorio(int numero, List<Integer> quadsPerfeitos) {
        int posicaoUltimoQuadPerf = quadsPerfeitos.size() - 1;
        int soma = 0;
        int qtdSomasRealizadas = 0;

        for (int i = posicaoUltimoQuadPerf; i > -1; i--) {
            soma += quadsPerfeitos.get(i);
            qtdSomasRealizadas++;

            if (soma < numero) {
                int auxQtdSomasRealizadas = 0;
                auxQtdSomasRealizadas = operacaoSomatorioRepeteQuadPerfeito(
                        numero, soma, quadsPerfeitos.get(i));

                if (auxQtdSomasRealizadas != -1) {
                    return auxQtdSomasRealizadas;
                }
            }

            if (soma == numero) {
                return qtdSomasRealizadas;
            }
        }

        return -1;
    }

    /** <h2>somatorioPercorreQuadsPerfeitos</h2>
     * Soma todos os quadrados perfeitos encontrados até que resulte no valor do
     * número indicado, sendo que ainda em cada quadrado perfeito ao estar em sua
     * posição no arrya, será somado varias vezes para averiguar se os últimos
     * quadrados perfeitos somados com a repetição do quadrado perfeito atual
     * resulte no número. Sendo retornado o número de vezes que foi realizado o
     * somatório.
     * Exp: Q₁ + Q₂ + (Q₃ + Q₃ + Q₃) = número
     *
     * @param numero Número que dever ser encontrado usando as somas dos quadrados
     *               perfeitos até que essa soma resulte neste número
     * @param quadsPerfeito Quadrados perfeitos que serão utilizados para o
     *                      somatório
     *
     * @return Resultado da quantidade de
     * */
    private static int somatorioPercorreQuadsPerfeitos(int numero, List<Integer> quadsPerfeito) {
        int ultimoElemento = quadsPerfeito.size() - 1;

        for (int i = ultimoElemento; i > -1; i--) {
            int auxQtdSomasRealizadas = 0;
            auxQtdSomasRealizadas = operacaoSomatorioRepeteQuadPerfeito(
                    numero, quadsPerfeito.get(i));

            if (auxQtdSomasRealizadas != -1) {
                return auxQtdSomasRealizadas;
            }
        }

        return -1;
    }

    /** <h2>somatorioPrimeiroEUltimo</h2>
     * Soma o último quadrado perfeito de uma lista, percorrendo-a a partir
     * do primeiro elemento ao próximo até que essa soma resulte ao número
     * procurado. Sendo que se deve retornar a quantidade de somas realizadas
     * para se obter o resultado perfeito, onde resulte a soma ao número
     * procurado.
     * Exp: 1.Iteração (Q₃ + Q₁ == numero) = false
     *      2.Iteraçao (Q₃ + Q₂ == numero) = true
     *
     * @param numero Número que está sendo procurado, usando da combinação de
     *               somas de quadrados perfeitos que resultem nele
     * @param quadsPerfeitos Lista de quadrados perfeitos que serão utilizados
     *                       para a realização da combinação de somas.
     *
     * @return Quantidade de somas realizadas até se chegar ao número, caso não
     * se encontre deve retornar -1
     * */
    private static int somatorioPrimeiroEUltimo(int numero, List<Integer> quadsPerfeitos) {
        int soma = 0;
        int qtdSomasRealizadas = 0;

        for (int i = 0; i < quadsPerfeitos.size(); i++) {
            soma += quadsPerfeitos.get(i);
            qtdSomasRealizadas++;

            int auxSoma = soma;
            int auxQtdSomasRealizadas = 0;
            int ultimoElemento = (quadsPerfeitos.size() -1) -i;
            for (int j = ultimoElemento; j > -1 && auxSoma < numero; j--) {
                auxSoma += quadsPerfeitos.get(j);
                auxQtdSomasRealizadas++;
            }
            if (auxSoma == numero) {
                qtdSomasRealizadas += auxQtdSomasRealizadas;
                return qtdSomasRealizadas;
            }
        }

        if (soma == numero) {
            return qtdSomasRealizadas;
        }

        return -1;
    }

    /** <h2>operacaoSomatorioRepeteQuadPerfeito</h2>
     * Realiza uma combinação de somatório de quadrado perfeito, que será
     * somado várias vezes na tentativa de que o mesmo resulte no número
     * procurado. Retornando assim, a quantidade de vezes de somas
     * realizadas para se encontrar o número, caso constrario deverá
     * retornar -1.
     *
     * @param numero Número procurado com a combinação de somas de quadrados
     *               perfeitos
     * @param quadPerfeito Quadrado perfeito utilizado na repetição de somas
     *                     que resulte no número
     *
     * @return Quantidade de somas realizadas para encontrar o número, caso
     * não o encontre deverá ser retornado -1
     * */
    private static int operacaoSomatorioRepeteQuadPerfeito(int numero, int quadPerfeito) {
        int soma = 0;
        int qtdSomasRealizadas = 0;

        while (soma < numero) {
            soma += quadPerfeito;
            qtdSomasRealizadas++;
        }

        if (soma == numero) {
            return qtdSomasRealizadas;
        }

        return -1;
    }

    /** <h2>operacaoSomatorioRepeteQuadPerfeito</h2>
     * Realiza uma combinação de somatório de quadrado perfeito, que será
     * somado várias vezes na tentativa de que o mesmo resulte no número
     * procurado, mas utilizando de uma soma já realizada, usada como
     * ponto de partida. Retornando assim, a quantidade de vezes de somas
     * realizadas para se encontrar o número, caso constrario deverá
     * retornar -1.
     *
     * @param numero Número procurado com a combinação de somas de quadrados
     *               perfeitos
     * @param auxiliar Usada como ponto de partida para a realização do
     *                 somatório, sendo que a soma do quadrado perfeito
     *                 será somada partindo-se desse valor, que vem de uma
     *                 soma de outros quadrados perfeitos
     * @param quadPerfeito Quadrado perfeito utilizado na repetição de somas
     *                     que resulte no número
     *
     * @return Quantidade de somas realizadas para encontrar o número, caso
     * não o encontre deverá ser retornado -1
     * */
    private static int operacaoSomatorioRepeteQuadPerfeito(int numero, int auxiliar, int quadPerfeito) {
        int soma = auxiliar;
        int qtdSomasRealizadas = 0;

        while (soma < numero) {
            soma += quadPerfeito;
            qtdSomasRealizadas++;
        }

        if (soma == numero) {
            return qtdSomasRealizadas;
        }

        return -1;
    }

}
