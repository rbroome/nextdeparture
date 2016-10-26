package broome.com.nastaavgang.trafiklab2.impl.model.departure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Departure {

    @SerializedName("Product")
    @Expose
    private broome.com.nastaavgang.trafiklab2.impl.model.departure.Product Product;
    @SerializedName("Stops")
    @Expose
    private broome.com.nastaavgang.trafiklab2.impl.model.departure.Stops Stops;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("stop")
    @Expose
    private String stop;
    @SerializedName("stopid")
    @Expose
    private String stopid;
    @SerializedName("stopExtId")
    @Expose
    private String stopExtId;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("transportNumber")
    @Expose
    private String transportNumber;
    @SerializedName("transportCategory")
    @Expose
    private String transportCategory;

    /**
     *
     * @return
     * The Product
     */
    public broome.com.nastaavgang.trafiklab2.impl.model.departure.Product getProduct() {
        return Product;
    }

    /**
     *
     * @param Product
     * The Product
     */
    public void setProduct(broome.com.nastaavgang.trafiklab2.impl.model.departure.Product Product) {
        this.Product = Product;
    }

    /**
     *
     * @return
     * The Stops
     */
    public broome.com.nastaavgang.trafiklab2.impl.model.departure.Stops getStops() {
        return Stops;
    }

    /**
     *
     * @param Stops
     * The Stops
     */
    public void setStops(broome.com.nastaavgang.trafiklab2.impl.model.departure.Stops Stops) {
        this.Stops = Stops;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The stop
     */
    public String getStop() {
        return stop;
    }

    /**
     *
     * @param stop
     * The stop
     */
    public void setStop(String stop) {
        this.stop = stop;
    }

    /**
     *
     * @return
     * The stopid
     */
    public String getStopid() {
        return stopid;
    }

    /**
     *
     * @param stopid
     * The stopid
     */
    public void setStopid(String stopid) {
        this.stopid = stopid;
    }

    /**
     *
     * @return
     * The stopExtId
     */
    public String getStopExtId() {
        return stopExtId;
    }

    /**
     *
     * @param stopExtId
     * The stopExtId
     */
    public void setStopExtId(String stopExtId) {
        this.stopExtId = stopExtId;
    }

    /**
     *
     * @return
     * The time
     */
    public String getTime() {
        return time;
    }

    /**
     *
     * @param time
     * The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
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
     * The transportNumber
     */
    public String getTransportNumber() {
        return transportNumber;
    }

    /**
     *
     * @param transportNumber
     * The transportNumber
     */
    public void setTransportNumber(String transportNumber) {
        this.transportNumber = transportNumber;
    }

    /**
     *
     * @return
     * The transportCategory
     */
    public String getTransportCategory() {
        return transportCategory;
    }

    /**
     *
     * @param transportCategory
     * The transportCategory
     */
    public void setTransportCategory(String transportCategory) {
        this.transportCategory = transportCategory;
    }

}

