package com.example.api.client;

import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

class NativeHttpClientTest {

    @BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    @org.junit.jupiter.api.Test
    void testRequest() throws IOException, InterruptedException {
        var client = new NativeHttpClient();
        client.request();
    }
}