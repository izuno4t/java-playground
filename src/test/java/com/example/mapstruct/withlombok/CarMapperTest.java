package com.example.mapstruct.withlombok;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarMapperTest {

    @Test
    void carToCarDto() {

        //given
        var car = new Car("Morris", 5, CarType.SEDAN);

        //when
        var carDto = CarMapper.INSTANCE.carToCarDto(car);

        //then
        assertThat(carDto).isNotNull();
        assertThat(carDto.getMake()).isEqualTo("Morris");
//        assertThat(carDto.getSeatCount()).isEqualTo(5);
//        assertThat(carDto.getType()).isEqualTo("SEDAN");

        System.out.println(ToStringBuilder.reflectionToString(car));
        System.out.println(ToStringBuilder.reflectionToString(carDto));
    }
}
