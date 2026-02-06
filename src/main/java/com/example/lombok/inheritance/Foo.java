package com.example.lombok.inheritance;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class Foo {

    String createdBy;

    LocalDateTime createdAt;

}
