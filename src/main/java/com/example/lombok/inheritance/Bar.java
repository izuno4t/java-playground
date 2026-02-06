package com.example.lombok.inheritance;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class Bar extends Foo {

    String name;

    Integer age;

    Long revision;


}
