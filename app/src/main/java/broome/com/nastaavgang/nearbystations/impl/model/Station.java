package broome.com.nastaavgang.nearbystations.impl.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by robin on 05/09/15.
 */
public class Station {

    private String name;
    private LatLng location;
    private String id;
    private String city;

    public Station(String name, LatLng location,String id,String city) {
        this.name = name;
        this.location = location;
        this.id = id;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
