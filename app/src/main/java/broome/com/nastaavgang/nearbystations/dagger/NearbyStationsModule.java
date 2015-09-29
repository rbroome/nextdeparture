package broome.com.nastaavgang.nearbystations.dagger;

import broome.com.nastaavgang.base.impl.LocationInteractor;
import broome.com.nastaavgang.base.interfaces.GetNearbyStations;
import broome.com.nastaavgang.nearbystations.impl.presenter.NearbyStationsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by robin on 20/09/15.
 */
@Module
public class NearbyStationsModule {

    @Provides
    NearbyStationsPresenter provideNearbyStationsPresenter(LocationInteractor ls, GetNearbyStations getNearbyStations){
        return new NearbyStationsPresenter(ls,getNearbyStations);
    }

}
