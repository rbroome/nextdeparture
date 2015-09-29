package broome.com.nastaavgang.base.interfaces;

import broome.com.nastaavgang.nearbydeparture.impl.model.Departure;

import java.util.List;

/**
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
