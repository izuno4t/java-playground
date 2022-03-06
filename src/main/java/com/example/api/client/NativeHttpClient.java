package com.example.api.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import static java.net.http.HttpRequest.BodyPublishers;
import static java.net.http.HttpRequest.newBuilder;

public class NativeHttpClient {

    private static final Logger logger = LoggerFactory.getLogger(NativeHttpClient.class);

    private final String baseUrl;

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public NativeHttpClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void request() throws IOException, InterruptedException {
        var requestBody1 = """
                {
                    "foo":"bar1"
                }
                """;
        post(requestBody1, "1");
        var requestBody2 = """
                {
                    "foo":"bar2"
                }
                """;
        post(requestBody2, "2");
        
    }

    public void post(String requestBody, String seq) throws IOException, InterruptedException {
        var request = newBuilder(URI.create(baseUrl + "/post?seq=" + seq))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(requestBody))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        logger.info("status code:{}", response.statusCode());
    }


}
