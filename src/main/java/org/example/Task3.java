package org.example;

/***
 * Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
 * Метод должен пройтись по каждому элементу и проверить что он не равен null.
 * А теперь реализуйте следующую логику:
 * 1. Если в какой-то ячейке встретился null,
 * то необходимо “оповестить” об этом пользователя
 * 2. Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”
 */

public class Task3 {

    public static void main(String[] args) {
        Integer[] mas = new Integer[] {1,2,null,4,null,6};

        try{
            checkArray(mas);
        } catch (RuntimeException e){
            System.out.println();
            System.out.println(e);
        }


    }

    public static void checkArray(Integer[] mas){

        boolean isNull = false;

        for (int i = 0; i <mas.length; i++) {
            if (mas[i] == null) {
                isNull = true;
                System.out.print(" \u001B[31m" + mas[i] + "\u001B[0m" + ", ");
            } else {
                System.out.print(mas[i] + ", ");
            }
        }
        if (isNull){
            throw new RuntimeException("В массиве присутствует Null!");
        }

    }

    //***Задание №7 (доп) Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    // и возвращающий новый массив, каждый элемент которого равен сумме элементов двух входящих массивов
    // в той же ячейке. Если длины массивов не равны, необходи мо как-то оповестить пользователя.
}
