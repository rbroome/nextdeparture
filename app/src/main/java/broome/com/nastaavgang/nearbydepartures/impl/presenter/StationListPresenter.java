package broome.com.nastaavgang.nearbydepartures.impl.presenter;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import broome.com.nastaavgang.base.interfaces.GetLastLocation;
import broome.com.nastaavgang.base.interfaces.GetNearbyDepartures;
import broome.com.nastaavgang.base.interfaces.GetNearbyStations;
import broome.com.nastaavgang.nearbydepartures.impl.model.Departure;
import broome.com.nastaavgang.nearbydepartures.interfaces.Presenter;
import broome.com.nastaavgang.nearbystations.impl.model.Station;

/**
 * Created by robin on 16/08/15.
 */
public class StationListPresenter extends Presenter {
    private static String TAG = StationListPresenter.class.getSimpleName();
    GetNearbyStations getNearbyStations;
    GetNearbyDepartures getNearbyDepartures;
    private List<Station> stationsList;
    private StationListPresenter.View view;
    GetLastLocation ls;

    @Inject
    public StationListPresenter(GetNearbyStations getNearbyStations,GetNearbyDepartures getNearbyDepartures,GetLastLocation ls) {
        this.getNearbyStations = getNearbyStations;
        this.getNearbyDepartures = getNearbyDepartures;
        this.ls = ls;
    }

    public void setView(StationListPresenter.View view){
        this.view = view;
    }

    public void getGetNearbyStations(){
        view.showLoading();

        getNearbyStations.execute(new GetNearbyStations.Callback() {
            @Override
            public void onStationsFound(List<Station> stations) {
                view.showStationsFound(stations);
                stationsList = stations;
                getNearbyDepartures(stations);
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

     public void getNearbyDepartures(List<Station> stationsList){
         view.showLoading();

         if(stationsList != null) {
             getNearbyDepartures.execute(new GetNearbyDepartures.Callback() {
                 @Override
                 public void onDeparturesFound(List<Departure> departures) {
                     view.showDeparturesFound(departures);
                 }

                 @Override
                 public void onDeparturesNotFound() {

                 }

                 @Override
                 public void onConnectionError() {
                     view.showConnectionError();

                 }
             },stationsList.get(0).getId(),stationsList.get(0).getCity());
         }else{
             view.showStationsNotFound();
         }
     }
    public void getNearbyDepartures(String id,String city){
        view.showLoading();


            getNearbyDepartures.execute(new GetNearbyDepartures.Callback() {
                @Override
                public void onDeparturesFound(List<Departure> departures) {
                    view.showDeparturesFound(departures);
                }

                @Override
                public void onDeparturesNotFound() {
                    view.showStationsNotFound();

                }

                @Override
                public void onConnectionError() {
                    view.showConnectionError();

                }
            },id,city);

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

    private String convertDate(String date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(dateFormat.parse(date));
        }catch (ParseException e){
            Log.e(this.getClass().getSimpleName(),e.getMessage());

        }
        long i = cal2.getTimeInMillis() - cal.getTimeInMillis();
        int minLeft = (int) i/(1000*60);
        if(minLeft == 0){
            return "Nu";

        }else
            return String.valueOf(minLeft) + " min";
    }

    public interface View{
        void showLoading();
        void showConnectionError();
        void showStationsNotFound();
        void showStationsFound(List<Station> stations);
        void showDeparturesFound(List<Departure> departures);

    }
}
