package com.example.mapstruct.withlombok.onetomany;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FooBarMapper {

    FooBarMapper INSTANCE = Mappers.getMapper(FooBarMapper.class);

    List<Bar> getBarEntities(List<BarEntity> barEntities);

    FooBar map(FooEntity fooEntity, List<Bar> barList);

    Bar map(BarEntity entity);

    BarEntity map(Bar bar);


}
