package broome.com.nastaavgang.trafiklab.impl.model.departure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Mot {

    @SerializedName("@displaytype")
    @Expose
    private String Displaytype;
    @SerializedName("@type")
    @Expose
    private String Type;
    @SerializedName("#text")
    @Expose
    private String Text;

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