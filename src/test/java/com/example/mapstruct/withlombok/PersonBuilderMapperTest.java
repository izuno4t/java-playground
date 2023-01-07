package com.example.mapstruct.withlombok;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;

class PersonBuilderMapperTest {

    @Test
    void map() {

        var dto = new PersonDto("foo", "bar");
        var person = PersonBuilderMapper.INSTANCE.map(dto);
        var dto2 = PersonBuilderMapper.INSTANCE.map(person);
        System.out.println(ToStringBuilder.reflectionToString(person));
        System.out.println(ToStringBuilder.reflectionToString(dto));
        System.out.println(ToStringBuilder.reflectionToString(dto2));

    }
}
