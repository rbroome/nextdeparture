package broome.com.nastaavgang.base.interfaces;

import broome.com.nastaavgang.nearbystations.impl.model.Station;

import java.util.List;

/**
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
