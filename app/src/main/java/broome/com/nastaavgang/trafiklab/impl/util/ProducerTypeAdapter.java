package broome.com.nastaavgang.trafiklab.impl.util;

import broome.com.nastaavgang.trafiklab.impl.model.stations.Producer;
import broome.com.nastaavgang.trafiklab.impl.model.stations.Producerlist;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by robin on 30/08/15.
 */
public class ProducerTypeAdapter extends TypeAdapter<Producerlist> {

    private Gson gson = new Gson();

    @Override
    public void write(JsonWriter jsonWriter, Producerlist locations) throws IOException {
        gson.toJson(locations, Producerlist.class, jsonWriter);
    }

    @Override
    public Producerlist read(JsonReader jsonReader) throws IOException {
        Producerlist producerlist;

        jsonReader.beginObject();
        jsonReader.nextName();
        if (jsonReader.peek().equals(com.google.gson.stream.JsonToken.BEGIN_ARRAY)) {
            producerlist = new Producerlist((Producer[]) gson.fromJson(jsonReader, Producer[].class));
        } else if(jsonReader.peek().equals(com.google.gson.stream.JsonToken.BEGIN_OBJECT)) {
            producerlist = new Producerlist((Producer) gson.fromJson(jsonReader, Producer.class));
        } else {
            throw new JsonParseException("Unexpected token " + jsonReader.peek());
        }

        jsonReader.endObject();
        return producerlist;
    }
}
