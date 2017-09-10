package pl.kodolamacz.java8;

import java.util.*;

public class Kolekcje {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Frania",
                "Ania","Henio", "Trusia", "Kasia", "Ala",
                "Franciszek", "Wojciech");

        list.forEach(s -> System.out.println("Imie="+s));

        Set<String> set = new HashSet<>(list);
        set.forEach(s -> System.out.println(s));


        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        list.sort((o1, o2) ->
                Integer.compare(o1.length(), o2.length()));

        list.sort(Comparator.comparingInt(s -> s.length()));

        list.sort(Comparator.comparingInt(String::length));

        list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println);
    }

}
