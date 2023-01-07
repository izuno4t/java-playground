package com.example.mapstruct.withlombok;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);


    // Personはコンストラクタでしかインスタンス化できないので、コンストラクタでマッピング
    Person map(PersonDto dto);

    PersonDto map(Person person);


}
