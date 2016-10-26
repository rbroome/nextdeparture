package broome.com.nastaavgang.base.interfaces;

import android.location.Location;

/**
 * Interface for getting the users location.
 * It will return the location or an error if no location is found
 *
 * Created by robin on 24/08/15.
 */
public interface GetLastLocation {
    interface Callback{
        void onLastLocationFound(final Location location);
        void onLocationNotFound();
        void onConnectionError();
    }
    void execute(GetLastLocation.Callback cb);
}
