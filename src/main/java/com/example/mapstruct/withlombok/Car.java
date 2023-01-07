package com.example.mapstruct.withlombok;

import lombok.Value;

@Value
public class Car {

    String make;
    int numberOfSeats;
    CarType type;

}
