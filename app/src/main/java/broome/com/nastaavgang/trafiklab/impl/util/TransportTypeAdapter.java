package broome.com.nastaavgang.trafiklab.impl.util;

import broome.com.nastaavgang.trafiklab.impl.model.stations.Transport;
import broome.com.nastaavgang.trafiklab.impl.model.stations.Transportlist;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by robin on 30/08/15.
 */
public class TransportTypeAdapter extends TypeAdapter<Transportlist> {

    private Gson gson = new Gson();

    @Override
    public void write(JsonWriter jsonWriter, Transportlist locations) throws IOException {
        gson.toJson(locations, Transportlist.class, jsonWriter);
    }

    @Override
    public Transportlist read(JsonReader jsonReader) throws IOException {
        Transportlist transportlist;

        jsonReader.beginObject();
        jsonReader.nextName();
        if (jsonReader.peek().equals(com.google.gson.stream.JsonToken.BEGIN_ARRAY)) {
            transportlist = new Transportlist((Transport[]) gson.fromJson(jsonReader, Transport[].class));
        } else if(jsonReader.peek().equals(com.google.gson.stream.JsonToken.BEGIN_OBJECT)) {
            transportlist = new Transportlist((Transport) gson.fromJson(jsonReader, Transport.class));
        } else {
            throw new JsonParseException("Unexpected token " + jsonReader.peek());
        }

        jsonReader.endObject();
        return transportlist;
    }
}
