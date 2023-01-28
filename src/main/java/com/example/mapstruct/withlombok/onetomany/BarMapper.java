package com.example.mapstruct.withlombok.onetomany;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BarMapper {

    BarMapper INSTANCE = Mappers.getMapper(BarMapper.class);

    Bar map(BarEntity entity);

    BarEntity map(Bar bar);


}
