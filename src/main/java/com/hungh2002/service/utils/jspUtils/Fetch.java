package com.hungh2002.service.utils.jspUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * HttpClient
 */
public class Fetch {
    public static String get(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        String response = null;

        try {
            response = client.send(request, BodyHandlers.ofString()).body();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("jspUtils --> Fetch --> get() : " + e);
        }
        return response;
    }


    public static void post(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.noBody()).build();

        try {
            client.send(request, BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("jspUtils --> Fetch --> post() : " + e);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
