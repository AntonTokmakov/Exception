package seminar2;

import javax.swing.plaf.metal.MetalIconFactory;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Задание №3
 * Запишите в файл следующие строки:
 * Анна=4
 * Елена=5
 * Марина=6
 * Владимир=?
 * Константин=?
 * Иван=4
 * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap, если
 * студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных, если сохранено
 * значение ?, заменить его на соответствующее число.Если на каком-то месте встречается символ, отличный от
 * числа или ?, бросить подходящее исключение.Записать в тот же файл данные с замененными символами ?.
 */

public class Task1 {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Anton\\Downloads\\Project\\GB\\src\\main\\java\\seminar2\\names.txt");
        Map<String, String> names = readFile(file);

        modificationValues(names);
//        for (Map.Entry<String, String> entry : names.entrySet()) {
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }
        writeFile(file, names);
    }

    public static HashMap<String, String> readFile(File file) {

        HashMap<String, String> names = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = "";
            while ((str = reader.readLine()) != null){
                String[] mas = str.split("=");
                if (mas.length != 2){
                    System.out.println("Некорректная строка: " + str);
                    continue;
                }
                names.put(mas[0], mas[1]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return names;
    }

    public static void modificationValues(Map<String, String> names){

        for (Map.Entry<String, String> entry : names.entrySet()) {
            if (!(entry.getValue().equals("?") || checkInteger(entry.getValue()))){
                throw new RuntimeException("Значение не принадлежит \"?\" и числу.");
            }
            if (entry.getValue().equals("?")){
                entry.setValue(String.valueOf(entry.getKey().length()));
            }
        }
    }

    public static boolean checkInteger(String values) {
        try {
            Integer.parseInt(values);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static void writeFile(File file, Map<String, String> names){
        BufferedWriter write = null;
        try {
            write = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry : names.entrySet()) {
                write.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (write != null) {
                    write.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
