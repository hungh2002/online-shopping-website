package com.hungh2002.service.utils.jspUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * HttpClient
 */
public class Fetch {
    public static void post(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.noBody()).build();

        try {
            client.send(request, BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("jspUtils --> Fetch: " + e);

    }
}
