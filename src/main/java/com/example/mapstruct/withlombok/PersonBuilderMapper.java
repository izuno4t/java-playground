package com.example.mapstruct.withlombok;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonBuilderMapper {

    PersonBuilderMapper INSTANCE = Mappers.getMapper(PersonBuilderMapper.class);

    Person map(PersonDto dto);

    PersonDto map(Person person);


}
