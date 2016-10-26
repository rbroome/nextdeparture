
package broome.com.nastaavgang.trafiklab2.impl.model.departure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Arrival {

    @SerializedName("Product")
    @Expose
    private broome.com.nastaavgang.trafiklab2.impl.model.departure.Product Product;
    @SerializedName("Stops")
    @Expose
    private broome.com.nastaavgang.trafiklab2.impl.model.departure.Stops Stops;
    private String name;
    private String stop;
    private String stopid;
    private String stopExtId;
    private String time;
    private String date;
    private String origin;
    private String transportNumber;
    private String transportCategory;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The product
     */
    public Product getProduct() {
        return Product;
    }

    /**
     *
     * @param product
     * The Product
     */
    public void setProduct(Product product) {
        this.Product = product;
    }

    /**
     *
     * @return
     * The stops
     */
    public Stops getStops() {
        return Stops;
    }

    /**
     *
     * @param stops
     * The Stops
     */
    public void setStops(Stops stops) {
        this.Stops = stops;
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
     * The origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     *
     * @param origin
     * The origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
