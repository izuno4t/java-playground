package com.example.mapstruct.withlombok.onetomany;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

class FooBarMapperTest {

    @Test
    void map() {

        var fooEntity = new FooEntity("foo");
        var barEntities = List.of(new BarEntity("bar1"), new BarEntity("bar2"));

        var barList = FooBarMapper.INSTANCE.getBarEntities(barEntities);
        barList.forEach(e -> System.out.println(ToStringBuilder.reflectionToString(e)));

        var fooBar = FooBarMapper.INSTANCE.map(fooEntity, barList);
        System.out.println(ToStringBuilder.reflectionToString(fooBar));


    }
}