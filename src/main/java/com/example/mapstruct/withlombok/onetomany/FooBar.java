package com.example.mapstruct.withlombok.onetomany;

import lombok.Value;

import java.util.List;

@Value
public class FooBar {

    String name;

    List<Bar> barList;

}
