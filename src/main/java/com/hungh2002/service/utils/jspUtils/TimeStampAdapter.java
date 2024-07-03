package com.hungh2002.service.utils.jspUtils;

import java.io.IOException;
import java.sql.Timestamp;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class TimeStampAdapter extends TypeAdapter<Timestamp> {

    @Override
    public void write(JsonWriter out, Timestamp value) throws IOException {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'write'");
    }

    @Override
    public Timestamp read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }

        return Timestamp.valueOf(in.nextString());
    }

}
