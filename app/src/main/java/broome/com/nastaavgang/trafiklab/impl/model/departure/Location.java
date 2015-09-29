package broome.com.nastaavgang.trafiklab.impl.model.departure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Location {

    @SerializedName("@id")
    @Expose
    private String Id;
    @SerializedName("@x")
    @Expose
    private String X;
    @SerializedName("@y")
    @Expose
    private String Y;
    @Expose
    private String name;

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
     * The X
     */
    public String getX() {
        return X;
    }

    /**
     *
     * @param X
     * The @x
     */
    public void setX(String X) {
        this.X = X;
    }

    /**
     *
     * @return
     * The Y
     */
    public String getY() {
        return Y;
    }

    /**
     *
     * @param Y
     * The @y
     */
    public void setY(String Y) {
        this.Y = Y;
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

}