package broome.com.nastaavgang.trafiklab2.impl.model.departure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Departures {

    @SerializedName("Departure")
    @Expose
    private List<broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure> Departure = new ArrayList<broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure>();

    /**
     *
     * @return
     * The Departure
     */
    public List<broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure> getDeparture() {
        return Departure;
    }

    /**
     *
     * @param Departure
     * The Departure
     */
    public void setDeparture(List<broome.com.nastaavgang.trafiklab2.impl.model.departure.Departure> Departure) {
        this.Departure = Departure;
    }

}