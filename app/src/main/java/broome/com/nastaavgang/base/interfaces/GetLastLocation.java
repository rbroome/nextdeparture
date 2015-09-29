package broome.com.nastaavgang.base.interfaces;

import android.location.Location;

/**
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
