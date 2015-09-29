package broome.com.nastaavgang.trafiklab.impl.model.stations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Producer {

    @SerializedName("@id")
    @Expose
    private String Id;

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The @id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

}