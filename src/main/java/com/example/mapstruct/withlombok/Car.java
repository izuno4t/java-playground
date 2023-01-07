package com.example.mapstruct.withlombok;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {

    String make;
    int seatCount;
    CarType type;

}
