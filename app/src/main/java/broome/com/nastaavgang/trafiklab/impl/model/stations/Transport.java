package broome.com.nastaavgang.trafiklab.impl.model.stations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Transport {

    @SerializedName("@type")
    @Expose
    private String Type;
    @SerializedName("@displaytype")
    @Expose
    private String Displaytype;

    /**
     *
     * @return
     * The Type
     */
    public String getType() {
        return Type;
    }

    /**
     *
     * @param Type
     * The @type
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     *
     * @return
     * The Displaytype
     */
    public String getDisplaytype() {
        return Displaytype;
    }

    /**
     *
     * @param Displaytype
     * The @displaytype
     */
    public void setDisplaytype(String Displaytype) {
        this.Displaytype = Displaytype;
    }

}