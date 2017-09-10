package pl.kodolamacz.java8;

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
    }

    public static void lambda(){
        Optional<Person> bartek =
                Optional.of(new Person("Bartek"));

        Optional<String> street = bartek
                .flatMap(Person::getAddress)
                .flatMap(Address::getStreet);

        Optional<String> s = bartek
                .map(person -> person.getName())
                .filter(name -> name.length() >= 3)
                .map(name -> name.substring(0, 3));
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

class Person{
    private String name;
    private Address address;

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
