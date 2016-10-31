package broome.com.nastaavgang.base.interfaces;

import java.util.List;

import broome.com.nastaavgang.nearbydepartures.impl.model.Departure;

/**
 * Interface for getting departures near the user.
 * It will either return a list of Departures or errors.
 *
 *
 * Created by robin on 16/08/15.
 */
public interface GetNearbyDepartures {
    interface Callback{
        void onDeparturesFound(final List<Departure> departures);
        void onDeparturesNotFound();
        void onConnectionError();
    }
    void execute(GetNearbyDepartures.Callback cb,String id,String city);


}
