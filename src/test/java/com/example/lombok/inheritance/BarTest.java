package com.example.lombok.inheritance;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class BarTest {

    @Test
    void main() {
        var bar = new Bar("name", 12, 1L);
        bar.setCreatedBy("createdBy");
        bar.setCreatedAt(LocalDateTime.now());
    }

}