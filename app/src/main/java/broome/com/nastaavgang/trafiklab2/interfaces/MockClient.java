package broome.com.nastaavgang.trafiklab2.interfaces;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.util.Collections;

import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

/**
 * Mock API for trafiklabs API
 * Created by robin on 16/08/15.
 */
public class MockClient implements Client {

    @Override
    public Response execute(Request request) throws IOException {
        Uri uri = Uri.parse(request.getUrl());

        Log.d("MOCK SERVER", "fetching uri: " + uri.toString());

        String responseString;

        if(uri.getPath().contains("arrivalBoard")) {
            responseString = ARRIVAL_NEW;
        }else if(uri.getPath().contains("departureBoard")){
            responseString = DEPARTURE_NEW;
        }
        else {
            responseString = NEARBY_NEW;
        }


        return new Response(request.getUrl(), 200, "nothing", Collections.EMPTY_LIST, new TypedByteArray("application/json", responseString.getBytes()));
    }


    private String DEPARTURE_NEW = "{\n" +
            "  \"Departure\": [\n" +
            "    {\n" +
            "      \"Product\": {\n" +
            "        \"name\": \"LÃ¤nstrafik - Buss 19\",\n" +
            "        \"num\": \"19\",\n" +
            "        \"catCode\": \"7\",\n" +
            "        \"catOutS\": \"BLT\",\n" +
            "        \"catOutL\": \"LÃ¤nstrafik - Buss\",\n" +
            "        \"operatorCode\": \"279\",\n" +
            "        \"operator\": \"VÃ¤sttrafik\",\n" +
            "        \"operatorUrl\": \"http://www.vasttrafik.se\"\n" +
            "      },\n" +
            "      \"Stops\": {\n" +
            "        \"Stop\": [\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "            \"id\": \"740025701\",\n" +
            "            \"extId\": \"740025701\",\n" +
            "            \"routeIdx\": 13,\n" +
            "            \"lon\": 11.969775,\n" +
            "            \"lat\": 57.699124,\n" +
            "            \"depTime\": \"13:40:00\",\n" +
            "            \"depDate\": \"2016-10-29\",\n" +
            "            \"rtDepTime\": \"13:42:00\",\n" +
            "            \"rtDepDate\": \"2016-10-29\",\n" +
            "            \"rtDepTrack\": \"D\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Kapellplatsen\",\n" +
            "            \"id\": \"740025643\",\n" +
            "            \"extId\": \"740025643\",\n" +
            "            \"routeIdx\": 14,\n" +
            "            \"lon\": 11.973308,\n" +
            "            \"lat\": 57.693659,\n" +
            "            \"arrTime\": \"13:42:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Ã\u0085landsgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059683\",\n" +
            "            \"extId\": \"740059683\",\n" +
            "            \"routeIdx\": 15,\n" +
            "            \"lon\": 11.977731,\n" +
            "            \"lat\": 57.69222,\n" +
            "            \"arrTime\": \"13:43:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Chalmers TvÃ¤rgata (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059169\",\n" +
            "            \"extId\": \"740059169\",\n" +
            "            \"routeIdx\": 16,\n" +
            "            \"lon\": 11.980338,\n" +
            "            \"lat\": 57.689721,\n" +
            "            \"arrTime\": \"13:44:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Engdahlsgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059196\",\n" +
            "            \"extId\": \"740059196\",\n" +
            "            \"routeIdx\": 17,\n" +
            "            \"lon\": 11.983097,\n" +
            "            \"lat\": 57.686665,\n" +
            "            \"arrTime\": \"13:46:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"PilbÃ¥gsgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059492\",\n" +
            "            \"extId\": \"740059492\",\n" +
            "            \"routeIdx\": 18,\n" +
            "            \"lon\": 11.984652,\n" +
            "            \"lat\": 57.684508,\n" +
            "            \"arrTime\": \"13:48:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"FramnÃ¤sgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059218\",\n" +
            "            \"extId\": \"740059218\",\n" +
            "            \"routeIdx\": 19,\n" +
            "            \"lon\": 11.987475,\n" +
            "            \"lat\": 57.682557,\n" +
            "            \"arrTime\": \"13:48:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"BjÃ¶rkuddsgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059134\",\n" +
            "            \"extId\": \"740059134\",\n" +
            "            \"routeIdx\": 20,\n" +
            "            \"lon\": 11.990684,\n" +
            "            \"lat\": 57.679635,\n" +
            "            \"arrTime\": \"13:50:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"SÃ¶rgÃ¥rdsskolan (MÃ¶lndal kn)\",\n" +
            "            \"id\": \"740059788\",\n" +
            "            \"extId\": \"740059788\",\n" +
            "            \"routeIdx\": 21,\n" +
            "            \"lon\": 11.994199,\n" +
            "            \"lat\": 57.677586,\n" +
            "            \"arrTime\": \"13:53:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"name\": \"LÃ¤nstrafik - Buss 19\",\n" +
            "      \"type\": \"S\",\n" +
            "      \"stop\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "      \"stopid\": \"740025701\",\n" +
            "      \"stopExtId\": \"740025701\",\n" +
            "      \"time\": \"13:40:00\",\n" +
            "      \"date\": \"2016-10-29\",\n" +
            "      \"rtTime\": \"13:42:00\",\n" +
            "      \"rtDate\": \"2016-10-29\",\n" +
            "      \"rtTrack\": \"D\",\n" +
            "      \"direction\": \"SÃ¶rgÃ¥rdsskolan (MÃ¶lndal kn)\",\n" +
            "      \"transportNumber\": \"19\",\n" +
            "      \"transportCategory\": \"BLT\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Product\": {\n" +
            "        \"name\": \"LÃ¤nstrafik - SpÃ¥rvÃ¤g 10\",\n" +
            "        \"num\": \"10\",\n" +
            "        \"catCode\": \"6\",\n" +
            "        \"catOutS\": \"SLT\",\n" +
            "        \"catOutL\": \"LÃ¤nstrafik - SpÃ¥rvÃ¤g\",\n" +
            "        \"operatorCode\": \"279\",\n" +
            "        \"operator\": \"VÃ¤sttrafik\",\n" +
            "        \"operatorUrl\": \"http://www.vasttrafik.se\"\n" +
            "      },\n" +
            "      \"Stops\": {\n" +
            "        \"Stop\": [\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "            \"id\": \"740025701\",\n" +
            "            \"extId\": \"740025701\",\n" +
            "            \"routeIdx\": 5,\n" +
            "            \"lon\": 11.969775,\n" +
            "            \"lat\": 57.699124,\n" +
            "            \"depTime\": \"13:41:00\",\n" +
            "            \"depDate\": \"2016-10-29\",\n" +
            "            \"rtDepTime\": \"13:42:00\",\n" +
            "            \"rtDepDate\": \"2016-10-29\",\n" +
            "            \"rtDepTrack\": \"A\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Valand\",\n" +
            "            \"id\": \"740025698\",\n" +
            "            \"extId\": \"740025698\",\n" +
            "            \"routeIdx\": 6,\n" +
            "            \"lon\": 11.974522,\n" +
            "            \"lat\": 57.700338,\n" +
            "            \"arrTime\": \"13:42:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Kungsportsplatsen\",\n" +
            "            \"id\": \"740016358\",\n" +
            "            \"extId\": \"740016358\",\n" +
            "            \"routeIdx\": 7,\n" +
            "            \"lon\": 11.969748,\n" +
            "            \"lat\": 57.704023,\n" +
            "            \"arrTime\": \"13:44:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Brunnsparken\",\n" +
            "            \"id\": \"740020752\",\n" +
            "            \"extId\": \"740020752\",\n" +
            "            \"routeIdx\": 8,\n" +
            "            \"lon\": 11.967843,\n" +
            "            \"lat\": 57.706945,\n" +
            "            \"arrTime\": \"13:46:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Lilla Bommen\",\n" +
            "            \"id\": \"740016360\",\n" +
            "            \"extId\": \"740016360\",\n" +
            "            \"routeIdx\": 9,\n" +
            "            \"lon\": 11.966036,\n" +
            "            \"lat\": 57.709552,\n" +
            "            \"arrTime\": \"13:46:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Frihamnsviadukten\",\n" +
            "            \"id\": \"740025026\",\n" +
            "            \"extId\": \"740025026\",\n" +
            "            \"routeIdx\": 10,\n" +
            "            \"lon\": 11.96004,\n" +
            "            \"lat\": 57.720312,\n" +
            "            \"arrTime\": \"13:50:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Hjalmar Brantingspl\",\n" +
            "            \"id\": \"740015569\",\n" +
            "            \"extId\": \"740015569\",\n" +
            "            \"routeIdx\": 11,\n" +
            "            \"lon\": 11.953676,\n" +
            "            \"lat\": 57.720833,\n" +
            "            \"arrTime\": \"13:51:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg VÃ¥gmÃ¤stareplatsen\",\n" +
            "            \"id\": \"740025706\",\n" +
            "            \"extId\": \"740025706\",\n" +
            "            \"routeIdx\": 12,\n" +
            "            \"lon\": 11.945037,\n" +
            "            \"lat\": 57.720671,\n" +
            "            \"arrTime\": \"13:52:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Wieselgrensplatsen\",\n" +
            "            \"id\": \"740025705\",\n" +
            "            \"extId\": \"740025705\",\n" +
            "            \"routeIdx\": 13,\n" +
            "            \"lon\": 11.935068,\n" +
            "            \"lat\": 57.720806,\n" +
            "            \"arrTime\": \"13:54:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Rambergsvallen\",\n" +
            "            \"id\": \"740025672\",\n" +
            "            \"extId\": \"740025672\",\n" +
            "            \"routeIdx\": 14,\n" +
            "            \"lon\": 11.927526,\n" +
            "            \"lat\": 57.719485,\n" +
            "            \"arrTime\": \"13:55:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg GropegÃ¥rdsgatan\",\n" +
            "            \"id\": \"740025633\",\n" +
            "            \"extId\": \"740025633\",\n" +
            "            \"routeIdx\": 15,\n" +
            "            \"lon\": 11.918438,\n" +
            "            \"lat\": 57.718235,\n" +
            "            \"arrTime\": \"13:57:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg EketrÃ¤gatan\",\n" +
            "            \"id\": \"740025624\",\n" +
            "            \"extId\": \"740025624\",\n" +
            "            \"routeIdx\": 16,\n" +
            "            \"lon\": 11.910285,\n" +
            "            \"lat\": 57.716275,\n" +
            "            \"arrTime\": \"13:58:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg SÃ¤lÃ¶fjordsgatan\",\n" +
            "            \"id\": \"740025690\",\n" +
            "            \"extId\": \"740025690\",\n" +
            "            \"routeIdx\": 17,\n" +
            "            \"lon\": 11.902086,\n" +
            "            \"lat\": 57.713696,\n" +
            "            \"arrTime\": \"14:00:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg VÃ¥rvÃ¤derstorget\",\n" +
            "            \"id\": \"740025707\",\n" +
            "            \"extId\": \"740025707\",\n" +
            "            \"routeIdx\": 18,\n" +
            "            \"lon\": 11.893223,\n" +
            "            \"lat\": 57.713048,\n" +
            "            \"arrTime\": \"14:01:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg MildvÃ¤dersgatan\",\n" +
            "            \"id\": \"740025660\",\n" +
            "            \"extId\": \"740025660\",\n" +
            "            \"routeIdx\": 19,\n" +
            "            \"lon\": 11.890958,\n" +
            "            \"lat\": 57.715628,\n" +
            "            \"arrTime\": \"14:02:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Ã\u0096nskevÃ¤dersgatan\",\n" +
            "            \"id\": \"740025710\",\n" +
            "            \"extId\": \"740025710\",\n" +
            "            \"routeIdx\": 20,\n" +
            "            \"lon\": 11.893888,\n" +
            "            \"lat\": 57.719943,\n" +
            "            \"arrTime\": \"14:03:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg FriskvÃ¤derstorget\",\n" +
            "            \"id\": \"740025628\",\n" +
            "            \"extId\": \"740025628\",\n" +
            "            \"routeIdx\": 21,\n" +
            "            \"lon\": 11.893403,\n" +
            "            \"lat\": 57.723512,\n" +
            "            \"arrTime\": \"14:04:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg VÃ¤derilsgatan\",\n" +
            "            \"id\": \"740025708\",\n" +
            "            \"extId\": \"740025708\",\n" +
            "            \"routeIdx\": 22,\n" +
            "            \"lon\": 11.893367,\n" +
            "            \"lat\": 57.726892,\n" +
            "            \"arrTime\": \"14:05:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"name\": \"LÃ¤nstrafik - SpÃ¥rvÃ¤g 10\",\n" +
            "      \"type\": \"S\",\n" +
            "      \"stop\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "      \"stopid\": \"740025701\",\n" +
            "      \"stopExtId\": \"740025701\",\n" +
            "      \"time\": \"13:41:00\",\n" +
            "      \"date\": \"2016-10-29\",\n" +
            "      \"rtTime\": \"13:42:00\",\n" +
            "      \"rtDate\": \"2016-10-29\",\n" +
            "      \"rtTrack\": \"A\",\n" +
            "      \"direction\": \"GÃ¶teborg VÃ¤derilsgatan\",\n" +
            "      \"transportNumber\": \"10\",\n" +
            "      \"transportCategory\": \"SLT\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Product\": {\n" +
            "        \"name\": \"LÃ¤nstrafik - Buss 19\",\n" +
            "        \"num\": \"19\",\n" +
            "        \"catCode\": \"7\",\n" +
            "        \"catOutS\": \"BLT\",\n" +
            "        \"catOutL\": \"LÃ¤nstrafik - Buss\",\n" +
            "        \"operatorCode\": \"279\",\n" +
            "        \"operator\": \"VÃ¤sttrafik\",\n" +
            "        \"operatorUrl\": \"http://www.vasttrafik.se\"\n" +
            "      },\n" +
            "      \"Stops\": {\n" +
            "        \"Stop\": [\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "            \"id\": \"740025701\",\n" +
            "            \"extId\": \"740025701\",\n" +
            "            \"routeIdx\": 8,\n" +
            "            \"lon\": 11.969775,\n" +
            "            \"lat\": 57.699124,\n" +
            "            \"depTime\": \"13:41:00\",\n" +
            "            \"depDate\": \"2016-10-29\",\n" +
            "            \"rtDepTime\": \"13:43:00\",\n" +
            "            \"rtDepDate\": \"2016-10-29\",\n" +
            "            \"rtDepTrack\": \"C\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg GrÃ¶nsakstorget\",\n" +
            "            \"id\": \"740015567\",\n" +
            "            \"extId\": \"740015567\",\n" +
            "            \"routeIdx\": 9,\n" +
            "            \"lon\": 11.964436,\n" +
            "            \"lat\": 57.702495,\n" +
            "            \"arrTime\": \"13:42:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Domkyrkan\",\n" +
            "            \"id\": \"740025621\",\n" +
            "            \"extId\": \"740025621\",\n" +
            "            \"routeIdx\": 10,\n" +
            "            \"lon\": 11.963708,\n" +
            "            \"lat\": 57.704293,\n" +
            "            \"arrTime\": \"13:43:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Brunnsparken\",\n" +
            "            \"id\": \"740020752\",\n" +
            "            \"extId\": \"740020752\",\n" +
            "            \"routeIdx\": 11,\n" +
            "            \"lon\": 11.967843,\n" +
            "            \"lat\": 57.706945,\n" +
            "            \"arrTime\": \"13:47:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Lilla Bommen\",\n" +
            "            \"id\": \"740016360\",\n" +
            "            \"extId\": \"740016360\",\n" +
            "            \"routeIdx\": 12,\n" +
            "            \"lon\": 11.966036,\n" +
            "            \"lat\": 57.709552,\n" +
            "            \"arrTime\": \"13:47:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Hjalmar Brantingspl\",\n" +
            "            \"id\": \"740015569\",\n" +
            "            \"extId\": \"740015569\",\n" +
            "            \"routeIdx\": 13,\n" +
            "            \"lon\": 11.953676,\n" +
            "            \"lat\": 57.720833,\n" +
            "            \"arrTime\": \"13:53:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Brunnsbotorget\",\n" +
            "            \"id\": \"740059149\",\n" +
            "            \"extId\": \"740059149\",\n" +
            "            \"routeIdx\": 14,\n" +
            "            \"lon\": 11.970521,\n" +
            "            \"lat\": 57.727476,\n" +
            "            \"arrTime\": \"13:56:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Balladgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059104\",\n" +
            "            \"extId\": \"740059104\",\n" +
            "            \"routeIdx\": 15,\n" +
            "            \"lon\": 11.975843,\n" +
            "            \"lat\": 57.731611,\n" +
            "            \"arrTime\": \"13:57:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"BjÃ¶rkrisvÃ¤gen (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059133\",\n" +
            "            \"extId\": \"740059133\",\n" +
            "            \"routeIdx\": 16,\n" +
            "            \"lon\": 11.973731,\n" +
            "            \"lat\": 57.739009,\n" +
            "            \"arrTime\": \"13:59:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Backa Kyrkogata (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059099\",\n" +
            "            \"extId\": \"740059099\",\n" +
            "            \"routeIdx\": 17,\n" +
            "            \"lon\": 11.974755,\n" +
            "            \"lat\": 57.743153,\n" +
            "            \"arrTime\": \"14:00:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"SÃ¤gengatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059621\",\n" +
            "            \"extId\": \"740059621\",\n" +
            "            \"routeIdx\": 18,\n" +
            "            \"lon\": 11.977434,\n" +
            "            \"lat\": 57.745949,\n" +
            "            \"arrTime\": \"14:01:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Selma LagerlÃ¶fs Torg (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059539\",\n" +
            "            \"extId\": \"740059539\",\n" +
            "            \"routeIdx\": 19,\n" +
            "            \"lon\": 11.981335,\n" +
            "            \"lat\": 57.750857,\n" +
            "            \"arrTime\": \"14:02:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Akkas Gata (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740037346\",\n" +
            "            \"extId\": \"740037346\",\n" +
            "            \"routeIdx\": 20,\n" +
            "            \"lon\": 11.980697,\n" +
            "            \"lat\": 57.754228,\n" +
            "            \"arrTime\": \"14:03:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"KÃ¶rkarlens gata (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059388\",\n" +
            "            \"extId\": \"740059388\",\n" +
            "            \"routeIdx\": 21,\n" +
            "            \"lon\": 11.987772,\n" +
            "            \"lat\": 57.757761,\n" +
            "            \"arrTime\": \"14:06:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"name\": \"LÃ¤nstrafik - Buss 19\",\n" +
            "      \"type\": \"S\",\n" +
            "      \"stop\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "      \"stopid\": \"740025701\",\n" +
            "      \"stopExtId\": \"740025701\",\n" +
            "      \"time\": \"13:41:00\",\n" +
            "      \"date\": \"2016-10-29\",\n" +
            "      \"rtTime\": \"13:43:00\",\n" +
            "      \"rtDate\": \"2016-10-29\",\n" +
            "      \"rtTrack\": \"C\",\n" +
            "      \"direction\": \"KÃ¶rkarlens gata (GÃ¶teborg kn)\",\n" +
            "      \"transportNumber\": \"19\",\n" +
            "      \"transportCategory\": \"BLT\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Product\": {\n" +
            "        \"name\": \"LÃ¤nstrafik - SpÃ¥rvÃ¤g 7\",\n" +
            "        \"num\": \"7\",\n" +
            "        \"catCode\": \"6\",\n" +
            "        \"catOutS\": \"SLT\",\n" +
            "        \"catOutL\": \"LÃ¤nstrafik - SpÃ¥rvÃ¤g\",\n" +
            "        \"operatorCode\": \"279\",\n" +
            "        \"operator\": \"VÃ¤sttrafik\",\n" +
            "        \"operatorUrl\": \"http://www.vasttrafik.se\"\n" +
            "      },\n" +
            "      \"Stops\": {\n" +
            "        \"Stop\": [\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "            \"id\": \"740025701\",\n" +
            "            \"extId\": \"740025701\",\n" +
            "            \"routeIdx\": 4,\n" +
            "            \"lon\": 11.969775,\n" +
            "            \"lat\": 57.699124,\n" +
            "            \"depTime\": \"13:42:00\",\n" +
            "            \"depDate\": \"2016-10-29\",\n" +
            "            \"rtDepTime\": \"13:42:00\",\n" +
            "            \"rtDepDate\": \"2016-10-29\",\n" +
            "            \"rtDepTrack\": \"B\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Kapellplatsen\",\n" +
            "            \"id\": \"740025643\",\n" +
            "            \"extId\": \"740025643\",\n" +
            "            \"routeIdx\": 5,\n" +
            "            \"lon\": 11.973308,\n" +
            "            \"lat\": 57.693659,\n" +
            "            \"arrTime\": \"13:44:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Chalmers\",\n" +
            "            \"id\": \"740025617\",\n" +
            "            \"extId\": \"740025617\",\n" +
            "            \"routeIdx\": 6,\n" +
            "            \"lon\": 11.97293,\n" +
            "            \"lat\": 57.689955,\n" +
            "            \"arrTime\": \"13:45:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Wavrinskys plats\",\n" +
            "            \"id\": \"740025703\",\n" +
            "            \"extId\": \"740025703\",\n" +
            "            \"routeIdx\": 7,\n" +
            "            \"lon\": 11.968607,\n" +
            "            \"lat\": 57.68893,\n" +
            "            \"arrTime\": \"13:46:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Medicinaregatan\",\n" +
            "            \"id\": \"740025659\",\n" +
            "            \"extId\": \"740025659\",\n" +
            "            \"routeIdx\": 8,\n" +
            "            \"lon\": 11.964346,\n" +
            "            \"lat\": 57.685442,\n" +
            "            \"arrTime\": \"13:48:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Sahlgrenska Huvudentr\",\n" +
            "            \"id\": \"740015591\",\n" +
            "            \"extId\": \"740015591\",\n" +
            "            \"routeIdx\": 9,\n" +
            "            \"lon\": 11.960831,\n" +
            "            \"lat\": 57.683627,\n" +
            "            \"arrTime\": \"13:49:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Botaniska TrÃ¤dgÃ¥rden\",\n" +
            "            \"id\": \"740025689\",\n" +
            "            \"extId\": \"740025689\",\n" +
            "            \"routeIdx\": 10,\n" +
            "            \"lon\": 11.945792,\n" +
            "            \"lat\": 57.68102,\n" +
            "            \"arrTime\": \"13:52:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Marklandsgatan\",\n" +
            "            \"id\": \"740025657\",\n" +
            "            \"extId\": \"740025657\",\n" +
            "            \"routeIdx\": 11,\n" +
            "            \"lon\": 11.936039,\n" +
            "            \"lat\": 57.674404,\n" +
            "            \"arrTime\": \"13:54:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Axel DahlstrÃ¶ms torg\",\n" +
            "            \"id\": \"740025608\",\n" +
            "            \"extId\": \"740025608\",\n" +
            "            \"routeIdx\": 12,\n" +
            "            \"lon\": 11.927445,\n" +
            "            \"lat\": 57.672435,\n" +
            "            \"arrTime\": \"13:55:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Lantmilsgatan\",\n" +
            "            \"id\": \"740025652\",\n" +
            "            \"extId\": \"740025652\",\n" +
            "            \"routeIdx\": 13,\n" +
            "            \"lon\": 11.924649,\n" +
            "            \"lat\": 57.667185,\n" +
            "            \"arrTime\": \"13:57:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Nymilsgatan\",\n" +
            "            \"id\": \"740025664\",\n" +
            "            \"extId\": \"740025664\",\n" +
            "            \"routeIdx\": 14,\n" +
            "            \"lon\": 11.924443,\n" +
            "            \"lat\": 57.662745,\n" +
            "            \"arrTime\": \"13:58:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"FrÃ¶lunda MusikvÃ¤gen (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740025662\",\n" +
            "            \"extId\": \"740025662\",\n" +
            "            \"routeIdx\": 15,\n" +
            "            \"lon\": 11.920964,\n" +
            "            \"lat\": 57.659176,\n" +
            "            \"arrTime\": \"13:59:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"FrÃ¶lunda Positivgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740020480\",\n" +
            "            \"extId\": \"740020480\",\n" +
            "            \"routeIdx\": 16,\n" +
            "            \"lon\": 11.917719,\n" +
            "            \"lat\": 57.656722,\n" +
            "            \"arrTime\": \"14:00:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"FrÃ¶lunda Torg (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740015565\",\n" +
            "            \"extId\": \"740015565\",\n" +
            "            \"routeIdx\": 17,\n" +
            "            \"lon\": 11.90979,\n" +
            "            \"lat\": 57.652209,\n" +
            "            \"arrTime\": \"14:02:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Tynnered Briljantgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740025613\",\n" +
            "            \"extId\": \"740025613\",\n" +
            "            \"routeIdx\": 18,\n" +
            "            \"lon\": 11.903219,\n" +
            "            \"lat\": 57.648596,\n" +
            "            \"arrTime\": \"14:04:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Tynnered Smaragdgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740025684\",\n" +
            "            \"extId\": \"740025684\",\n" +
            "            \"routeIdx\": 19,\n" +
            "            \"lon\": 11.899246,\n" +
            "            \"lat\": 57.645333,\n" +
            "            \"arrTime\": \"14:05:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Tynnered Opaltorget (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740025668\",\n" +
            "            \"extId\": \"740025668\",\n" +
            "            \"routeIdx\": 20,\n" +
            "            \"lon\": 11.900846,\n" +
            "            \"lat\": 57.641665,\n" +
            "            \"arrTime\": \"14:06:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"name\": \"LÃ¤nstrafik - Buss 19\",\n" +
            "      \"type\": \"S\",\n" +
            "      \"stop\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "      \"stopid\": \"740025701\",\n" +
            "      \"stopExtId\": \"740025701\",\n" +
            "      \"time\": \"13:41:00\",\n" +
            "      \"date\": \"2016-10-29\",\n" +
            "      \"rtTime\": \"13:43:00\",\n" +
            "      \"rtDate\": \"2016-10-29\",\n" +
            "      \"rtTrack\": \"C\",\n" +
            "      \"direction\": \"KÃ¶rkarlens gata (GÃ¶teborg kn)\",\n" +
            "      \"transportNumber\": \"19\",\n" +
            "      \"transportCategory\": \"BLT\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    private String ARRIVAL_NEW = "{\n" +
            "  \"Arrival\": [\n" +
            "    {\n" +
            "      \"Product\": {\n" +
            "        \"name\": \"LÃ¤nstrafik - SpÃ¥rvÃ¤g 10\",\n" +
            "        \"num\": \"10\",\n" +
            "        \"catCode\": \"6\",\n" +
            "        \"catOutS\": \"SLT\",\n" +
            "        \"catOutL\": \"LÃ¤nstrafik - SpÃ¥rvÃ¤g\",\n" +
            "        \"operatorCode\": \"279\",\n" +
            "        \"operator\": \"VÃ¤sttrafik\",\n" +
            "        \"operatorUrl\": \"http://www.vasttrafik.se\"\n" +
            "      },\n" +
            "      \"Stops\": {\n" +
            "        \"Stop\": [\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Doktor Sydows gata\",\n" +
            "            \"id\": \"740025620\",\n" +
            "            \"extId\": \"740025620\",\n" +
            "            \"routeIdx\": 0,\n" +
            "            \"lon\": 11975394,\n" +
            "            \"lat\": 57680795,\n" +
            "            \"depTime\": \"13:34:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Doktor Fries Torg\",\n" +
            "            \"id\": \"740025619\",\n" +
            "            \"extId\": \"740025619\",\n" +
            "            \"routeIdx\": 1,\n" +
            "            \"lon\": 11973065,\n" +
            "            \"lat\": 57684238,\n" +
            "            \"depTime\": \"13:35:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Wavrinskys plats\",\n" +
            "            \"id\": \"740025703\",\n" +
            "            \"extId\": \"740025703\",\n" +
            "            \"routeIdx\": 2,\n" +
            "            \"lon\": 11968607,\n" +
            "            \"lat\": 57688930,\n" +
            "            \"depTime\": \"13:36:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Chalmers\",\n" +
            "            \"id\": \"740025617\",\n" +
            "            \"extId\": \"740025617\",\n" +
            "            \"routeIdx\": 3,\n" +
            "            \"lon\": 11972930,\n" +
            "            \"lat\": 57689955,\n" +
            "            \"depTime\": \"13:37:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Kapellplatsen\",\n" +
            "            \"id\": \"740025643\",\n" +
            "            \"extId\": \"740025643\",\n" +
            "            \"routeIdx\": 4,\n" +
            "            \"lon\": 11973308,\n" +
            "            \"lat\": 57693659,\n" +
            "            \"depTime\": \"13:39:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "            \"id\": \"740025701\",\n" +
            "            \"extId\": \"740025701\",\n" +
            "            \"routeIdx\": 5,\n" +
            "            \"lon\": 11969775,\n" +
            "            \"lat\": 57699124,\n" +
            "            \"arrTime\": \"13:41:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"name\": \"LÃ¤nstrafik - SpÃ¥rvÃ¤g 10\",\n" +
            "      \"stop\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "      \"stopid\": \"740025701\",\n" +
            "      \"stopExtId\": \"740025701\",\n" +
            "      \"time\": \"13:41:00\",\n" +
            "      \"date\": \"2016-10-29\",\n" +
            "      \"origin\": \"GÃ¶teborg Doktor Sydows gata\",\n" +
            "      \"transportNumber\": \"10\",\n" +
            "      \"transportCategory\": \"SLT\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Product\": {\n" +
            "        \"name\": \"LÃ¤nstrafik - Buss 19\",\n" +
            "        \"num\": \"19\",\n" +
            "        \"catCode\": \"7\",\n" +
            "        \"catOutS\": \"BLT\",\n" +
            "        \"catOutL\": \"LÃ¤nstrafik - Buss\",\n" +
            "        \"operatorCode\": \"279\",\n" +
            "        \"operator\": \"VÃ¤sttrafik\",\n" +
            "        \"operatorUrl\": \"http://www.vasttrafik.se\"\n" +
            "      },\n" +
            "      \"Stops\": {\n" +
            "        \"Stop\": [\n" +
            "          {\n" +
            "            \"name\": \"SÃ¶rgÃ¥rdsskolan (MÃ¶lndal kn)\",\n" +
            "            \"id\": \"740059788\",\n" +
            "            \"extId\": \"740059788\",\n" +
            "            \"routeIdx\": 0,\n" +
            "            \"lon\": 11994199,\n" +
            "            \"lat\": 57677586,\n" +
            "            \"depTime\": \"13:30:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"BjÃ¶rkuddsgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059134\",\n" +
            "            \"extId\": \"740059134\",\n" +
            "            \"routeIdx\": 1,\n" +
            "            \"lon\": 11990684,\n" +
            "            \"lat\": 57679635,\n" +
            "            \"depTime\": \"13:31:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"FramnÃ¤sgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059218\",\n" +
            "            \"extId\": \"740059218\",\n" +
            "            \"routeIdx\": 2,\n" +
            "            \"lon\": 11987475,\n" +
            "            \"lat\": 57682557,\n" +
            "            \"depTime\": \"13:32:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"PilbÃ¥gsgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059492\",\n" +
            "            \"extId\": \"740059492\",\n" +
            "            \"routeIdx\": 3,\n" +
            "            \"lon\": 11984652,\n" +
            "            \"lat\": 57684508,\n" +
            "            \"depTime\": \"13:34:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Engdahlsgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059196\",\n" +
            "            \"extId\": \"740059196\",\n" +
            "            \"routeIdx\": 4,\n" +
            "            \"lon\": 11983097,\n" +
            "            \"lat\": 57686665,\n" +
            "            \"depTime\": \"13:34:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Chalmers TvÃ¤rgata (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059169\",\n" +
            "            \"extId\": \"740059169\",\n" +
            "            \"routeIdx\": 5,\n" +
            "            \"lon\": 11980338,\n" +
            "            \"lat\": 57689721,\n" +
            "            \"depTime\": \"13:35:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Ã\u0085landsgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059683\",\n" +
            "            \"extId\": \"740059683\",\n" +
            "            \"routeIdx\": 6,\n" +
            "            \"lon\": 11977731,\n" +
            "            \"lat\": 57692220,\n" +
            "            \"depTime\": \"13:36:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Kapellplatsen\",\n" +
            "            \"id\": \"740025643\",\n" +
            "            \"extId\": \"740025643\",\n" +
            "            \"routeIdx\": 7,\n" +
            "            \"lon\": 11973308,\n" +
            "            \"lat\": 57693659,\n" +
            "            \"depTime\": \"13:38:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "            \"id\": \"740025701\",\n" +
            "            \"extId\": \"740025701\",\n" +
            "            \"routeIdx\": 8,\n" +
            "            \"lon\": 11969775,\n" +
            "            \"lat\": 57699124,\n" +
            "            \"arrTime\": \"13:41:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"name\": \"LÃ¤nstrafik - Buss 19\",\n" +
            "      \"stop\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "      \"stopid\": \"740025701\",\n" +
            "      \"stopExtId\": \"740025701\",\n" +
            "      \"time\": \"13:41:00\",\n" +
            "      \"date\": \"2016-10-29\",\n" +
            "      \"origin\": \"SÃ¶rgÃ¥rdsskolan (MÃ¶lndal kn)\",\n" +
            "      \"transportNumber\": \"19\",\n" +
            "      \"transportCategory\": \"BLT\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Product\": {\n" +
            "        \"name\": \"LÃ¤nstrafik - SpÃ¥rvÃ¤g 7\",\n" +
            "        \"num\": \"7\",\n" +
            "        \"catCode\": \"6\",\n" +
            "        \"catOutS\": \"SLT\",\n" +
            "        \"catOutL\": \"LÃ¤nstrafik - SpÃ¥rvÃ¤g\",\n" +
            "        \"operatorCode\": \"279\",\n" +
            "        \"operator\": \"VÃ¤sttrafik\",\n" +
            "        \"operatorUrl\": \"http://www.vasttrafik.se\"\n" +
            "      },\n" +
            "      \"Stops\": {\n" +
            "        \"Stop\": [\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Centralstation\",\n" +
            "            \"id\": \"740000002\",\n" +
            "            \"extId\": \"740000002\",\n" +
            "            \"routeIdx\": 0,\n" +
            "            \"lon\": 11973479,\n" +
            "            \"lat\": 57708895,\n" +
            "            \"depTime\": \"13:35:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Brunnsparken\",\n" +
            "            \"id\": \"740020752\",\n" +
            "            \"extId\": \"740020752\",\n" +
            "            \"routeIdx\": 1,\n" +
            "            \"lon\": 11967843,\n" +
            "            \"lat\": 57706945,\n" +
            "            \"depTime\": \"13:37:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Kungsportsplatsen\",\n" +
            "            \"id\": \"740016358\",\n" +
            "            \"extId\": \"740016358\",\n" +
            "            \"routeIdx\": 2,\n" +
            "            \"lon\": 11969748,\n" +
            "            \"lat\": 57704023,\n" +
            "            \"depTime\": \"13:39:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Valand\",\n" +
            "            \"id\": \"740025698\",\n" +
            "            \"extId\": \"740025698\",\n" +
            "            \"routeIdx\": 3,\n" +
            "            \"lon\": 11974522,\n" +
            "            \"lat\": 57700338,\n" +
            "            \"depTime\": \"13:41:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "            \"id\": \"740025701\",\n" +
            "            \"extId\": \"740025701\",\n" +
            "            \"routeIdx\": 4,\n" +
            "            \"lon\": 11969775,\n" +
            "            \"lat\": 57699124,\n" +
            "            \"arrTime\": \"13:42:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"name\": \"LÃ¤nstrafik - SpÃ¥rvÃ¤g 7\",\n" +
            "      \"stop\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "      \"stopid\": \"740025701\",\n" +
            "      \"stopExtId\": \"740025701\",\n" +
            "      \"time\": \"13:42:00\",\n" +
            "      \"date\": \"2016-10-29\",\n" +
            "      \"origin\": \"GÃ¶teborg Centralstation\",\n" +
            "      \"transportNumber\": \"7\",\n" +
            "      \"transportCategory\": \"SLT\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Product\": {\n" +
            "        \"name\": \"LÃ¤nstrafik - Buss 16\",\n" +
            "        \"num\": \"16\",\n" +
            "        \"catCode\": \"7\",\n" +
            "        \"catOutS\": \"BLT\",\n" +
            "        \"catOutL\": \"LÃ¤nstrafik - Buss\",\n" +
            "        \"operatorCode\": \"279\",\n" +
            "        \"operator\": \"VÃ¤sttrafik\",\n" +
            "        \"operatorUrl\": \"http://www.vasttrafik.se\"\n" +
            "      },\n" +
            "      \"Stops\": {\n" +
            "        \"Stop\": [\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg EketrÃ¤gatan\",\n" +
            "            \"id\": \"740025624\",\n" +
            "            \"extId\": \"740025624\",\n" +
            "            \"routeIdx\": 0,\n" +
            "            \"lon\": 11910285,\n" +
            "            \"lat\": 57716275,\n" +
            "            \"depTime\": \"13:15:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Lundby Gamla Kyrka (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059420\",\n" +
            "            \"extId\": \"740059420\",\n" +
            "            \"routeIdx\": 1,\n" +
            "            \"lon\": 11915939,\n" +
            "            \"lat\": 57712806,\n" +
            "            \"depTime\": \"13:16:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"SÃ¤terigatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059623\",\n" +
            "            \"extId\": \"740059623\",\n" +
            "            \"routeIdx\": 2,\n" +
            "            \"lon\": 11918375,\n" +
            "            \"lat\": 57709138,\n" +
            "            \"depTime\": \"13:17:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Danaplatsen (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059175\",\n" +
            "            \"extId\": \"740059175\",\n" +
            "            \"routeIdx\": 3,\n" +
            "            \"lon\": 11912954,\n" +
            "            \"lat\": 57705039,\n" +
            "            \"depTime\": \"13:18:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Eriksbergstorget (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059199\",\n" +
            "            \"extId\": \"740059199\",\n" +
            "            \"routeIdx\": 4,\n" +
            "            \"lon\": 11913233,\n" +
            "            \"lat\": 57702342,\n" +
            "            \"depTime\": \"13:21:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"SÃ¶rhallstorget (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059197\",\n" +
            "            \"extId\": \"740059197\",\n" +
            "            \"routeIdx\": 5,\n" +
            "            \"lon\": 11919642,\n" +
            "            \"lat\": 57703106,\n" +
            "            \"depTime\": \"13:22:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Nordviksgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059465\",\n" +
            "            \"extId\": \"740059465\",\n" +
            "            \"routeIdx\": 6,\n" +
            "            \"lon\": 11922061,\n" +
            "            \"lat\": 57707017,\n" +
            "            \"depTime\": \"13:23:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"SannegÃ¥rdshamnen (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059537\",\n" +
            "            \"extId\": \"740059537\",\n" +
            "            \"routeIdx\": 7,\n" +
            "            \"lon\": 11930816,\n" +
            "            \"lat\": 57707790,\n" +
            "            \"depTime\": \"13:25:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Lindholmen (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059410\",\n" +
            "            \"extId\": \"740059410\",\n" +
            "            \"routeIdx\": 8,\n" +
            "            \"lon\": 11938052,\n" +
            "            \"lat\": 57708104,\n" +
            "            \"depTime\": \"13:27:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"RegnbÃ¥gsgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059509\",\n" +
            "            \"extId\": \"740059509\",\n" +
            "            \"routeIdx\": 9,\n" +
            "            \"lon\": 11942754,\n" +
            "            \"lat\": 57710774,\n" +
            "            \"depTime\": \"13:27:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Pumpgatan (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740059497\",\n" +
            "            \"extId\": \"740059497\",\n" +
            "            \"routeIdx\": 10,\n" +
            "            \"lon\": 11946152,\n" +
            "            \"lat\": 57712725,\n" +
            "            \"depTime\": \"13:28:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"Frihamnsporten (GÃ¶teborg kn)\",\n" +
            "            \"id\": \"740072023\",\n" +
            "            \"extId\": \"740072023\",\n" +
            "            \"routeIdx\": 11,\n" +
            "            \"lon\": 11959528,\n" +
            "            \"lat\": 57718208,\n" +
            "            \"depTime\": \"13:30:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Nordstan\",\n" +
            "            \"id\": \"740015585\",\n" +
            "            \"extId\": \"740015585\",\n" +
            "            \"routeIdx\": 12,\n" +
            "            \"lon\": 11970791,\n" +
            "            \"lat\": 57709246,\n" +
            "            \"depTime\": \"13:35:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Brunnsparken\",\n" +
            "            \"id\": \"740020752\",\n" +
            "            \"extId\": \"740020752\",\n" +
            "            \"routeIdx\": 13,\n" +
            "            \"lon\": 11967843,\n" +
            "            \"lat\": 57706945,\n" +
            "            \"depTime\": \"13:37:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Domkyrkan\",\n" +
            "            \"id\": \"740025621\",\n" +
            "            \"extId\": \"740025621\",\n" +
            "            \"routeIdx\": 14,\n" +
            "            \"lon\": 11963708,\n" +
            "            \"lat\": 57704293,\n" +
            "            \"depTime\": \"13:39:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg GrÃ¶nsakstorget\",\n" +
            "            \"id\": \"740015567\",\n" +
            "            \"extId\": \"740015567\",\n" +
            "            \"routeIdx\": 15,\n" +
            "            \"lon\": 11964436,\n" +
            "            \"lat\": 57702495,\n" +
            "            \"depTime\": \"13:39:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "            \"id\": \"740025701\",\n" +
            "            \"extId\": \"740025701\",\n" +
            "            \"routeIdx\": 16,\n" +
            "            \"lon\": 11969775,\n" +
            "            \"lat\": 57699124,\n" +
            "            \"arrTime\": \"13:42:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"name\": \"LÃ¤nstrafik - Buss 16\",\n" +
            "      \"stop\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "      \"stopid\": \"740025701\",\n" +
            "      \"stopExtId\": \"740025701\",\n" +
            "      \"time\": \"13:42:00\",\n" +
            "      \"date\": \"2016-10-29\",\n" +
            "      \"origin\": \"GÃ¶teborg EketrÃ¤gatan\",\n" +
            "      \"transportNumber\": \"16\",\n" +
            "      \"transportCategory\": \"BLT\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Product\": {\n" +
            "        \"name\": \"LÃ¤nstrafik - SpÃ¥rvÃ¤g 3\",\n" +
            "        \"num\": \"3\",\n" +
            "        \"catCode\": \"6\",\n" +
            "        \"catOutS\": \"SLT\",\n" +
            "        \"catOutL\": \"LÃ¤nstrafik - SpÃ¥rvÃ¤g\",\n" +
            "        \"operatorCode\": \"279\",\n" +
            "        \"operator\": \"VÃ¤sttrafik\",\n" +
            "        \"operatorUrl\": \"http://www.vasttrafik.se\"\n" +
            "      },\n" +
            "      \"Stops\": {\n" +
            "        \"Stop\": [\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Marklandsgatan\",\n" +
            "            \"id\": \"740025657\",\n" +
            "            \"extId\": \"740025657\",\n" +
            "            \"routeIdx\": 0,\n" +
            "            \"lon\": 11936039,\n" +
            "            \"lat\": 57674404,\n" +
            "            \"depTime\": \"13:20:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Bokekullsgatan\",\n" +
            "            \"id\": \"740025612\",\n" +
            "            \"extId\": \"740025612\",\n" +
            "            \"routeIdx\": 1,\n" +
            "            \"lon\": 11932722,\n" +
            "            \"lat\": 57677217,\n" +
            "            \"depTime\": \"13:21:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg HÃ¶gsbogatan\",\n" +
            "            \"id\": \"740025639\",\n" +
            "            \"extId\": \"740025639\",\n" +
            "            \"routeIdx\": 2,\n" +
            "            \"lon\": 11930205,\n" +
            "            \"lat\": 57680238,\n" +
            "            \"depTime\": \"13:22:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Klintens VÃ¤g\",\n" +
            "            \"id\": \"740025645\",\n" +
            "            \"extId\": \"740025645\",\n" +
            "            \"routeIdx\": 3,\n" +
            "            \"lon\": 11927904,\n" +
            "            \"lat\": 57682548,\n" +
            "            \"depTime\": \"13:22:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Godhemsgatan\",\n" +
            "            \"id\": \"740025632\",\n" +
            "            \"extId\": \"740025632\",\n" +
            "            \"routeIdx\": 4,\n" +
            "            \"lon\": 11925998,\n" +
            "            \"lat\": 57684858,\n" +
            "            \"depTime\": \"13:23:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Mariaplan\",\n" +
            "            \"id\": \"740025656\",\n" +
            "            \"extId\": \"740025656\",\n" +
            "            \"routeIdx\": 5,\n" +
            "            \"lon\": 11920568,\n" +
            "            \"lat\": 57686647,\n" +
            "            \"depTime\": \"13:25:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Ostindiegatan\",\n" +
            "            \"id\": \"740025670\",\n" +
            "            \"extId\": \"740025670\",\n" +
            "            \"routeIdx\": 6,\n" +
            "            \"lon\": 11915373,\n" +
            "            \"lat\": 57687726,\n" +
            "            \"depTime\": \"13:27:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Vagnhallen Majorna\",\n" +
            "            \"id\": \"740025697\",\n" +
            "            \"extId\": \"740025697\",\n" +
            "            \"routeIdx\": 7,\n" +
            "            \"lon\": 11912280,\n" +
            "            \"lat\": 57689038,\n" +
            "            \"depTime\": \"13:28:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Jaegerdorffsplatsen\",\n" +
            "            \"id\": \"740025640\",\n" +
            "            \"extId\": \"740025640\",\n" +
            "            \"routeIdx\": 8,\n" +
            "            \"lon\": 11915274,\n" +
            "            \"lat\": 57691573,\n" +
            "            \"depTime\": \"13:29:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Chapmans Torg\",\n" +
            "            \"id\": \"740025618\",\n" +
            "            \"extId\": \"740025618\",\n" +
            "            \"routeIdx\": 9,\n" +
            "            \"lon\": 11919580,\n" +
            "            \"lat\": 57694315,\n" +
            "            \"depTime\": \"13:30:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Kaptensgatan\",\n" +
            "            \"id\": \"740025644\",\n" +
            "            \"extId\": \"740025644\",\n" +
            "            \"routeIdx\": 10,\n" +
            "            \"lon\": 11927355,\n" +
            "            \"lat\": 57697083,\n" +
            "            \"depTime\": \"13:31:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Stigbergstorget\",\n" +
            "            \"id\": \"740025686\",\n" +
            "            \"extId\": \"740025686\",\n" +
            "            \"routeIdx\": 11,\n" +
            "            \"lon\": 11934996,\n" +
            "            \"lat\": 57698971,\n" +
            "            \"depTime\": \"13:33:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Masthuggstorget\",\n" +
            "            \"id\": \"740025658\",\n" +
            "            \"extId\": \"740025658\",\n" +
            "            \"routeIdx\": 12,\n" +
            "            \"lon\": 11944570,\n" +
            "            \"lat\": 57699520,\n" +
            "            \"depTime\": \"13:35:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg JÃ¤rntorget\",\n" +
            "            \"id\": \"740015573\",\n" +
            "            \"extId\": \"740015573\",\n" +
            "            \"routeIdx\": 13,\n" +
            "            \"lon\": 11952084,\n" +
            "            \"lat\": 57700086,\n" +
            "            \"depTime\": \"13:37:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Hagakyrkan\",\n" +
            "            \"id\": \"740025634\",\n" +
            "            \"extId\": \"740025634\",\n" +
            "            \"routeIdx\": 14,\n" +
            "            \"lon\": 11961856,\n" +
            "            \"lat\": 57699591,\n" +
            "            \"depTime\": \"13:39:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Vasa Viktoriagatan\",\n" +
            "            \"id\": \"740025702\",\n" +
            "            \"extId\": \"740025702\",\n" +
            "            \"routeIdx\": 15,\n" +
            "            \"lon\": 11965928,\n" +
            "            \"lat\": 57698360,\n" +
            "            \"depTime\": \"13:41:00\",\n" +
            "            \"depDate\": \"2016-10-29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "            \"id\": \"740025701\",\n" +
            "            \"extId\": \"740025701\",\n" +
            "            \"routeIdx\": 16,\n" +
            "            \"lon\": 11969775,\n" +
            "            \"lat\": 57699124,\n" +
            "            \"arrTime\": \"13:42:00\",\n" +
            "            \"arrDate\": \"2016-10-29\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"name\": \"LÃ¤nstrafik - SpÃ¥rvÃ¤g 3\",\n" +
            "      \"stop\": \"GÃ¶teborg Vasaplatsen\",\n" +
            "      \"stopid\": \"740025701\",\n" +
            "      \"stopExtId\": \"740025701\",\n" +
            "      \"time\": \"13:42:00\",\n" +
            "      \"date\": \"2016-10-29\",\n" +
            "      \"origin\": \"GÃ¶teborg Marklandsgatan\",\n" +
            "      \"transportNumber\": \"3\",\n" +
            "      \"transportCategory\": \"SLT\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    private static String NEARBY_NEW = "{\n" +
            "  \"StopLocation\" : [ {\n" +
            "    \"id\" : \"7459589\",\n" +
            "    \"extId\" : \"7459589\",\n" +
            "    \"name\" : \"Stena Metall (Göteborg kn)\",\n" +
            "    \"lon\" : 11.987043,\n" +
            "    \"lat\" : 57.725606,\n" +
            "    \"weight\" : 93,\n" +
            "    \"dist\" : 557,\n" +
            "    \"products\" : 128\n" +
            "  }, {\n" +
            "    \"id\" : \"7459113\",\n" +
            "    \"extId\" : \"7459113\",\n" +
            "    \"name\" : \"Tingstadsvägen (Göteborg kn)\",\n" +
            "    \"lon\" : 11.98565,\n" +
            "    \"lat\" : 57.729588,\n" +
            "    \"weight\" : 93,\n" +
            "    \"dist\" : 561,\n" +
            "    \"products\" : 128\n" +
            "  }, {\n" +
            "    \"id\" : \"7401590\",\n" +
            "    \"extId\" : \"7401590\",\n" +
            "    \"name\" : \"Gamlestaden station (Göteborg kn)\",\n" +
            "    \"lon\" : 12.00441,\n" +
            "    \"lat\" : 57.729148,\n" +
            "    \"weight\" : 4774,\n" +
            "    \"dist\" : 574,\n" +
            "    \"products\" : 16\n" +
            "  }, {\n" +
            "    \"id\" : \"7459675\",\n" +
            "    \"extId\" : \"7459675\",\n" +
            "    \"name\" : \"Vassgatan (Göteborg kn)\",\n" +
            "    \"lon\" : 11.993596,\n" +
            "    \"lat\" : 57.723098,\n" +
            "    \"weight\" : 93,\n" +
            "    \"dist\" : 593,\n" +
            "    \"products\" : 128\n" +
            "  }, {\n" +
            "    \"id\" : \"7459458\",\n" +
            "    \"extId\" : \"7459458\",\n" +
            "    \"name\" : \"Tidningshuset (Göteborg kn)\",\n" +
            "    \"lon\" : 11.986612,\n" +
            "    \"lat\" : 57.731521,\n" +
            "    \"weight\" : 93,\n" +
            "    \"dist\" : 599,\n" +
            "    \"products\" : 128\n" +
            "  }, {\n" +
            "    \"id\" : \"7425630\",\n" +
            "    \"extId\" : \"7425630\",\n" +
            "    \"name\" : \"Göteborg Gamlestadstorget\",\n" +
            "    \"lon\" : 12.005911,\n" +
            "    \"lat\" : 57.728321,\n" +
            "    \"weight\" : 2684,\n" +
            "    \"dist\" : 657,\n" +
            "    \"products\" : 192\n" +
            "  }, {\n" +
            "    \"id\" : \"7459370\",\n" +
            "    \"extId\" : \"7459370\",\n" +
            "    \"name\" : \"Kristinedal (Göteborg kn)\",\n" +
            "    \"lon\" : 12.0077,\n" +
            "    \"lat\" : 57.726658,\n" +
            "    \"weight\" : 441,\n" +
            "    \"dist\" : 788,\n" +
            "    \"products\" : 128\n" +
            "  }, {\n" +
            "    \"id\" : \"7459103\",\n" +
            "    \"extId\" : \"7459103\",\n" +
            "    \"name\" : \"Balamundi (Göteborg kn)\",\n" +
            "    \"lon\" : 11.987124,\n" +
            "    \"lat\" : 57.734595,\n" +
            "    \"weight\" : 93,\n" +
            "    \"dist\" : 828,\n" +
            "    \"products\" : 128\n" +
            "  }, {\n" +
            "    \"id\" : \"7459240\",\n" +
            "    \"extId\" : \"7459240\",\n" +
            "    \"name\" : \"Nylösegatan (Göteborg kn)\",\n" +
            "    \"lon\" : 12.007116,\n" +
            "    \"lat\" : 57.732509,\n" +
            "    \"weight\" : 441,\n" +
            "    \"dist\" : 861,\n" +
            "    \"products\" : 128\n" +
            "  }, {\n" +
            "    \"id\" : \"7459170\",\n" +
            "    \"extId\" : \"7459170\",\n" +
            "    \"name\" : \"Cold Stores (Göteborg kn)\",\n" +
            "    \"lon\" : 11.982593,\n" +
            "    \"lat\" : 57.723736,\n" +
            "    \"weight\" : 93,\n" +
            "    \"dist\" : 892,\n" +
            "    \"products\" : 128\n" +
            "  } ]\n" +
            "}";



}
