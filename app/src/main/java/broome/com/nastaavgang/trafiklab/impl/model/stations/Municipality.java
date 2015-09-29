package broome.com.nastaavgang.trafiklab.impl.model.stations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Municipality {

    @SerializedName("@id")
    @Expose
    private String Id;
    @SerializedName("@county_id")
    @Expose
    private String CountyId;
    @SerializedName("#text")
    @Expose
    private String Text;

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

    /**
     *
     * @return
     * The CountyId
     */
    public String getCountyId() {
        return CountyId;
    }

    /**
     *
     * @param CountyId
     * The @county_id
     */
    public void setCountyId(String CountyId) {
        this.CountyId = CountyId;
    }

    /**
     *
     * @return
     * The Text
     */
    public String getText() {
        return Text;
    }

    /**
     *
     * @param Text
     * The #text
     */
    public void setText(String Text) {
        this.Text = Text;
    }

}