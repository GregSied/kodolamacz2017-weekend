package pl.kodolamacz.java8;

import java.util.Optional;

public class KowalskiBezOpcji {

    public static void main(String[] args) {
        Person bartek = new Person("Bartek");

        // ifn if(... == null)
        // inn if(... != null)
        if(bartek != null){
            Address address = bartek.getAddress();
            if(address != null){
                String street = address.getStreet();
                if (street != null) {
                    System.out.println("Mieszka na ulicy "+street);
                }
            }
        }
    }

    static class Person{
        private String name;
        private Address address;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Address getAddress() {
            return address;
        }
    }

    static class Address {
        String street;
        String city;

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }
    }
}


