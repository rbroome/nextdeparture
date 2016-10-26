package broome.com.nastaavgang.trafiklab2.dagger;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import broome.com.nastaavgang.base.impl.LocationInteractor;
import broome.com.nastaavgang.base.interfaces.GetNearbyDepartures;
import broome.com.nastaavgang.base.interfaces.GetNearbyStations;
import broome.com.nastaavgang.executor.interfaces.Executor;
import broome.com.nastaavgang.trafiklab2.impl.interactor.GetNearbyDeparturesInteractor;
import broome.com.nastaavgang.trafiklab2.impl.interactor.GetNearbyStationsInteractor;
import broome.com.nastaavgang.trafiklab2.interfaces.TrafikLab2Service;
import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;


/**
 * Module for trafiklab 2s APIs
 * Builds all components needed for the interactors.
 * Created by robin on 21/12/15.
 */
@Module
public class ApiModule {
    public static final String PRODUCTION_API_URL = "https://api.resrobot.se";
    @Provides
    Endpoint provideEndpoint(){
        return Endpoints.newFixedEndpoint(PRODUCTION_API_URL);
    }
    @Provides
    RestAdapter provideRestAdapter(Endpoint endpoint){

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(endpoint)
                //.setClient(new MockClient())
                .setConverter(new GsonConverter(gson))
                .build();
    }
    @Provides
    LocationInteractor provideLocationService(Executor executor, Context c){
        return new LocationInteractor(executor,c);
    }
    @Provides
    TrafikLab2Service provideTrafikLabService(RestAdapter restAdapter){
        return restAdapter.create(TrafikLab2Service.class);
    }
    @Provides
    GetNearbyStations provideGetNearbyStationsInteractor(GetNearbyStationsInteractor interactor){
        return interactor;
    }
    @Provides
    GetNearbyDepartures providGetNearbyDeparturesInteractor(GetNearbyDeparturesInteractor interactor){
        return interactor;
    }

}
