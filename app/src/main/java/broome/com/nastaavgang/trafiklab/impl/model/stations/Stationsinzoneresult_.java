package broome.com.nastaavgang.trafiklab.impl.model.stations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Stationsinzoneresult_ {

    private List<Location> location = new ArrayList<Location>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The location
     */
    public List<Location> getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}