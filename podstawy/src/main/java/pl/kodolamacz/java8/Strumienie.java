package pl.kodolamacz.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Strumienie {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Frania",
                "Ania","Henio", "Trusia", "Kasia", "Ala",
                "Franciszek", "Wojciech");

        List<String> collect = list.stream()
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }

}
