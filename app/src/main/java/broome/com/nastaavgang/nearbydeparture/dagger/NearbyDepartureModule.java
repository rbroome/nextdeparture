package broome.com.nastaavgang.nearbydeparture.dagger;

import broome.com.nastaavgang.base.impl.LocationInteractor;
import broome.com.nastaavgang.base.interfaces.GetNearbyDepartures;
import broome.com.nastaavgang.base.interfaces.GetNearbyStations;
import broome.com.nastaavgang.nearbydeparture.impl.presenter.StationListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by robin on 20/09/15.
 */
@Module
public class NearbyDepartureModule {

    @Provides
    StationListPresenter provideStationListPrestenter(GetNearbyStations getNearbyStations,GetNearbyDepartures getNearbyDepartures,LocationInteractor ls){
        return new StationListPresenter(getNearbyStations, getNearbyDepartures,ls);
    }
}
