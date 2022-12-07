package com.challenges.java;

import java.util.Scanner;

/**<h1>Desafio 014 - DIO Fatorial Desajeitado</h1>
 * Realizar uma operação de fatorial que ao invés de realizar
 * apenas a operação de multiplicação dos números que decrecem
 * até se chegar ao resultado esperado do fatorial de
 * determinado número. Deve-se trocar a multiplicação pela
 * sequência de operações aritméticas: * / + -
 * Estas devem se repetir até que o resultado desse fatorial
 * desajeitado seja resolvido.
 *
 * @author Mauricio Mityo Hidani
 * @since October 18, 2022
 * @version 2.0.0
 * */
public class Challenge0014 {

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int cnt = 1;
        int tmp = n;
        int res = 0;
        int pos = 0;

        n--;
        if (tmp > 2) {
            while (n > 0) {
                switch (cnt) {
                    case 1: tmp *= n;
                        break;
                    case 2: tmp /= n;
                        break;
                    case 3: pos += n;
                        break;
                    case 4: res = (res == 0) ? tmp : res - tmp;
                        break;
                }

                if (cnt == 4) {
                    tmp = n;
                    cnt = 1;
                    n--;
                } else {
                    n--;
                    cnt++;
                }

                if (n == 0) {
                    res = (res == 0) ? tmp : res - tmp;
                }
            }
            res += pos;

        } else if (n == 2) {
            res = 2;

        }

        System.out.println(res);
    }

}
