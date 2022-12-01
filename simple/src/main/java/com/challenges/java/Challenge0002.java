package com.challenges.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**<h1>Desafio 002 - Calculando tempo de vida em dias</h1>
 * Peque uma data de nascimento de uma pesso e calcule quanto tempo de
 * vida essa pessoa poussí, mas expressa em dias.
 *
 * @author Mauricio Mityo Hidani
 * @since October 26, 2022
 * @version 1.0.0 */
public class Challenge0002 {

    public static void main(String[] args) {
        final Locale BR = new Locale("pt", "BR");
        final Scanner scan = new Scanner(System.in, "UTF-8")
                .useLocale(BR);

        System.out.println("Confira sue tempo de vida expresso em dias, inserindo sua " +
                "data de nascimento.");

        final LocalDate currentDate = LocalDate.now();
        final LocalDate birthDate = getBirthDate(scan);
        final int ageConvertedByDays = getDaysInBirthDate(currentDate, birthDate);

        System.out.println("Seu tempo de vida expressa em dias é de " + ageConvertedByDays);
    }

    /** <h1>getBirth</h1>
     * Pega a data de nascimento inserida pelo usuário.
     *
     * @param scan usada para capturar a entrada de dados do usuário
     * @return data de nascimento convertida em LocalDate
     * */
    private static LocalDate getBirthDate(Scanner scan) {
        boolean exit = false;
        LocalDate birthDate = null;

        do {
            System.out.println("Exemplo de data de nascimento: 01/01/1990");
            System.out.print("Informe a data de nascimento: ");
            final String date = scan.next();

            if (checkDate(date)) {
                final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                birthDate = LocalDate.parse(date, formatter);
                exit = true;

            } else {
                System.out.println("O formato informado não é válido!" + '\n');
            }
        } while (!exit);

        return birthDate;
    }

    /** <h1>getDaysInBirthDate</h1>
     * Pega e converte a data de nascimento do usuário no seu tempo de vida expresso em
     * dias.
     *
     * @param currentDate data atual do sistema
     * @param birthDate data de nascimento do usuário
     * @return tempo de vida do usuário expresso em dias
     * */
    private static int getDaysInBirthDate(LocalDate currentDate, LocalDate birthDate) {
        final int currentYear = currentDate.getYear();
        final int birthYear = birthDate.getYear();
        final int birthMonth = birthDate.getMonthValue();
        final int birthDay = birthDate.getDayOfMonth();
        final int result = ((currentYear - birthYear) * 365) + (birthMonth * 30) + (birthDay);

        return result;
    }

    /** <h1>checkDate</h1>
     * Verifica se a data de nascimento inserida pelo usuário, atende ao formato especificado
     * pela applicação (dia/mês/ano), além de se o seu valor é especificado como um data.
     *
     * @param date entrada de dados inserida pelo usuário
     * @return verificação se a data atende ao formado e corresponde a um valor válido
     * */
    private static boolean checkDate(String date) {
        final Pattern pattern = Pattern.compile("([0-9]{2})\\/([0-9]{2})\\/([0-9]{4})");
        final Matcher matcher = pattern.matcher(date);
        final boolean result = matcher.find();

        return  result;
    }

}
