package broome.com.nastaavgang.trafiklab2.impl.interactor;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import broome.com.nastaavgang.base.impl.LocationInteractor;
import broome.com.nastaavgang.base.interfaces.GetLastLocation;
import broome.com.nastaavgang.base.interfaces.GetNearbyStations;
import broome.com.nastaavgang.executor.interfaces.Executor;
import broome.com.nastaavgang.executor.interfaces.Interactor;
import broome.com.nastaavgang.nearbystations.impl.model.Station;
import broome.com.nastaavgang.trafiklab2.impl.model.stations.Stations;
import broome.com.nastaavgang.trafiklab2.impl.model.stations.StopLocation;
import broome.com.nastaavgang.trafiklab2.interfaces.TrafikLab2Service;
import retrofit.RetrofitError;

/**
 * Created by robin on 21/12/15.
 */
public class GetNearbyStationsInteractor implements GetNearbyStations,Interactor,GetLastLocation.Callback {

    private static String TAG = GetNearbyStationsInteractor.class.getSimpleName();
    private Executor executor;
    private Callback cb;
    private TrafikLab2Service trafikLabService;
    private LocationInteractor ls;
    private android.location.Location lastLocation;

    @Inject
    public GetNearbyStationsInteractor(Executor executor, TrafikLab2Service trafikLabService,LocationInteractor locationService) {
        this.executor = executor;
        this.trafikLabService = trafikLabService;
        this.ls = locationService;
    }



    @Override
    public void execute(Callback cb) {
        this.cb = cb;
        ls.execute(this);

    }


    @Override
    public void run() {
        try {

            List<StopLocation> locations = getNearbyStations();
            if (locations != null && locations.size() > 0) {
                notifyOnStationsFound(locations);
            } else {
                notifyOnStationsNotFound();
            }

        } catch (RetrofitError e) {
            if (e.getKind() == RetrofitError.Kind.NETWORK) {
                notifyOnConnectionError();
            }
        }


    }

    private void notifyOnStationsFound(List<StopLocation> stations){
        List<Station> stationsList = new ArrayList<>();
        for(StopLocation l : stations){
            double x = l.getLon();
            double y = l.getLat();
            Station s = new Station(l.getName(),new LatLng(y,x),l.getId(),l.getName());
            stationsList.add(s);
        }

        cb.onStationsFound(stationsList);
    }
    private void notifyOnStationsNotFound(){
        cb.onStationsNotFound();

    }
    private void notifyOnConnectionError(){
        cb.onConnectionError();
    }

    private List<StopLocation> getNearbyStations() throws RetrofitError{
        if(lastLocation != null) {
            Stations s = trafikLabService.getNearbyStation(String.valueOf(lastLocation.getLongitude()),
                    String.valueOf(lastLocation.getLatitude()));
            return s.getStopLocation();
        }else{
            Log.e(TAG,"Last location is not known, canceling");
            return null;
        }
    }

    @Override
    public void onLastLocationFound(android.location.Location location) {
        this.lastLocation = location;
        this.executor.run(this);

    }

    @Override
    public void onLocationNotFound() {
        Log.e(TAG,"Last location is not known, canceling");
        cb.onStationsNotFound();
    }

    @Override
    public void onConnectionError() {
        cb.onConnectionError();
    }
}

