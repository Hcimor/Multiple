package ru.hcimor.multiple;

import java.util.ArrayList;
import java.util.List;

// Класс расскладывает числа на простые множители
public class primeFactorization {
     // Метод класса getPrimeFactors возвращает ArrayList с простыми множителями для переданного числа
     public static List<Integer> getPrimeFactors(int number){
         List<Integer> primeFactors = new ArrayList<>();

         for (int i = 2; i <= number; i++) {
             while (number % i == 0) {
                 primeFactors.add(i);
                 number /= i;
             }
         }

         return primeFactors;
     }
     // Метод получает список с простыми множителями и возвращает их в виде строки
    public static String getPrimeFactors(List<Integer> primeFactors){
         String result = "";
         for (int factor: primeFactors){
             result += String.valueOf(factor) + " ";
         }

        // Удаляем последний пробел в строке и возвращаем результат
        return result.trim();
    }
}
