package com.github.timpeeters;

import com.github.tomakehurst.wiremock.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class FirstTest extends AbstractTest {

    @Test
    void firstTest() throws IOException, InterruptedException {
        WIREMOCK.stubFor(get(urlPathEqualTo("/first")).willReturn(ok()));

        var request = HttpRequest.newBuilder().GET()
                .uri(URI.create(WIREMOCK.baseUrl() + "/first"))
                .build();

        assertThat(client.send(request, HttpResponse.BodyHandlers.discarding()).statusCode()).isEqualTo(200);
    }
}
