package org.example;

/**
 Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
 📌 Если длина массива меньше некоторого заданного минимума, метод возвращает -1,
 в качестве кода ошибки, иначе - длину массива.
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] mas = new int[] {1, 5, 4, 6, 5};
        System.out.println(method(mas, 3));
    }

    public static int method(int[] mas, int min){
        if (mas.length < min)
            return -1;
        return mas.length;
    }
}
