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

        if(uri.getPath().contains("departureBoard")) {
            responseString = DEPARTURE_NEW;
        } else {
            responseString = NEARBY_NEW;
        }


        return new Response(request.getUrl(), 200, "nothing", Collections.EMPTY_LIST, new TypedByteArray("application/json", responseString.getBytes()));
    }


    private String DEPARTURE_NEW = "{\n" +
            "  \"Departure\" : [ {\n" +
            "    \"Product\" : {\n" +
            "      \"name\" : \"SLT    7\",\n" +
            "      \"num\" : \"37643\",\n" +
            "      \"catCode\" : \"6\",\n" +
            "      \"catOutS\" : \"SLT\",\n" +
            "      \"catOutL\" : \"Spårvagn\",\n" +
            "      \"operatorCode\" : \"279\",\n" +
            "      \"operator\" : \"Västtrafik\",\n" +
            "      \"operatorUrl\" : \"http://www.vasttrafik.se/\"\n" +
            "    },\n" +
            "    \"Stops\" : {\n" +
            "      \"Stop\" : [ {\n" +
            "        \"name\" : \"Göteborg Gamlestadstorget\",\n" +
            "        \"id\" : \"7425630\",\n" +
            "        \"extId\" : \"7425630\",\n" +
            "        \"routeIdx\" : 21,\n" +
            "        \"lon\" : 12.005911,\n" +
            "        \"lat\" : 57.728321,\n" +
            "        \"depTime\" : \"18:07:00\",\n" +
            "        \"depDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg SKF\",\n" +
            "        \"id\" : \"7425683\",\n" +
            "        \"extId\" : \"7425683\",\n" +
            "        \"routeIdx\" : 22,\n" +
            "        \"lon\" : 12.013597,\n" +
            "        \"lat\" : 57.729246,\n" +
            "        \"arrTime\" : \"18:08:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Bellevue\",\n" +
            "        \"id\" : \"7425609\",\n" +
            "        \"extId\" : \"7425609\",\n" +
            "        \"routeIdx\" : 23,\n" +
            "        \"lon\" : 12.023234,\n" +
            "        \"lat\" : 57.732177,\n" +
            "        \"arrTime\" : \"18:10:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Kviberg\",\n" +
            "        \"id\" : \"7425648\",\n" +
            "        \"extId\" : \"7425648\",\n" +
            "        \"routeIdx\" : 24,\n" +
            "        \"lon\" : 12.025067,\n" +
            "        \"lat\" : 57.736465,\n" +
            "        \"arrTime\" : \"18:11:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Beväringsgatan\",\n" +
            "        \"id\" : \"7425611\",\n" +
            "        \"extId\" : \"7425611\",\n" +
            "        \"routeIdx\" : 25,\n" +
            "        \"lon\" : 12.028564,\n" +
            "        \"lat\" : 57.739872,\n" +
            "        \"arrTime\" : \"18:12:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Nymånegatan\",\n" +
            "        \"id\" : \"7425665\",\n" +
            "        \"extId\" : \"7425665\",\n" +
            "        \"routeIdx\" : 26,\n" +
            "        \"lon\" : 12.029796,\n" +
            "        \"lat\" : 57.743054,\n" +
            "        \"arrTime\" : \"18:13:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Kortedala Runstavsgatan (Göteborg kn)\",\n" +
            "        \"id\" : \"7425675\",\n" +
            "        \"extId\" : \"7425675\",\n" +
            "        \"routeIdx\" : 27,\n" +
            "        \"lon\" : 12.030227,\n" +
            "        \"lat\" : 57.747584,\n" +
            "        \"arrTime\" : \"18:15:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Kortedala Torg (Göteborg kn)\",\n" +
            "        \"id\" : \"7415579\",\n" +
            "        \"extId\" : \"7415579\",\n" +
            "        \"routeIdx\" : 28,\n" +
            "        \"lon\" : 12.032861,\n" +
            "        \"lat\" : 57.752942,\n" +
            "        \"arrTime\" : \"18:16:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Kortedala Allhelgonakyrkan (Göteborg kn)\",\n" +
            "        \"id\" : \"7425604\",\n" +
            "        \"extId\" : \"7425604\",\n" +
            "        \"routeIdx\" : 29,\n" +
            "        \"lon\" : 12.03669,\n" +
            "        \"lat\" : 57.757347,\n" +
            "        \"arrTime\" : \"18:18:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Kortedala Januarigatan (Göteborg kn)\",\n" +
            "        \"id\" : \"7425641\",\n" +
            "        \"extId\" : \"7425641\",\n" +
            "        \"routeIdx\" : 30,\n" +
            "        \"lon\" : 12.04123,\n" +
            "        \"lat\" : 57.760286,\n" +
            "        \"arrTime\" : \"18:19:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Bergsjön Galileis Gata (Göteborg kn)\",\n" +
            "        \"id\" : \"7425629\",\n" +
            "        \"extId\" : \"7425629\",\n" +
            "        \"routeIdx\" : 31,\n" +
            "        \"lon\" : 12.051577,\n" +
            "        \"lat\" : 57.76052,\n" +
            "        \"arrTime\" : \"18:21:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Bergsjön Teleskopgatan (Göteborg kn)\",\n" +
            "        \"id\" : \"7425691\",\n" +
            "        \"extId\" : \"7425691\",\n" +
            "        \"routeIdx\" : 32,\n" +
            "        \"lon\" : 12.060098,\n" +
            "        \"lat\" : 57.759738,\n" +
            "        \"arrTime\" : \"18:22:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Bergsjön Rymdtorget Spårvagn (Göteborg kn)\",\n" +
            "        \"id\" : \"7425676\",\n" +
            "        \"extId\" : \"7425676\",\n" +
            "        \"routeIdx\" : 33,\n" +
            "        \"lon\" : 12.06684,\n" +
            "        \"lat\" : 57.755836,\n" +
            "        \"arrTime\" : \"18:23:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Bergsjön Komettorget (Göteborg kn)\",\n" +
            "        \"id\" : \"7425646\",\n" +
            "        \"extId\" : \"7425646\",\n" +
            "        \"routeIdx\" : 34,\n" +
            "        \"lon\" : 12.071398,\n" +
            "        \"lat\" : 57.75109,\n" +
            "        \"arrTime\" : \"18:25:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      } ]\n" +
            "    },\n" +
            "    \"name\" : \"SLT    7\",\n" +
            "    \"type\" : \"S\",\n" +
            "    \"stop\" : \"Göteborg Gamlestadstorget\",\n" +
            "    \"stopid\" : \"7425630\",\n" +
            "    \"stopExtId\" : \"7425630\",\n" +
            "    \"time\" : \"18:07:00\",\n" +
            "    \"date\" : \"2015-12-21\",\n" +
            "    \"direction\" : \"Bergsjön Komettorget (Göteborg kn)\",\n" +
            "    \"transportNumber\" : \"37643\",\n" +
            "    \"transportCategory\" : \"SLT\"\n" +
            "  }, {\n" +
            "    \"Product\" : {\n" +
            "      \"name\" : \"SLT    7\",\n" +
            "      \"num\" : \"37790\",\n" +
            "      \"catCode\" : \"6\",\n" +
            "      \"catOutS\" : \"SLT\",\n" +
            "      \"catOutL\" : \"Spårvagn\",\n" +
            "      \"operatorCode\" : \"279\",\n" +
            "      \"operator\" : \"Västtrafik\",\n" +
            "      \"operatorUrl\" : \"http://www.vasttrafik.se/\"\n" +
            "    },\n" +
            "    \"Stops\" : {\n" +
            "      \"Stop\" : [ {\n" +
            "        \"name\" : \"Göteborg Gamlestadstorget\",\n" +
            "        \"id\" : \"7425630\",\n" +
            "        \"extId\" : \"7425630\",\n" +
            "        \"routeIdx\" : 13,\n" +
            "        \"lon\" : 12.005911,\n" +
            "        \"lat\" : 57.728321,\n" +
            "        \"depTime\" : \"18:07:00\",\n" +
            "        \"depDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Centralstation\",\n" +
            "        \"id\" : \"7400002\",\n" +
            "        \"extId\" : \"7400002\",\n" +
            "        \"routeIdx\" : 14,\n" +
            "        \"lon\" : 11.973478,\n" +
            "        \"lat\" : 57.708895,\n" +
            "        \"arrTime\" : \"18:13:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Brunnsparken\",\n" +
            "        \"id\" : \"7420752\",\n" +
            "        \"extId\" : \"7420752\",\n" +
            "        \"routeIdx\" : 15,\n" +
            "        \"lon\" : 11.967842,\n" +
            "        \"lat\" : 57.706944,\n" +
            "        \"arrTime\" : \"18:15:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Kungsportsplatsen\",\n" +
            "        \"id\" : \"7416358\",\n" +
            "        \"extId\" : \"7416358\",\n" +
            "        \"routeIdx\" : 16,\n" +
            "        \"lon\" : 11.969748,\n" +
            "        \"lat\" : 57.704032,\n" +
            "        \"arrTime\" : \"18:17:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Valand\",\n" +
            "        \"id\" : \"7425698\",\n" +
            "        \"extId\" : \"7425698\",\n" +
            "        \"routeIdx\" : 17,\n" +
            "        \"lon\" : 11.974521,\n" +
            "        \"lat\" : 57.700337,\n" +
            "        \"arrTime\" : \"18:19:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Vasaplatsen\",\n" +
            "        \"id\" : \"7425701\",\n" +
            "        \"extId\" : \"7425701\",\n" +
            "        \"routeIdx\" : 18,\n" +
            "        \"lon\" : 11.969775,\n" +
            "        \"lat\" : 57.699124,\n" +
            "        \"arrTime\" : \"18:20:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Kapellplatsen\",\n" +
            "        \"id\" : \"7425643\",\n" +
            "        \"extId\" : \"7425643\",\n" +
            "        \"routeIdx\" : 19,\n" +
            "        \"lon\" : 11.973308,\n" +
            "        \"lat\" : 57.693658,\n" +
            "        \"arrTime\" : \"18:22:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Chalmers\",\n" +
            "        \"id\" : \"7425617\",\n" +
            "        \"extId\" : \"7425617\",\n" +
            "        \"routeIdx\" : 20,\n" +
            "        \"lon\" : 11.97293,\n" +
            "        \"lat\" : 57.689955,\n" +
            "        \"arrTime\" : \"18:23:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Wavrinskys Plats\",\n" +
            "        \"id\" : \"7425703\",\n" +
            "        \"extId\" : \"7425703\",\n" +
            "        \"routeIdx\" : 21,\n" +
            "        \"lon\" : 11.968606,\n" +
            "        \"lat\" : 57.68893,\n" +
            "        \"arrTime\" : \"18:24:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Medicinaregatan\",\n" +
            "        \"id\" : \"7425659\",\n" +
            "        \"extId\" : \"7425659\",\n" +
            "        \"routeIdx\" : 22,\n" +
            "        \"lon\" : 11.964345,\n" +
            "        \"lat\" : 57.685442,\n" +
            "        \"arrTime\" : \"18:26:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Sahlgrenska Huvudentr\",\n" +
            "        \"id\" : \"7415591\",\n" +
            "        \"extId\" : \"7415591\",\n" +
            "        \"routeIdx\" : 23,\n" +
            "        \"lon\" : 11.960831,\n" +
            "        \"lat\" : 57.683626,\n" +
            "        \"arrTime\" : \"18:27:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Botaniska Trädgården\",\n" +
            "        \"id\" : \"7425689\",\n" +
            "        \"extId\" : \"7425689\",\n" +
            "        \"routeIdx\" : 24,\n" +
            "        \"lon\" : 11.945792,\n" +
            "        \"lat\" : 57.681019,\n" +
            "        \"arrTime\" : \"18:30:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Marklandsgatan\",\n" +
            "        \"id\" : \"7425657\",\n" +
            "        \"extId\" : \"7425657\",\n" +
            "        \"routeIdx\" : 25,\n" +
            "        \"lon\" : 11.936038,\n" +
            "        \"lat\" : 57.674403,\n" +
            "        \"arrTime\" : \"18:32:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Axel Dahlströms torg\",\n" +
            "        \"id\" : \"7425608\",\n" +
            "        \"extId\" : \"7425608\",\n" +
            "        \"routeIdx\" : 26,\n" +
            "        \"lon\" : 11.927445,\n" +
            "        \"lat\" : 57.672435,\n" +
            "        \"arrTime\" : \"18:33:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Lantmilsgatan\",\n" +
            "        \"id\" : \"7425652\",\n" +
            "        \"extId\" : \"7425652\",\n" +
            "        \"routeIdx\" : 27,\n" +
            "        \"lon\" : 11.924649,\n" +
            "        \"lat\" : 57.667185,\n" +
            "        \"arrTime\" : \"18:35:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Göteborg Nymilsgatan\",\n" +
            "        \"id\" : \"7425664\",\n" +
            "        \"extId\" : \"7425664\",\n" +
            "        \"routeIdx\" : 28,\n" +
            "        \"lon\" : 11.924442,\n" +
            "        \"lat\" : 57.662744,\n" +
            "        \"arrTime\" : \"18:36:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Frölunda Musikvägen (Göteborg kn)\",\n" +
            "        \"id\" : \"7425662\",\n" +
            "        \"extId\" : \"7425662\",\n" +
            "        \"routeIdx\" : 29,\n" +
            "        \"lon\" : 11.920963,\n" +
            "        \"lat\" : 57.659175,\n" +
            "        \"arrTime\" : \"18:37:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Frölunda Positivgatan (Göteborg kn)\",\n" +
            "        \"id\" : \"7420480\",\n" +
            "        \"extId\" : \"7420480\",\n" +
            "        \"routeIdx\" : 30,\n" +
            "        \"lon\" : 11.917718,\n" +
            "        \"lat\" : 57.656721,\n" +
            "        \"arrTime\" : \"18:38:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Frölunda Torg (Göteborg kn)\",\n" +
            "        \"id\" : \"7415565\",\n" +
            "        \"extId\" : \"7415565\",\n" +
            "        \"routeIdx\" : 31,\n" +
            "        \"lon\" : 11.90979,\n" +
            "        \"lat\" : 57.652209,\n" +
            "        \"arrTime\" : \"18:40:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Tynnered Briljantgatan (Göteborg kn)\",\n" +
            "        \"id\" : \"7425613\",\n" +
            "        \"extId\" : \"7425613\",\n" +
            "        \"routeIdx\" : 32,\n" +
            "        \"lon\" : 11.903219,\n" +
            "        \"lat\" : 57.648595,\n" +
            "        \"arrTime\" : \"18:42:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Tynnered Smaragdgatan (Göteborg kn)\",\n" +
            "        \"id\" : \"7425684\",\n" +
            "        \"extId\" : \"7425684\",\n" +
            "        \"routeIdx\" : 33,\n" +
            "        \"lon\" : 11.899245,\n" +
            "        \"lat\" : 57.645332,\n" +
            "        \"arrTime\" : \"18:43:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      }, {\n" +
            "        \"name\" : \"Tynnered Opaltorget (Göteborg kn)\",\n" +
            "        \"id\" : \"7425668\",\n" +
            "        \"extId\" : \"7425668\",\n" +
            "        \"routeIdx\" : 34,\n" +
            "        \"lon\" : 11.900845,\n" +
            "        \"lat\" : 57.641665,\n" +
            "        \"arrTime\" : \"18:44:00\",\n" +
            "        \"arrDate\" : \"2015-12-21\"\n" +
            "      } ]\n" +
            "    },\n" +
            "    \"name\" : \"SLT    7\",\n" +
            "    \"type\" : \"S\",\n" +
            "    \"stop\" : \"Göteborg Gamlestadstorget\",\n" +
            "    \"stopid\" : \"7425630\",\n" +
            "    \"stopExtId\" : \"7425630\",\n" +
            "    \"time\" : \"18:07:00\",\n" +
            "    \"date\" : \"2015-12-21\",\n" +
            "    \"direction\" : \"Tynnered Opaltorget (Göteborg kn)\",\n" +
            "    \"transportNumber\" : \"37790\",\n" +
            "    \"transportCategory\" : \"SLT\"\n" +
            "  } ]\n" +
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
