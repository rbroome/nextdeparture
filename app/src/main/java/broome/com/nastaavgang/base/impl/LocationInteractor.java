package broome.com.nastaavgang.base.impl;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import javax.inject.Inject;

import broome.com.nastaavgang.base.interfaces.GetLastLocation;
import broome.com.nastaavgang.executor.interfaces.Executor;
import broome.com.nastaavgang.executor.interfaces.Interactor;

/**
 * Interactor for Google location service
 * Created by robin on 19/08/15.
 */
public class LocationInteractor implements GetLastLocation,Interactor,GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {


    private GoogleApiClient googleApiClient;
    private GetLastLocation.Callback cb;
    private Executor executor;
    private Location lastLocation;
    private Context c;

    @Inject
    public LocationInteractor(Executor executor, Context c) {
        this.executor = executor;
        this.c = c;
    }

    @Override
    public void run() {
        this.googleApiClient = new GoogleApiClient.Builder(c)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        this.googleApiClient.connect();

    }


    @Override
    public void onConnected(Bundle bundle) {
        lastLocation = LocationServices.FusedLocationApi.getLastLocation(
                googleApiClient);
        if(lastLocation != null)
            cb.onLastLocationFound(lastLocation);
        else
            cb.onLocationNotFound();

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        cb.onConnectionError();

    }

    @Override
    public void execute(Callback cb) {
        this.cb = cb;
        this.executor.run(this);


    }
}
