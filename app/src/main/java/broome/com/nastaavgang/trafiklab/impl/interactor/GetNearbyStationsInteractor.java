package broome.com.nastaavgang.trafiklab.impl.interactor;

import broome.com.nastaavgang.base.impl.LocationInteractor;
import broome.com.nastaavgang.executor.interfaces.Executor;
import broome.com.nastaavgang.executor.interfaces.Interactor;
import broome.com.nastaavgang.base.interfaces.GetLastLocation;
import broome.com.nastaavgang.base.interfaces.GetNearbyStations;
import broome.com.nastaavgang.nearbystations.impl.model.Station;
import broome.com.nastaavgang.trafiklab.interfaces.TrafikLabService;
import broome.com.nastaavgang.trafiklab.impl.model.stations.Example;
import broome.com.nastaavgang.trafiklab.impl.model.stations.Location;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit.RetrofitError;

/**
 * Created by robin on 16/08/15.
 */
public class GetNearbyStationsInteractor implements GetNearbyStations,Interactor,GetLastLocation.Callback {

    private static String TAG = GetNearbyStationsInteractor.class.getSimpleName();
    private Executor executor;
    private Callback cb;
    private TrafikLabService trafikLabService;
    private LocationInteractor ls;
    private android.location.Location lastLocation;

    @Inject
    public GetNearbyStationsInteractor(Executor executor, TrafikLabService trafikLabService,LocationInteractor locationService) {
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

                List<Location> locations = getNearbyStations();
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

    private void notifyOnStationsFound(List<Location> stations){
        List<Station> stationsList = new ArrayList<Station>();
        for(Location l : stations){
            double x = Double.valueOf(l.getX());
            double y = Double.valueOf(l.getY());
            Station s = new Station(l.getName(),new LatLng(y,x),l.getId(),l.getMunicipality().getText());
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

    private List<Location> getNearbyStations() throws RetrofitError{
        if(lastLocation != null) {
            Example s = trafikLabService.getNearbyStation(String.valueOf(lastLocation.getLongitude()),
                    String.valueOf(lastLocation.getLatitude()));
            Log.d("HOHOHOHOH", s.getStationsinzoneresult().getLocation().get(0).getName());
            List<Location> locations = s.getStationsinzoneresult().getLocation();
            return locations;
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
