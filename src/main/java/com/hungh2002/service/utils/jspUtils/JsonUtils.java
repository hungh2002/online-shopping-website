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
        List<T> data = new ArrayList<>();

        Gson gson = new GsonBuilder().registerTypeAdapter(Timestamp.class, new TimeStampAdapter())
                .create();

        String response = null;

        try {
            response = Fetch.get(url);

            TypeToken<List<T>> collectionType = new TypeToken<List<T>>() {};
            data = gson.fromJson(response, collectionType);

        } catch (Exception e) {
            System.out.println("ERROR: JsonUtils --> Serialization(): " + e);
        }
        return data;
    }
}

