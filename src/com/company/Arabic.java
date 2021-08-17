package com.company;

import java.util.Scanner;

public class Arabic {
    Scanner scanner = new Scanner(System.in);
    int numArabic, numArabic2, answer;
    char operation;

    public void getNum() {
        System.out.println("Введите первое число, операцию и второе число (Пример: 5 + 5)\nInput:");
        numArabic = scanner.nextInt();
        operation = scanner.next().charAt(0);
        numArabic2 = scanner.nextInt();
        switch (operation) {
            case '+':
                answer = numArabic + numArabic2;
                break;
            case '-':
                answer = numArabic - numArabic2;
                break;
            case '*':
                answer = numArabic * numArabic2;
                break;
            case '/':
                answer = numArabic / numArabic2;
                break;
            default:
                try {
                    throw new NotMathematicalOperation("Строка не является математической операцией.");
                } catch (NotMathematicalOperation e) {
                    e.printStackTrace();
                }
                return;
        }
        if ((numArabic < 1 || numArabic2 < 1) || (numArabic > 10 || numArabic2 > 10)) {
            try {
                throw new CustomException("Ошибка! Число больше, чем '10' или меньше '0'");
            } catch (CustomException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Output: \n" + answer);
        }
    }

    public void getTwoOperation() {
        System.out.println("Введите первое число, операцию, второе число, операцию и третье число (Пример: 5 + 5 + 5)\nInput:");
        numArabic = scanner.nextInt();
        operation = scanner.next().charAt(0);
        numArabic2 = scanner.nextInt();
        operation = scanner.next().charAt(0);
        numArabic = scanner.nextInt();
        if ((numArabic < 1 || numArabic2 < 1) || (numArabic > 10 || numArabic2 > 10)) {
            System.out.println("Ошибка! Число больше, чем '10' или меньше '0'");
        } else {
            try {
                throw new CustomException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }
    }
}
