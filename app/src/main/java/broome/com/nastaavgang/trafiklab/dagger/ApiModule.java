package broome.com.nastaavgang.trafiklab.dagger;

import broome.com.nastaavgang.base.impl.LocationInteractor;
import broome.com.nastaavgang.base.interfaces.GetNearbyDepartures;
import broome.com.nastaavgang.base.interfaces.GetNearbyStations;
import broome.com.nastaavgang.executor.interfaces.Executor;
import broome.com.nastaavgang.trafiklab.impl.interactor.GetNearbyDeparturesInteractor;
import broome.com.nastaavgang.trafiklab.impl.interactor.GetNearbyStationsInteractor;
import broome.com.nastaavgang.trafiklab.impl.model.stations.Producerlist;
import broome.com.nastaavgang.trafiklab.impl.model.stations.Transportlist;
import broome.com.nastaavgang.trafiklab.impl.util.ProducerTypeAdapter;
import broome.com.nastaavgang.trafiklab.impl.util.TransportTypeAdapter;
import broome.com.nastaavgang.trafiklab.interfaces.TrafikLabService;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;


/**
 * Created by robin on 16/08/15.
*/
@Module
public class ApiModule {
    public static final String PRODUCTION_API_URL = "https://api.trafiklab.se/samtrafiken";
    @Provides
    Endpoint provideEndpoint(){
        return Endpoints.newFixedEndpoint(PRODUCTION_API_URL);
    }
    @Provides
    RestAdapter provideRestAdapter(Endpoint endpoint){

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Producerlist.class, new ProducerTypeAdapter());
        gsonBuilder.registerTypeAdapter(Transportlist.class,new TransportTypeAdapter());
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
    TrafikLabService provideTrafikLabService(RestAdapter restAdapter){
        return restAdapter.create(TrafikLabService.class);
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
