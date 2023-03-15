package com.test;


import com.test.entity.Person;

import java.util.function.*;

public class Main {
    public static final Supplier<Person> SUPPLIER = Person::new;
    public static final Consumer<Person> CONSUMER = (p) -> System.out.println("hello! " + p.name);
    public static final Predicate<String> PREDICATE = (s) -> s.length() > 0;
    public static final Function<Integer, String> STRING_INTEGER_FUNCTION = Object::toString;
    public static void main(String[] args) {

        System.out.println(STRING_INTEGER_FUNCTION
                        .compose(String::length)
                        .apply("aaaaa"));
        Person person = SUPPLIER.get();
        System.out.println(person);
        CONSUMER
                .andThen(st -> System.out.println("hhh"))
                .accept(person);
        System.out.println(PREDICATE.test("foo"));
        System.out.println(PREDICATE.negate().test("foo"));

    }

}

