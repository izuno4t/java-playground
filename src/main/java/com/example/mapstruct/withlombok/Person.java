package com.example.mapstruct.withlombok;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Person {
    String name;
    String surname;
}
