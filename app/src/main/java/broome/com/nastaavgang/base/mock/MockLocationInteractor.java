package broome.com.nastaavgang.base.mock;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import javax.inject.Inject;

import broome.com.nastaavgang.base.interfaces.GetLastLocation;
import broome.com.nastaavgang.executor.interfaces.Executor;
import broome.com.nastaavgang.executor.interfaces.Interactor;

/**
 * Created by robin on 29/10/16.
 */

public class MockLocationInteractor implements GetLastLocation,Interactor,GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private Location lastLocation;
    private GetLastLocation.Callback cb;
    private Executor executor;
    private Context c;


    @Inject
    public MockLocationInteractor(Executor executor, Context c) {
        this.executor = executor;
        this.c = c;
    }

    @Override
    public void execute(Callback cb) {
        this.cb = cb;
        executor.run(this);
    }

    @Override
    public void run() {

        onConnected(new Bundle());

    }

    @Override
    public void onConnected(Bundle bundle) {
        lastLocation = new Location("test");
        lastLocation.setLongitude(1.0);
        lastLocation.setLatitude(1.0);
        cb.onLastLocationFound(lastLocation);

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
