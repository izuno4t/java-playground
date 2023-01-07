package com.example.mapstruct.withlombok;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonMapperTest {

    @Test
    void testConstructorMapping() {

        var dto = new PersonDto("foo", "bar");
        var person = PersonMapper.INSTANCE.map(dto);
        System.out.println(ToStringBuilder.reflectionToString(person));
        System.out.println(ToStringBuilder.reflectionToString(dto));

        assertThat(person).usingRecursiveComparison().isEqualTo(dto);

    }

    @Test
    void testBuilderMapping() {

        var person = new Person("foo", "bar");
        var dto = PersonMapper.INSTANCE.map(person);
        System.out.println(ToStringBuilder.reflectionToString(person));
        System.out.println(ToStringBuilder.reflectionToString(dto));

        assertThat(person).usingRecursiveComparison().isEqualTo(dto);

    }
}
