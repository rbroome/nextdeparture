package broome.com.nastaavgang.trafiklab.impl.model.stations;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Stationsinzoneresult {

    @Expose
    private List<Location> location = new ArrayList<Location>();

    /**
     *
     * @return
     * The location
     */
    public List<Location> getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(List<Location> location) {
        this.location = location;
    }

}