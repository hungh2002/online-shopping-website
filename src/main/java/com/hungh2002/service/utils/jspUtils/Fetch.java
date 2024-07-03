package com.hungh2002.service.utils.jspUtils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

/**
 * HttpClient
 */
public class Fetch {
    public static void post() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

    }
}