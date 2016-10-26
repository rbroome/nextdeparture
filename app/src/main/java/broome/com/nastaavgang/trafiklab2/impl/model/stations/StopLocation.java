package broome.com.nastaavgang.trafiklab2.impl.model.stations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class StopLocation {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("extId")
    @Expose
    private String extId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("dist")
    @Expose
    private Integer dist;
    @SerializedName("products")
    @Expose
    private Integer products;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The extId
     */
    public String getExtId() {
        return extId;
    }

    /**
     *
     * @param extId
     * The extId
     */
    public void setExtId(String extId) {
        this.extId = extId;
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
     * The lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     *
     * @param lon
     * The lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     *
     * @return
     * The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     * The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     * The weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     * The weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     *
     * @return
     * The dist
     */
    public Integer getDist() {
        return dist;
    }

    /**
     *
     * @param dist
     * The dist
     */
    public void setDist(Integer dist) {
        this.dist = dist;
    }

    /**
     *
     * @return
     * The products
     */
    public Integer getProducts() {
        return products;
    }

    /**
     *
     * @param products
     * The products
     */
    public void setProducts(Integer products) {
        this.products = products;
    }

}