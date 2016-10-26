package broome.com.nastaavgang.trafiklab2.impl.model.departure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Stops {

    @SerializedName("Stop")
    @Expose
    private List<broome.com.nastaavgang.trafiklab2.impl.model.departure.Stop> Stop = new ArrayList<broome.com.nastaavgang.trafiklab2.impl.model.departure.Stop>();

    /**
     *
     * @return
     * The Stop
     */
    public List<broome.com.nastaavgang.trafiklab2.impl.model.departure.Stop> getStop() {
        return Stop;
    }

    /**
     *
     * @param Stop
     * The Stop
     */
    public void setStop(List<broome.com.nastaavgang.trafiklab2.impl.model.departure.Stop> Stop) {
        this.Stop = Stop;
    }

}