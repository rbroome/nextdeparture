package broome.com.nastaavgang.trafiklab2.impl.model.departure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Product {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("num")
    @Expose
    private String num;
    @SerializedName("catCode")
    @Expose
    private String catCode;
    @SerializedName("catOutS")
    @Expose
    private String catOutS;
    @SerializedName("catOutL")
    @Expose
    private String catOutL;
    @SerializedName("operatorCode")
    @Expose
    private String operatorCode;
    @SerializedName("operator")
    @Expose
    private String operator;
    @SerializedName("operatorUrl")
    @Expose
    private String operatorUrl;

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
     * The num
     */
    public String getNum() {
        return num;
    }

    /**
     *
     * @param num
     * The num
     */
    public void setNum(String num) {
        this.num = num;
    }

    /**
     *
     * @return
     * The catCode
     */
    public String getCatCode() {
        return catCode;
    }

    /**
     *
     * @param catCode
     * The catCode
     */
    public void setCatCode(String catCode) {
        this.catCode = catCode;
    }

    /**
     *
     * @return
     * The catOutS
     */
    public String getCatOutS() {
        return catOutS;
    }

    /**
     *
     * @param catOutS
     * The catOutS
     */
    public void setCatOutS(String catOutS) {
        this.catOutS = catOutS;
    }

    /**
     *
     * @return
     * The catOutL
     */
    public String getCatOutL() {
        return catOutL;
    }

    /**
     *
     * @param catOutL
     * The catOutL
     */
    public void setCatOutL(String catOutL) {
        this.catOutL = catOutL;
    }

    /**
     *
     * @return
     * The operatorCode
     */
    public String getOperatorCode() {
        return operatorCode;
    }

    /**
     *
     * @param operatorCode
     * The operatorCode
     */
    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    /**
     *
     * @return
     * The operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     *
     * @param operator
     * The operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     *
     * @return
     * The operatorUrl
     */
    public String getOperatorUrl() {
        return operatorUrl;
    }

    /**
     *
     * @param operatorUrl
     * The operatorUrl
     */
    public void setOperatorUrl(String operatorUrl) {
        this.operatorUrl = operatorUrl;
    }

}