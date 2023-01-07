package com.example.lombok.delegate;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;

@AllArgsConstructor
public class BarFoo {
    @Delegate
    private final Bar bar;

    @Delegate
    private final Foo foo;

}
