package broome.com.nastaavgang.trafiklab2.impl.model.departure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Stop {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("extId")
    @Expose
    private String extId;
    @SerializedName("routeIdx")
    @Expose
    private Integer routeIdx;
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("depTime")
    @Expose
    private String depTime;
    @SerializedName("depDate")
    @Expose
    private String depDate;
    @SerializedName("arrTime")
    @Expose
    private String arrTime;
    @SerializedName("arrDate")
    @Expose
    private String arrDate;

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
     * The routeIdx
     */
    public Integer getRouteIdx() {
        return routeIdx;
    }

    /**
     *
     * @param routeIdx
     * The routeIdx
     */
    public void setRouteIdx(Integer routeIdx) {
        this.routeIdx = routeIdx;
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
     * The depTime
     */
    public String getDepTime() {
        return depTime;
    }

    /**
     *
     * @param depTime
     * The depTime
     */
    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    /**
     *
     * @return
     * The depDate
     */
    public String getDepDate() {
        return depDate;
    }

    /**
     *
     * @param depDate
     * The depDate
     */
    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    /**
     *
     * @return
     * The arrTime
     */
    public String getArrTime() {
        return arrTime;
    }

    /**
     *
     * @param arrTime
     * The arrTime
     */
    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    /**
     *
     * @return
     * The arrDate
     */
    public String getArrDate() {
        return arrDate;
    }

    /**
     *
     * @param arrDate
     * The arrDate
     */
    public void setArrDate(String arrDate) {
        this.arrDate = arrDate;
    }
  }