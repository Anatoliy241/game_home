package com.example.home;

import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberToGuess = (int) (Math.random() * 100) + 1;
        int numberOfTries = 0;
        int bestScore = Integer.MAX_VALUE;
        boolean hasWon = false;

        System.out.println("Компьютер загадал число от 1 до 100. Попробуйте угадать!");

        while (!hasWon) {
            System.out.print("Введите число (или команду RESULT): ");
            String input = scanner.nextLine();
            numberOfTries++;

            if (input.equalsIgnoreCase("RESULT")) {
                System.out.println("Текущее количество попыток: " + numberOfTries);
                System.out.println("Лучший результат: " + (bestScore == Integer.MAX_VALUE ? "еще нет" : bestScore));
                continue;
            }

            int guess;
            try {
                guess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число.");
                continue;
            }

            if (guess < numberToGuess) {
                System.out.println("Я сам в шоке, но, загаданное число больше, брат.");
            } else if (guess > numberToGuess) {
                System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат.");
            } else {
                hasWon = true;
                System.out.println(
                        "Поздравляю! Вы угадали число " + numberToGuess + " за " + numberOfTries + " попыток.");
                if (numberOfTries < bestScore) {
                    bestScore = numberOfTries;
                }
                System.out.println("Лучший результат: " + bestScore);
            }
        }

        scanner.close();
    }
}