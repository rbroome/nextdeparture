package broome.com.nastaavgang.trafiklab.impl.model.departure;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Departuresegment {

    @Expose
    private Departure departure;
    @Expose
    private String direction;
    @Expose
    private Segmentid segmentid;

    /**
     *
     * @return
     * The departure
     */
    public Departure getDeparture() {
        return departure;
    }

    /**
     *
     * @param departure
     * The departure
     */
    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    /**
     *
     * @return
     * The direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     *
     * @param direction
     * The direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     *
     * @return
     * The segmentid
     */
    public Segmentid getSegmentid() {
        return segmentid;
    }

    /**
     *
     * @param segmentid
     * The segmentid
     */
    public void setSegmentid(Segmentid segmentid) {
        this.segmentid = segmentid;
    }

}