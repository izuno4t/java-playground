package com.example.lombok.delegate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FooBarTest {

    @Test
    void testDelegate() {
        var foo = new Foo("foo", "address");
        var bar = new Bar("bar", 1);
        var fooBar = new FooBar(foo, bar);
        assertEquals("foo", fooBar.getName());
        assertEquals("address", fooBar.getAddress());
        assertEquals("bar", fooBar.getBarName());
        assertEquals(1, fooBar.getCounter());

        var barFoo = new BarFoo(bar, foo);
        assertEquals("bar", barFoo.getName());
        assertEquals(1, barFoo.getCounter());
    }

}
