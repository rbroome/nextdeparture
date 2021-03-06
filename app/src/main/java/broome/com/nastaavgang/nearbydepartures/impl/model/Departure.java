package broome.com.nastaavgang.nearbydepartures.impl.model;

import android.broome.com.nastaavgang.R;

import com.google.android.gms.maps.model.LatLng;

import java.util.Collections;
import java.util.List;

/**
 *
 * Created by robin on 30/08/15.
 */
public class Departure {
    private String timeLeft;
    private String toStation;
    private String fromStation;
    private String number;
    private LatLng location;
    private int primaryColor;
    private int secondaryColor;
    private List<Stop> stops;

    public Departure(String timeLeft, String toStation, String number,LatLng location,String fromStation) {
        this.timeLeft = timeLeft;
        this.toStation = toStation;
        this.number = number;
        this.location = location;
        this.fromStation = fromStation;
        this.secondaryColor = R.color.secundaryBlue;
        this.primaryColor = R.color.front78;
        this.stops = Collections.emptyList();
    }
    public Departure(String timeLeft, String toStation, String number,LatLng location,String fromStation,int secondaryColor,int primaryColor) {
        this.timeLeft = timeLeft;
        this.toStation = toStation;
        this.number = number;
        this.location = location;
        this.fromStation = fromStation;
        this.secondaryColor = secondaryColor;
        this.primaryColor = primaryColor;
        this.stops = Collections.emptyList();
    }
    public Departure(String timeLeft, String toStation, String number,LatLng location,String fromStation,int secondaryColor,int primaryColor,List<Stop> stops) {
        this.timeLeft = timeLeft;
        this.toStation = toStation;
        this.number = number;
        this.location = location;
        this.fromStation = fromStation;
        this.secondaryColor = secondaryColor;
        this.primaryColor = primaryColor;
        this.stops = stops;
    }

    public int getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(int primaryColor) {
        this.primaryColor = primaryColor;
    }

    public int getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(int secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public int getNrOfStops(){return stops.size();}
    public List<Stop> getStops(){return stops;}
}
