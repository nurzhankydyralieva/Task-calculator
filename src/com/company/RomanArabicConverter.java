package com.company;

import java.util.List;
import java.util.Scanner;

public class RomanArabicConverter {
    Scanner scanner = new Scanner(System.in);
    int answer, numRoman, numRoman2;
    char operation;

    public void getRomanNum() {
        System.out.println("Введите первое число, операцию и второе число (Пример: X + X)\nInput:");
        numRoman = romanToArabic(scanner.next());
        operation = scanner.next().charAt(0);
        numRoman2 = romanToArabic(scanner.next());
        switch (operation) {
            case '+':
                answer = numRoman + numRoman2;
                break;
            case '-':
                answer = numRoman - numRoman2;
                break;
            case '*':
                answer = numRoman * numRoman2;
                break;
            case '/':
                answer = numRoman / numRoman2;
                break;
            default:
                try {
                    throw new NotMathematicalOperation("Строка не является математической операцией.");
                } catch (NotMathematicalOperation e) {
                    e.printStackTrace();
                }
                return;
        }
        if ((numRoman < 1 || numRoman2 < 1) || (numRoman > 10 || numRoman2 > 10)) {
            try {
                throw new CustomException("Ошибка! Число больше, чем 'X' или меньше '0'");
            } catch (CustomException e) {
                e.printStackTrace();
            }

        } else {
            String numRoman = arabicToRoman(answer);
            System.out.println("Output:\n" + numRoman);
        }
    }

    public int romanToArabic(String input) {

        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " Используются одновременно разные систесы счисления");
        }

        return result;
    }

    public String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " В римской системе нет отрицательных чисел");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (number > 0 && i < romanNumerals.size()) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
