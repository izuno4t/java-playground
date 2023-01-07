package com.example.lombok.delegate;

import lombok.Value;
import lombok.experimental.Delegate;

@Value
public class FooBar {

    @Delegate
    Foo foo;

    @Delegate
    Bar bar;

}
