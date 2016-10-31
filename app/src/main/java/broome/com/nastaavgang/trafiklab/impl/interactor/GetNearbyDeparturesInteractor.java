package broome.com.nastaavgang.trafiklab.impl.interactor;

import broome.com.nastaavgang.base.interfaces.GetNearbyDepartures;
import broome.com.nastaavgang.executor.interfaces.Executor;
import broome.com.nastaavgang.executor.interfaces.Interactor;
import broome.com.nastaavgang.nearbydepartures.impl.model.Departure;
import broome.com.nastaavgang.trafiklab.impl.model.departure.DepartureResponse;
import broome.com.nastaavgang.trafiklab.impl.model.departure.Departuresegment;
import broome.com.nastaavgang.trafiklab.impl.util.SwedenColorChooser;
import broome.com.nastaavgang.trafiklab.interfaces.TrafikLabService;

import com.google.android.gms.maps.model.LatLng;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import broome.com.nastaavgang.trafiklab.impl.model.departure.Location;
import retrofit.RetrofitError;

/**
 * Created by robin on 16/08/15.
 */
public class GetNearbyDeparturesInteractor implements Interactor,GetNearbyDepartures {

    private Executor executor;
    private GetNearbyDepartures.Callback cb;
    private TrafikLabService trafikLabService;
    private String id;
    private String city;

    @Inject
    public GetNearbyDeparturesInteractor(Executor executor, TrafikLabService trafikLabService) {
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
            List<Departuresegment> departures = getNearbyDepartures();
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

    private List<Departuresegment> getNearbyDepartures() throws RetrofitError{
        DepartureResponse resp = trafikLabService.getDepartures(id);

        return resp.getGetdeparturesresult().getDeparturesegment();

    }
    private void notifyOnDeparturesFound(List<Departuresegment> departures){
        List<Departure> departuresList = new ArrayList<Departure>();
        for(Departuresegment d : departures){
            String timeLeft = convertDate(d.getDeparture().getDatetime());
            Location l = d.getDeparture().getLocation();
            LatLng loc = new LatLng(Double.valueOf(l.getY()),Double.valueOf(l.getX()));
            String number = d.getSegmentid().getCarrier().getNumber();
            int primaryColor = SwedenColorChooser.getPrimaryColor(number, city);
            int secondaryColor = SwedenColorChooser.getSecondaryColor(number,city);

            Departure departure = new Departure(timeLeft, d.getDirection(), number,loc,d.getDeparture().getLocation().getName(),secondaryColor,primaryColor);

            departuresList.add(departure);
        }
        cb.onDeparturesFound(departuresList);

    }


    private String convertDate(String date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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

        }else
            return String.valueOf(minLeft) + " min";
    }
            private void notifyOnDeparturesNotFound(){cb.onDeparturesNotFound();}
    private void notifyOnConnectionError(){
        cb.onConnectionError();
    }

}
