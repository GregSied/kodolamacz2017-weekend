package pl.kodolamacz.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Strumienie {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Frania",
                "Ania","Henio", "Trusia", "Kasia", "Ala",
                "Franciszek", "Wojciech");

        // ten kod
        List<String> collect = list.stream()
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());

        // jest równoważny temu:
        List<String> collect2 = new ArrayList<>();
        for (String s : list) {
            if(s.startsWith("A")){
                collect2.add(s);
            }
        }

        list.stream()
                .filter(s -> s.startsWith("A"))
                .forEach(s -> System.out.println());

        collect.forEach(System.out::println);

        list.stream()
                .filter(s -> s.length() > 3)
                .filter(s -> s.startsWith("F") || s.startsWith("W"))
                .map(Strumienie::addSurname)
                .forEach(System.out::println);
    }

    private static String addSurname(String s) {
        if (s.endsWith("a")) {
            return s + " Kowalska";
        } else {
            return s + " Kowalski";
        }
    }
}
