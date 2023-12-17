package ru.hcimor.multiple;

// Этот класс предназначен для поиска Наибольшего Общего Делителя (НОД) и Наименьшего Общего Кратного (НОК)
public class calculateMultiple {

    // Вовращает НОД
    public static Integer getNOD (int a, int b){
        // Алгоритм Евклида для нахождения НОД
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Возвращает НОК
    public static Integer getNOK (int a, int b){
        // Используем формулу НОК(a, b) = |a * b| / НОД(a, b)
        return Math.abs(a * b) / getNOD(a, b);
    }
}
