package pl.kodolamacz.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Strumienie {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Frania",
                "Ania","Henio", "Trusia", "Kasia", "Ala",
                "Franciszek", "Wojciech", "Bartek", "Bogdan");

        // ten kod
        List<String> collect = list.stream()
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
        // jest równoważny temu:
        List<String> collect2 = new ArrayList<>();
        for (String s : list) {
            if(s.startsWith("A")){
                collect2.add(s);
            }
        }

        // filter
        System.out.println("Zaczynające się na A");
        list.stream()
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);

        // filter + map

        System.out.println("Dłuższe niż 3, zaczynające się na F i W z nazwiskiem");
        list.stream()
                .filter(s -> s.length() > 3)
                .filter(s -> s.startsWith("F") || s.startsWith("W"))
                .map(Strumienie::addSurname)
                .forEach(System.out::println);

        // sorted
        long count = list.stream()
                .filter(s -> s.startsWith("A") | s.startsWith("B"))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .peek(s -> System.out.println(s))
                .count();

        Comparator<String> stringLengthComparator =
                (s1, s2) -> Integer.compare(s1.length(), s2.length());


        int counter = 0;
        for (String s : list) {
            if(s.startsWith("A") | s.startsWith("B")){
                counter++;
            }
        }

        System.out.println("Imion na A i B jest "+count);

        // anyMatch allMatch
        boolean all = list.stream().allMatch(s -> s.endsWith("a"));
        boolean any = list.stream().anyMatch(s -> s.endsWith("a"));

        boolean anyFilter = list.stream()
                .filter(s -> s.endsWith("a")).count() > 0;

        boolean allFilter = list.stream()
                .filter(s -> s.endsWith("a")).count() == list.size();


        // map vs flatMap
        Person bartek = new Person("Bartek");
        Person antek = new Person("Antek");
        Person franio = new Person("Franio");
        Person henio = new Person("Henio");
        bartek.addFriend(antek);
        bartek.addFriend(franio);
        bartek.addFriend(henio);
        antek.addFriend(bartek);
        franio.addFriend(henio);

        List<Person> persons = Arrays.asList(bartek, antek, franio, henio);

        System.out.println("Zwykły MAP");
        persons.stream().map(person -> person.getFriends())
        .forEach(System.out::println);

        System.out.println("FLAT MAP");
        persons.stream().flatMap(person -> person.getFriends().stream())
                .sorted()
                .forEach(System.out::println);

        Stream<List<Person>> listStream = persons.stream().map(person -> person.getFriends());

        Optional<String> reduce = list.stream().reduce((s1, s2) ->
                s1 + "@" + s2);

        reduce.ifPresent(s -> System.out.println(s));

        String reduce1 = list.stream().reduce("", (s1, s2) ->
                s1 + "@" + s2);
        System.out.println(reduce1);


        AverageCalculator reduce2 = Arrays.asList(3.0, 5.0, 8.0, 3.12, 66.0).stream()
                .reduce(new AverageCalculator(),
                        (ac, v) -> ac.add(v),
                        (ac1, ac2) -> ac1.add(ac2)
                );

        System.out.println(reduce2.sum/reduce2.count);
    }

    static class AverageCalculator{
        double sum = 0;
        int count = 0;

        AverageCalculator add(Double v){
            sum += v;
            count++;
            return this;
        }

        AverageCalculator add(AverageCalculator other){
            sum += other.sum;
            count += other.count;
            return this;
        }
    }

    private static String addSurname(String s) {
        if (s.endsWith("a")) {
            return s + " Kowalska";
        } else {
            return s + " Kowalski";
        }
    }
}

