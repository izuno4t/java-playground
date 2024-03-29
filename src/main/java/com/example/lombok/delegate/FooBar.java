package com.example.lombok.delegate;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;

@AllArgsConstructor
public class FooBar {

    @Delegate
    private final Foo foo;

    @Delegate
    private final Bar bar;

    public String getBarName() {
        return bar.getName();
    }
}
