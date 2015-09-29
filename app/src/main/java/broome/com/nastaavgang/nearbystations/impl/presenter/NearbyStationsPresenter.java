package broome.com.nastaavgang.nearbystations.impl.presenter;

import broome.com.nastaavgang.base.impl.LocationInteractor;
import broome.com.nastaavgang.base.interfaces.GetNearbyStations;
import broome.com.nastaavgang.nearbydeparture.impl.model.Departure;
import broome.com.nastaavgang.nearbydeparture.impl.presenter.StationListPresenter;
import broome.com.nastaavgang.nearbydeparture.interfaces.Presenter;
import broome.com.nastaavgang.nearbystations.impl.model.Station;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by robin on 05/09/15.
 */
public class NearbyStationsPresenter extends Presenter {
    private static String TAG = StationListPresenter.class.getSimpleName();
    GetNearbyStations getNearbyStations;
    private List<Station> stationsList;
    LocationInteractor ls;
    NearbyStationsPresenter.View view;

    @Inject
    public NearbyStationsPresenter(LocationInteractor ls, GetNearbyStations getNearbyStations) {
        this.ls = ls;
        this.getNearbyStations = getNearbyStations;
    }

    public void getGetNearbyStations(){
        view.showLoading();

        getNearbyStations.execute(new GetNearbyStations.Callback() {
            @Override
            public void onStationsFound(List<Station> stations) {
                view.showStationsFound(stations);

            }

            @Override
            public void onStationsNotFound() {
                view.showStationsNotFound();
            }

            @Override
            public void onConnectionError() {
                view.showConnectionError();
            }
        });
    }

    public void setView(View v){
        this.view = v;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void paus() {

    }

    public interface View{
        void showLoading();
        void showConnectionError();
        void showStationsNotFound();
        void showStationsFound(List<Station> stations);
        void showDeparturesFound(List<Departure> departures);

    }
}
