package pl.kodolamacz.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class KowalskiOpcje {



    public static void main(String[] args) {
        Optional<Person> bartek =
                Optional.of(new Person("Bartek"));

        Optional<Address> address = bartek.flatMap(new AddressGetter());
        Optional<String> street = address.flatMap(new StreetGetter());
        if(street.isPresent()){
            System.out.println("Mieszka na ulicy "+street.get());
        }

        printFirstThreeLettersOfName(bartek);
        printFirstThreeLettersOfName(Optional.of(new Person("Al")));
    }

    public static void lambda(){
        Optional<Person> bartek =
                Optional.of(new Person("Bartek"));

        Optional<String> street = bartek
                .flatMap(Person::getAddress)
                .flatMap(Address::getStreet);

        printFirstThreeLettersOfName(bartek);
    }

    private static void printFirstThreeLettersOfName(Optional<Person> person) {
        String streetPrefix = "ul";

        Optional<String> s = person
                .map(Person::getName)
                .filter(name -> name.length() >= 3)
                .map(name -> name.substring(0, 3));
        s.ifPresent(str ->
            System.out.println(streetPrefix + str)
        );
    }

}

class AddressGetter implements Function<Person, Optional<Address>>{
    @Override
    public Optional<Address> apply(Person person) {
        return person.getAddress();
    }
}

class StreetGetter implements Function<Address, Optional<String>>{

    @Override
    public Optional<String> apply(Address address) {
        return address.getStreet();
    }
}

class Person implements Comparable<Person>{
    private String name;
    private Address address;
    private List<Person> friends = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Optional<Address> getAddress() {
        // warunek ? jesliTrue : jesliFalse
        // value == null ? empty() : of(value);
        return Optional.ofNullable(address);
    }

    void addFriend(Person person){
        this.friends.add(person);
    }

    public List<Person> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}

class Address {
    String street;
    String city;

    public Optional<String> getStreet() {
        return Optional.ofNullable(street);
    }

    public String getCity() {
        return city;
    }
}
