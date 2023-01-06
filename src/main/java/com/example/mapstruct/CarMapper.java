package com.example.mapstruct;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    @Mapping(source = "make", target = "makes")
    CarDto carToCarDto(Car car);
}
