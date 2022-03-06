package com.example.api.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpRequest.Builder;
import static java.net.http.HttpRequest.newBuilder;

public class NativeHttpClient {

    private static final Logger logger = LoggerFactory.getLogger(NativeHttpClient.class);

    private static final String SERVER_1 = "https://httpbin.org/";

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public void request() throws IOException, InterruptedException {
        for (int i = 0; i < 11; i++) {
            Builder builder = newBuilder().uri(URI.create(SERVER_1 + "/get?q=" + i))
                    .GET();
            HttpRequest request = builder.build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("status code:{}", response.statusCode());
            logger.info("body: {}", response.body());

        }
    }
}
