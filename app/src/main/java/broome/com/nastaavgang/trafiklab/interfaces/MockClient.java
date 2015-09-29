package broome.com.nastaavgang.trafiklab.interfaces;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.util.Collections;

import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

/**
 * Created by robin on 16/08/15.
 */
public class MockClient implements Client {

    @Override
    public Response execute(Request request) throws IOException {
        Uri uri = Uri.parse(request.getUrl());

        Log.d("MOCK SERVER", "fetching uri: " + uri.toString());

        String responseString = "";

        if(uri.getPath().contains("GetDepartures.json")) {
            responseString = DEPARTURE_STRING;
        } else {
            responseString = NEARBY_JSON;
            responseString = REAL_RES;
        }


        return new Response(request.getUrl(), 200, "nothing", Collections.EMPTY_LIST, new TypedByteArray("application/json", responseString.getBytes()));
    }

    private static String NEARBY_JSON = "{  \n" +
            "  \"stationsinzoneresult\": {  \n" +
            "    \"location\": [  \n" +
            "      {\n" +
            "        \"@id\": \"7420483\",  \n" +
            "        \"@x\": \"1271567\",  \n" +
            "        \"@y\": \"6404850\",  \n" +
            "        \"name\": \"Göteborg Nils Ericsonterminal\",  \n" +
            "        \"municipality\": {  \n" +
            "          \"@id\": \"80\",  \n" +
            "          \"@county_id\": \"14\",  \n" +
            "          \"#text\": \"Göteborg\"  \n" +
            "        },  \n" +
            "        \"transportlist\": {  \n" +
            "          \"transport\": [  \n" +
            "            {\n" +
            "              \"@type\": \"BLT\",  \n" +
            "              \"@displaytype\": \"B\"  \n" +
            "            }\n" +
            "          ]\n" +
            "        },  \n" +
            "        \"producerlist\": {  \n" +
            "          \"producer\": [  \n" +
            "            {\n" +
            "              \"@id\": \"277\"  \n" +
            "            }  \n" +
            "          ]\n" +
            "        }  \n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

    private String DEPARTURE_STRING = "{  \n" +
            "  \"getdeparturesresult\": {  \n" +
            "    \"departuresegment\": [  \n" +
            "      {\n" +
            "        \"departure\": {  \n" +
            "          \"location\": {  \n" +
            "            \"@id\": \"7400001\",  \n" +
            "            \"@x\": \"1628235\",  \n" +
            "            \"@y\": \"6580982\",  \n" +
            "            \"name\": \"Stockholm Centralstation\"  \n" +
            "          },  \n" +
            "          \"datetime\": \"2015-02-10 10:01\"  \n" +
            "        },  \n" +
            "        \"direction\": \"Märsta station\",  \n" +
            "        \"segmentid\": {  \n" +
            "          \"mot\": {  \n" +
            "            \"@displaytype\": \"J\",  \n" +
            "            \"@type\": \"JLT\",  \n" +
            "            \"#text\": \"Tåg\"  \n" +
            "          },  \n" +
            "          \"carrier\": {  \n" +
            "            \"name\": \"SL\",  \n" +
            "            \"url\": \"http://www.sl.se/\",  \n" +
            "            \"id\": \"275\",  \n" +
            "            \"number\": \"2620\"  \n" +
            "          }\n" +
            "        }  \n" +
            "      },  \n" +
            "      {\n" +
            "        \"departure\": {  \n" +
            "          \"location\": {  \n" +
            "            \"@id\": \"7400001\",  \n" +
            "            \"@x\": \"1628235\",  \n" +
            "            \"@y\": \"6580982\",  \n" +
            "            \"name\": \"Stockholm Centralstation\"  \n" +
            "          },  \n" +
            "          \"datetime\": \"2015-02-10 10:04\"  \n" +
            "        },  \n" +
            "        \"direction\": \"Nynäshamn station\",  \n" +
            "        \"segmentid\": {  \n" +
            "          \"mot\": {  \n" +
            "            \"@displaytype\": \"J\",  \n" +
            "            \"@type\": \"JLT\",  \n" +
            "            \"#text\": \"Tåg\"  \n" +
            "          },  \n" +
            "          \"carrier\": {  \n" +
            "            \"name\": \"SL\",  \n" +
            "            \"url\": \"http://www.sl.se/\",  \n" +
            "            \"id\": \"275\",  \n" +
            "            \"number\": \"2821\"  \n" +
            "          }\n" +
            "        }  \n" +
            "      }\n" +
            "    ]\n" +
            "  }  \n" +
            "}";

        private static String REAL_RES = "{\n" +
                "  \"stationsinzoneresult\": {\n" +
                "    \"location\": [\n" +
                "      {\n" +
                "        \"@id\": \"7420483\",\n" +
                "        \"@x\": \"1271567\",\n" +
                "        \"@y\": \"6404850\",\n" +
                "        \"name\": \"Göteborg Nils Ericsonterminal\",\n" +
                "        \"municipality\": {\n" +
                "          \"@id\": \"80\",\n" +
                "          \"@county_id\": \"14\",\n" +
                "          \"#text\": \"Göteborg\"\n" +
                "        },\n" +
                "        \"transportlist\": {\n" +
                "          \"transport\": [\n" +
                "            {\n" +
                "              \"@type\": \"BLT\",\n" +
                "              \"@displaytype\": \"B\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"@type\": \"BXBN\",\n" +
                "              \"@displaytype\": \"B\"\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        \"producerlist\": {\n" +
                "          \"producer\": [\n" +
                "            {\n" +
                "              \"@id\": \"277\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"@id\": \"279\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"@id\": \"327\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"@id\": \"328\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"@id\": \"644\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"@id\": \"690\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"@id\": \"7420483\",\n" +
                "        \"@x\": \"1271567\",\n" +
                "        \"@y\": \"6404850\",\n" +
                "        \"name\": \"Göteborg Nils Ericsonterminal\",\n" +
                "        \"municipality\": {\n" +
                "          \"@id\": \"80\",\n" +
                "          \"@county_id\": \"14\",\n" +
                "          \"#text\": \"Göteborg\"\n" +
                "        },\n" +
                "        \"transportlist\": {\n" +
                "          \"transport\": [\n" +
                "            {\n" +
                "              \"@type\": \"BLT\",\n" +
                "              \"@displaytype\": \"B\"\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        \"producerlist\": {\n" +
                "          \"producer\": {\n" +
                "            \"@id\": \"277\"\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

}
