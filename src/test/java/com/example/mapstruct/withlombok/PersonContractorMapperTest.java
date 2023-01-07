package com.example.mapstruct.withlombok;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;

class PersonContractorMapperTest {

    @Test
    void map() {

        var dto = new PersonDto("foo", "bar");
        var person = PersonContractorMapper.INSTANCE.map(dto);
        var dto2 = PersonContractorMapper.INSTANCE.map(person);
        System.out.println(ToStringBuilder.reflectionToString(person));
        System.out.println(ToStringBuilder.reflectionToString(dto));
        System.out.println(ToStringBuilder.reflectionToString(dto2));

    }
}
