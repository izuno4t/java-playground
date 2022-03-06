package com.example.http.client;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class NativeHttpClientTest {

    private static final Logger logger = LoggerFactory.getLogger(NativeHttpClientTest.class);

    MockWebServer server;

    String baseUrl;

    @BeforeEach
    void setUp() throws IOException {
        server = new MockWebServer();
        server.start();
        baseUrl = StringUtils.chop(server.url("").toString());
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }


    @Test
    void testRequest() throws IOException, InterruptedException {

        var responseBody = """
                {
                  "args": {},
                  "headers": {
                    "Accept": "application/json",
                    "Accept-Encoding": "gzip, deflate, br",
                    "Accept-Language": "ja,en-US;q=0.9,en;q=0.8",
                    "Dnt": "1",
                    "Host": "httpbin.org",
                    "Referer": "https://httpbin.org/",
                    "Sec-Ch-Ua": "\\" Not A;Brand\\";v=\\"99\\", \\"Chromium\\";v=\\"98\\", \\"Google Chrome\\";v=\\"98\\"",
                    "Sec-Ch-Ua-Mobile": "?0",
                    "Sec-Ch-Ua-Platform": "\\"macOS\\"",
                    "Sec-Fetch-Dest": "empty",
                    "Sec-Fetch-Mode": "cors",
                    "Sec-Fetch-Site": "same-origin",
                    "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.109 Safari/537.36",
                    "X-Amzn-Trace-Id": "Root=1-6223f986-3f1e8c56147a08d244510c41"
                  },
                  "origin": "121.111.182.24",
                  "url": "https://httpbin.org/get"
                }
                """;

        server.enqueue(new MockResponse().setBody(responseBody));
        server.enqueue(new MockResponse().setBody(responseBody));


        var client = new NativeHttpClient(baseUrl);
        client.request();

        // request 1回目
        var request1 = server.takeRequest();
        logger.info("1回目のリクエスト: {}", request1.getRequestUrl());
        assertThat(request1.getRequestUrl()).hasToString(baseUrl + "/post?seq=1");
        assertThat(request1.getBody().readString(StandardCharsets.UTF_8)).isEqualTo("""
                {
                    "foo":"bar1"
                }
                """);

        // request 2回目
        var request2 = server.takeRequest();
        logger.info("2回目のリクエスト: {}", request2.getRequestUrl());
        assertThat(request2.getRequestUrl()).hasToString(baseUrl + "/post?seq=2");
        assertThat(request2.getBody().readString(StandardCharsets.UTF_8)).isEqualTo("""
                {
                    "foo":"bar2"
                }
                """);

    }
}