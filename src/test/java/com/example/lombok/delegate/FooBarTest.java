package com.example.lombok.delegate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FooBarTest {

    @Test
    void testDelegate() {
        var foo = new Foo("foo");
        var bar = new Bar("bar");
        FooBar fooBar = new FooBar(foo, bar);
        fooBar.getName();
        assertEquals("foo", bar.getName());
    }

}
