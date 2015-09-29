package broome.com.nastaavgang.trafiklab.impl.model.departure;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Segmentid {

    @Expose
    private Mot mot;
    @Expose
    private Carrier carrier;

    /**
     *
     * @return
     * The mot
     */
    public Mot getMot() {
        return mot;
    }

    /**
     *
     * @param mot
     * The mot
     */
    public void setMot(Mot mot) {
        this.mot = mot;
    }

    /**
     *
     * @return
     * The carrier
     */
    public Carrier getCarrier() {
        return carrier;
    }

    /**
     *
     * @param carrier
     * The carrier
     */
    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

}