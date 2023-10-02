package practice54;
/**
 *  TASK 1.Пусть есть текстовый файл такого вида:
 *     1
 *     2
 *     3
 *     4
 *     5
 *     Нужно написать метод, принимающий файл и возвращающий
 *     сумму всех значений
 */


import java.io.*;

public class Main {
    public static int sumOfStrToInt(File file) throws IOException {
        int intSum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                int intNum = Integer.parseInt(line);
                intSum += intNum;
            }
        }
        return intSum;
    }

    public static String findLongestLine(File file) throws IOException {
        String strLongest = null;
        int maxLen = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() > maxLen) {
                    maxLen = line.length();
                    strLongest = line;
                }
            }
        }

        return strLongest;
    }



    public static void main(String[] args) {
        File f = new File("f.txt");
        System.out.println(f.exists());
        try {
            int intSum = sumOfStrToInt(f);
            System.out.println("SUM: " + intSum);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}






