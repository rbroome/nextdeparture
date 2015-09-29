package broome.com.nastaavgang.trafiklab.impl.model.departure;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Getdeparturesresult {

    @Expose
    private List<Departuresegment> departuresegment = new ArrayList<Departuresegment>();

    /**
     *
     * @return
     * The departuresegment
     */
    public List<Departuresegment> getDeparturesegment() {
        return departuresegment;
    }

    /**
     *
     * @param departuresegment
     * The departuresegment
     */
    public void setDeparturesegment(List<Departuresegment> departuresegment) {
        this.departuresegment = departuresegment;
    }

}