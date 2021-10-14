package com.github.timpeeters;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class SecondTest extends AbstractTest {

    @Test
    void secondTest() throws IOException, InterruptedException {
        WIREMOCK.stubFor(get(urlPathEqualTo("/second")).willReturn(ok()));

        var request = HttpRequest.newBuilder().GET()
                .uri(URI.create(WIREMOCK.baseUrl() + "/second"))
                .build();

        assertThat(client.send(request, HttpResponse.BodyHandlers.discarding()).statusCode()).isEqualTo(200);
    }
}
