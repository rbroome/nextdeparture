package broome.com.nastaavgang.trafiklab2.interfaces;

import broome.com.nastaavgang.base.apikeys.ApiKeys;
import broome.com.nastaavgang.trafiklab2.impl.model.departure.Arrivals;
import broome.com.nastaavgang.trafiklab2.impl.model.departure.Departures;
import broome.com.nastaavgang.trafiklab2.impl.model.stations.Stations;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by robin on 16/08/15.
 */
public interface TrafikLab2Service {
    String STOPKEY = ApiKeys.RESEPLANERARE;
    String DEPTKEY = ApiKeys.RESROBOT2;

    @GET("/location.nearbystops?key="+STOPKEY+"&format=json")
    Stations getNearbyStation(@Query("originCoordLong") String x,@Query("originCoordLat") String y);

    @GET("/departureBoard?key="+DEPTKEY+"&format=json")
    Departures getDepartures(@Query("id") String locationId);

    @GET("/arrivalBoard?key="+DEPTKEY+"&format=json")
    Arrivals getArrivals(@Query("id") String locationId);


}

