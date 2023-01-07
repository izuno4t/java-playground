package com.example.mapstruct.withlombok;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonContractorMapper {

    PersonContractorMapper INSTANCE = Mappers.getMapper(PersonContractorMapper.class);

    Person map(PersonDto dto);

    PersonDto map(Person person);


}
