package broome.com.nastaavgang.nearbystations.impl.presenter;

import java.util.List;

import javax.inject.Inject;

import broome.com.nastaavgang.base.interfaces.GetLastLocation;
import broome.com.nastaavgang.base.interfaces.GetNearbyStations;
import broome.com.nastaavgang.nearbydepartures.impl.model.Departure;
import broome.com.nastaavgang.nearbydepartures.impl.presenter.StationListPresenter;
import broome.com.nastaavgang.nearbydepartures.interfaces.Presenter;
import broome.com.nastaavgang.nearbystations.impl.model.Station;

/**
 * Created by robin on 05/09/15.
 */
public class NearbyStationsPresenter extends Presenter {
    private static String TAG = StationListPresenter.class.getSimpleName();
    GetNearbyStations getNearbyStations;
    private List<Station> stationsList;
    GetLastLocation ls;
    NearbyStationsPresenter.View view;

    @Inject
    public NearbyStationsPresenter(GetLastLocation ls, GetNearbyStations getNearbyStations) {
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
