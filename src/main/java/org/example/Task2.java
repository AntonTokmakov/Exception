package org.example;


/***
 Задание №2 Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
 Необходимо посчитать и вернуть сумму элементов этого массива.
 При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами (кол-во строк = кол-ву столбцов),
 и в каждой ячейке может лежать только значение 0 или 1.
 Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
 */
public class Task2 {

    public static void main(String[] args) {

        int[][] mas = new int[][] {
                {1, 2, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        System.out.println(method(mas));
    }

    public static int method(int[][] mas){

        if (!(mas.length == mas[0].length)){
            throw new RuntimeException("Данным массив не является квадратным");
        }

        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[1].length; j++) {
                if (mas[i][j] != 0 && mas[i][j] != 1) {
                    throw new RuntimeException("Значения в массиве не являются 0 или 1");
                }
                sum += mas[i][j];
            }
        }
        return sum;
    }

}
