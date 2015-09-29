package broome.com.nastaavgang.trafiklab.impl.model.departure;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class DepartureResponse {

    @Expose
    private Getdeparturesresult getdeparturesresult;

    /**
     *
     * @return
     * The getdeparturesresult
     */
    public Getdeparturesresult getGetdeparturesresult() {
        return getdeparturesresult;
    }

    /**
     *
     * @param getdeparturesresult
     * The getdeparturesresult
     */
    public void setGetdeparturesresult(Getdeparturesresult getdeparturesresult) {
        this.getdeparturesresult = getdeparturesresult;
    }

}