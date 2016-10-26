package broome.com.nastaavgang.di;

import android.app.Activity;

import javax.inject.Singleton;

import broome.com.nastaavgang.base.impl.LocationInteractor;
import broome.com.nastaavgang.executor.dagger.ExecutorModule;
import broome.com.nastaavgang.nearbydeparture.dagger.NearbyDepartureModule;
import broome.com.nastaavgang.nearbydeparture.impl.presenter.StationListPresenter;
import broome.com.nastaavgang.nearbystations.dagger.NearbyStationsModule;
import broome.com.nastaavgang.nearbystations.impl.presenter.NearbyStationsPresenter;
import broome.com.nastaavgang.trafiklab2.impl.interactor.GetNearbyStationsInteractor;
import broome.com.nastaavgang.trafiklab2.dagger.ApiModule;
import dagger.Component;

/**
 * Main component containing all Presenters.
 * Created by robin on 02/05/15.
 */
@Singleton
@Component(modules = {ApiModule.class, ExecutorModule.class, NearbyStationsModule.class,NearbyDepartureModule.class,ApplicationModule.class})
public interface ApplicationComponent {

    void inject(Activity activity);
    GetNearbyStationsInteractor getNearbyStations();
    StationListPresenter stationListPrestener();
    NearbyStationsPresenter nearbyStationsPresenter();
    //Context getContext();
    LocationInteractor locationService();

}
