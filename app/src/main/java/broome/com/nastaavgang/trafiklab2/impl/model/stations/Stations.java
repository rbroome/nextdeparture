package broome.com.nastaavgang.trafiklab2.impl.model.stations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Stations {

    @SerializedName("StopLocation")
    @Expose
    private List<StopLocation> StopLocation = new ArrayList<StopLocation>();

    /**
     *
     * @return
     * The StopLocation
     */
    public List<StopLocation> getStopLocation() {
        return StopLocation;
    }

    /**
     *
     * @param StopLocation
     * The StopLocation
     */
    public void setStopLocation(List<StopLocation> StopLocation) {
        this.StopLocation = StopLocation;
    }

}