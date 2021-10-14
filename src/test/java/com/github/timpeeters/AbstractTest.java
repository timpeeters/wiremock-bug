package com.github.timpeeters;

import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.net.http.HttpClient;
import java.time.Duration;

abstract class AbstractTest {

    @RegisterExtension
    protected static final WireMockExtension WIREMOCK = WireMockExtension.newInstance().build();

    protected static HttpClient client;

    @BeforeAll
    static void createClient() {
        client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();
    }
}
