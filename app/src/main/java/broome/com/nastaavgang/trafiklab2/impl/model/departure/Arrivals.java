package broome.com.nastaavgang.trafiklab2.impl.model.departure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Arrivals {

    @SerializedName("Arrival")
    @Expose
    private List<broome.com.nastaavgang.trafiklab2.impl.model.departure.Arrival> Arrival = new ArrayList<broome.com.nastaavgang.trafiklab2.impl.model.departure.Arrival>();

    /**
     *
     * @return
     * The Departure
     */
    public List<broome.com.nastaavgang.trafiklab2.impl.model.departure.Arrival> getArrival() {
        return Arrival;
    }

    /**
     *
     * @param Departure
     * The Departure
     */
    public void setArrival(List<broome.com.nastaavgang.trafiklab2.impl.model.departure.Arrival> Arrival) {
        this.Arrival = Arrival;
    }

}