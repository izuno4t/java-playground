package com.example.lombok.builder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Foo {

    String name;
    String address;
    String postalCode;

}
