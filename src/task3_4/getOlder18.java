package task3_4;
/**
 * 3. Пусть есть текстовый файл такого вида:
 *         Peter,35
 *         Simon,5
 *         John,90
 *         Нужно написать метод, читающий этот файл и возвращающий список людей старше 18 лет,
 *         отсортированный по возрасту. Известно, что файл не пустой
 *         public static List<Person> composeList( String fileName)
 *
 * 4. Пусть есть класс Person c полями name  и age. Нужно написать метод, записывающий в файл объекты
 *       класса Person в виде строк и одновременно выводящий их на экран
 *
 */

import java.io.*;
import java.util.*;

public class getOlder18
{
    public static class Person {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
        @Override
        public String toString() {
            return name + ", " + age;
        }
    }



// Task 3   (method)
// read persons from file, get older than 18y.o. & return list of them
    public static List<Person> getOlder18(File file) throws IOException {
        List<Person> people = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int age = Integer.parseInt(parts[1].trim());
                    people.add(new Person(name, age));
                }
            }
        }
        List<Person> olderThan18 = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge() > 18) {
                olderThan18.add(person);
            }
        }
        olderThan18.sort(Comparator.comparingInt(Person::getAge));
        return olderThan18;
    } // (END Task 3 method)

    // Task 4
    // write to  allPerson.txt
    public static void printAndOutPersons(List<Person> persons, String fName) throws IOException {
        try (PrintWriter writer = new PrintWriter(fName)) {
            for (Person person : persons) {
                String personStr = person.toString();
                writer.println(personStr);
                System.out.println(personStr);
            }
        }
    }// (END Task 4 method)
    public static void main(String[] args) {
        // Task 3
        File inpFile = new File("persons.txt");
        try {
            List<Person> olderThan18 = getOlder18(inpFile);
            for (Person person : olderThan18) {
                System.out.println(person.getName() + ", " + person.getAge());
            }

        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println("--------End Task 3--------");

        // task 4
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Peter", 35));
        persons.add(new Person("Simon", 5));
        persons.add(new Person("John", 90));
        persons.add(new Person("Ann", 25));
        try {
            printAndOutPersons(persons, "persons1.txt");
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println("--------End Task 4--------");
    }
}


