package broome.com.nastaavgang.trafiklab2.impl.interactor;

import java.util.ArrayList;
import java.util.List;

import broome.com.nastaavgang.trafiklab2.impl.model.departure.Arrival;
import broome.com.nastaavgang.trafiklab2.impl.model.departure.Arrivals;
import broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure;
import broome.com.nastaavgang.trafiklab2.impl.model.departure.Departures;
import broome.com.nastaavgang.trafiklab2.impl.model.departure.Product;
import broome.com.nastaavgang.trafiklab2.impl.model.departure.Stop;
import broome.com.nastaavgang.trafiklab2.impl.model.departure.Stops;
import broome.com.nastaavgang.trafiklab2.impl.model.stations.Stations;
import broome.com.nastaavgang.trafiklab2.impl.model.stations.StopLocation;

/**
 * Created by robin on 30/10/16.
 */

public class TrafikLabBaseTest {

    public Arrivals getEmptyArrivals(){
        Arrivals arrivals = new Arrivals();
        Arrival a1 = new Arrival();


        return arrivals;
    }
    public Departures getEmptyDepartures(){

        Departures departures = new Departures();
        broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure departure = new broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure();
        return departures;
    }
    public Departures getDepartures(){

        Departures departures = new Departures();
        List<Departure> departureList = new ArrayList<>();

        Departure departure = new broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure();
        departure.setDate("2016-10-29");
        departure.setDirection("SÃ¶rgÃ¥rdsskolan (MÃ¶lndal kn)");
        departure.setName("LÃ¤nstrafik - Buss 19");
        departure.setStop("GÃ¶teborg Vasaplatsen");
        departure.setStopExtId("740025701");
        departure.setStopid("740025701");
        departure.setTime("13:40:00");
        departure.setTransportCategory("BLT");
        departure.setTransportNumber("19");
        departure.setStops(generateStops());
        departure.setProduct(generateProduct());

        departureList.add(departure);
        departures.setDeparture(departureList);

        return departures;
    }
    public Arrivals getArrivals(){
        Arrivals arrivals = new Arrivals();
        List<Arrival> arrivalList = new ArrayList<>();
        Arrival arrival = new Arrival();
        arrival.setDate("2016-10-29");
        arrival.setName("LÃ¤nstrafik - SpÃ¥rvÃ¤g 10");
        arrival.setOrigin("GÃ¶teborg Doktor Sydows gata");
        arrival.setStop("GÃ¶teborg Vasaplatsen");
        arrival.setStopExtId("740025701");
        arrival.setStopid("740025701");
        arrival.setTime("13:41:00");
        arrival.setTransportCategory("BLT");
        arrival.setTransportNumber("19");

        arrival.setProduct(generateProduct());
        arrival.setStops(generateStops());

        arrivalList.add(arrival);
        arrivals.setArrival(arrivalList);
        return arrivals;
    }

    public Stops generateStops(){
        Stop stop = new Stop();
        stop.setDepDate("2016-10-29");
        stop.setDepTime("13:40:00");
        stop.setExtId("740025701");
        stop.setId("740025701");
        stop.setLat(57.699124);
        stop.setLon(11.969775);
        stop.setName("GÃ¶teborg Vasaplatsen");
        Stops stops = new Stops();
        List<Stop> stopList = new ArrayList<>();
        stopList.add(stop);
        stops.setStop(stopList);
        return stops;
    }
    public Product generateProduct(){
        Product product = new Product();
        product.setCatCode("7");
        product.setCatOutL("LÃ¤nstrafik - Buss");
        product.setCatOutS("BLT");
        product.setName("LÃ¤nstrafik - Buss 19");
        product.setNum("19");
        product.setOperator("VÃ¤sttrafik");
        product.setOperatorCode("279");
        return product;
    }

    public Stations getEmptyStations(){
        Stations stations = new Stations();
        return stations;
    }

    public StopLocation generateStopLocation(){
        StopLocation stop = new StopLocation();
        stop.setDist(557);
        stop.setExtId("7459589");
        stop.setId("7459589");
        stop.setLat(57.725606);
        stop.setLon(11.987043);
        stop.setName("Stena Metall (Göteborg kn)");
        stop.setProducts(128);
        stop.setWeight(93);
        return stop;
    }

    public Stations getStations(){
        Stations stations = new Stations();
        List<StopLocation> list = new ArrayList<>();
        list.add(generateStopLocation());
        stations.setStopLocation(list);
        return stations;
    }
}
