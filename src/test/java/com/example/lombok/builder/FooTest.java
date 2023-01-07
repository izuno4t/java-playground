package com.example.lombok.builder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FooTest {


    @Test
    void builder() {

        var foo = Foo.builder().name("foo").address("address").postalCode("10000004").build();
        assertThat(foo) //
                .hasFieldOrPropertyWithValue("name", "foo") //
                .hasFieldOrPropertyWithValue("address", "address") //
                .hasFieldOrPropertyWithValue("postalCode", "10000004");

    }
}
