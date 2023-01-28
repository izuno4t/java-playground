package com.example;

import org.junit.jupiter.api.Test;

import java.util.Optional;

class OptionalTest {

    @Test
    void map() {
        var foo = Optional.of("foo");
        foo.ifPresentOrElse(System.out::println, () -> System.out.println("not foo"));
        var bar = Optional.empty();
        bar.ifPresentOrElse(System.out::println, () -> System.out.println("not foo"));

    }
}