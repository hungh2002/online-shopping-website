package com.hungh2002.service.utils.jspUtils;

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
 * JsonSerialization
 */
public class JsonUtils {
    public static <T> List<T> Serialization(String url) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Timestamp.class, new TimeStampAdapter())
                .create();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        String response = "";
        List<T> data = new ArrayList<>();

        try {
            response = client.send(request, BodyHandlers.ofString()).body();

            TypeToken<List<T>> collectionType = new TypeToken<List<T>>() {};
            data = gson.fromJson(response, collectionType);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("ERROR: JsonUtils --> Serialization: " + e);
        }
        return data;
    }
}

