package broome.com.nastaavgang.trafiklab2.impl.interactor;

import com.google.android.gms.maps.model.LatLng;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import broome.com.nastaavgang.base.interfaces.GetNearbyDepartures;
import broome.com.nastaavgang.executor.interfaces.Executor;
import broome.com.nastaavgang.executor.interfaces.Interactor;
import broome.com.nastaavgang.nearbydeparture.impl.model.Departure;
import broome.com.nastaavgang.trafiklab.impl.util.SwedenColorChooser;
import broome.com.nastaavgang.trafiklab2.impl.model.departure.Arrival;
import broome.com.nastaavgang.trafiklab2.impl.model.departure.Arrivals;
import broome.com.nastaavgang.trafiklab2.impl.model.departure.Departures;
import broome.com.nastaavgang.trafiklab2.impl.model.departure.Stop;
import broome.com.nastaavgang.trafiklab2.interfaces.TrafikLab2Service;
import retrofit.RetrofitError;

/**
 * Created by robin on 16/08/15.
 */
public class GetNearbyDeparturesInteractor implements Interactor,GetNearbyDepartures {

    private Executor executor;
    private GetNearbyDepartures.Callback cb;
    private TrafikLab2Service trafikLabService;
    private String id;
    private String city;

    @Inject
    public GetNearbyDeparturesInteractor(Executor executor, TrafikLab2Service trafikLabService) {
        this.executor = executor;
        this.trafikLabService = trafikLabService;
    }

    @Override
    public void execute(Callback cb,String id,String city) {
        this.cb = cb;
        this.city = city;
        this.id = id;
        this.executor.run(this);

    }

    @Override
    public void run() {
        try{
            List<broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure> departures = getNearbyDepartures();
            if(departures !=null && departures.size() >0){
                notifyOnDeparturesFound(departures);
            }else{
                notifyOnDeparturesNotFound();
            }

        }catch(RetrofitError e){
            if (e.getKind() == RetrofitError.Kind.NETWORK){
                notifyOnConnectionError();
            }
        }

    }

    private List<broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure> getNearbyDepartures() throws RetrofitError{
        Arrivals arrivals = trafikLabService.getArrivals(this.id);
        Departures resp = trafikLabService.getDepartures(this.id);

        List<broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure> dep = resp.getDeparture();
        int i = 0;
        for(broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure d : dep){
            if(isValid(d.getDate() +" "+d.getTime())) {
                d.getStops().setStop(mergeStops(d, arrivals.getArrival().get(i)));
                i++;
            }

        }


        return resp.getDeparture();

    }

    private boolean isValid(String date1){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(dateFormat.parse(date1));
        }catch (ParseException e){

        }
        long i = cal2.getTimeInMillis() - cal.getTimeInMillis();
        int minLeft = (int) i/(1000*60);
        return minLeft >= 0;

    }

    private List<Stop> mergeStops(broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure d, Arrival a){
        ArrayList<Stop> stops = new ArrayList<>();
        for(Stop s : a.getStops().getStop()){
            stops.add(s);
        }
        for(Stop s : d.getStops().getStop()){
            if(!s.getId().equalsIgnoreCase(stops.get(stops.size()-1).getId()))
                stops.add(s);
        }
        return stops;
    }
    private void notifyOnDeparturesFound(List<broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure> departures){
        List<Departure> departuresList = new ArrayList<Departure>();
        for(broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure d : departures){
            Stop currentStop = d.getStops().getStop().get(0);
            //TODO: Should take care of rtTime here
            String timeLeft = convertDate(d.getDate() +" "+d.getTime());
            if(timeLeft == null){
                continue;
            }
            LatLng loc = new LatLng(Double.valueOf(currentStop.getLat()),Double.valueOf(currentStop.getLon()));
            String number = d.getTransportNumber();//d.getName().replace(d.getProduct().getCatOutS(),"").replaceAll("\\s+", "");
            String city = "Göteborg";
            String direction = d.getDirection().replaceAll("\\(.+\\)", "");
            //TODO: Replace with code from Marcus
            int primaryColor = SwedenColorChooser.getPrimaryColor(number, city);
            int secondaryColor = SwedenColorChooser.getSecondaryColor(number,city);

            List<Stop> apiStops= d.getStops().getStop();
            List<broome.com.nastaavgang.nearbydeparture.impl.model.Stop> stops = new ArrayList<broome.com.nastaavgang.nearbydeparture.impl.model.Stop>();
            for(Stop s : apiStops){
                broome.com.nastaavgang.nearbydeparture.impl.model.Stop tempStop = new broome.com.nastaavgang.nearbydeparture.impl.model.Stop();
                tempStop.setName(s.getName());
                tempStop.setArrTime(s.getArrTime());
                tempStop.setDepTime(s.getDepTime());
                tempStop.setRtDepTime(s.getDepTime());
                tempStop.setDate(d.getDate());
                stops.add(tempStop);
            }

            Departure departure = new Departure(timeLeft, direction, number,loc,d.getStop(),secondaryColor,primaryColor,stops);

            departuresList.add(departure);
        }
        cb.onDeparturesFound(departuresList);

    }


    private String convertDate(String date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(dateFormat.parse(date));
        }catch (ParseException e){

        }
        long i = cal2.getTimeInMillis() - cal.getTimeInMillis();
        int minLeft = (int) i/(1000*60);
        if(minLeft == 0){
            return "Nu";

        }else if(minLeft < 0){
            return null;
        }else
            return String.valueOf(minLeft) + " min";
    }
    private void notifyOnDeparturesNotFound(){cb.onDeparturesNotFound();}
    private void notifyOnConnectionError(){
        cb.onConnectionError();
    }

}
