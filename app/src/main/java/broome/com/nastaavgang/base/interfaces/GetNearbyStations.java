package broome.com.nastaavgang.base.interfaces;

import java.util.List;

import broome.com.nastaavgang.nearbystations.impl.model.Station;

/**
 * Interface for getting nearby stations.
 * It will return either a list of the stations or an error.
 * Created by robin on 16/08/15.
 */
public interface GetNearbyStations {
    interface Callback{
        void onStationsFound(final List<Station> stations);
        void onStationsNotFound();
        void onConnectionError();
    }
    void execute(Callback cb);

}
