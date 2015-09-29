package broome.com.nastaavgang.trafiklab.interfaces;

import broome.com.nastaavgang.base.apikeys.ApiKeys;
import broome.com.nastaavgang.trafiklab.impl.model.stations.Example;
import broome.com.nastaavgang.trafiklab.impl.model.departure.DepartureResponse;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by robin on 16/08/15.
 */
public interface TrafikLabService {
    public static final String KEY = ApiKeys.TRAFIKLABKEY;

    @GET("/resrobot/StationsInZone.json?apiVersion=2.1&radius=1000&coordSys=WGS84&"+KEY)
    Example getNearbyStation(@Query("centerX") String x,@Query("centerY") String y);
    @GET("/resrobotstops/GetDepartures.json?apiVersion=2.1&coordSys=WGS84&"+ KEY)
    DepartureResponse getDepartures(@Query("locationId") String locationId);

}

