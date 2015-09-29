package broome.com.nastaavgang.trafiklab.impl.model.stations;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Transportlist {


    public Transportlist(Transport ... t){
        transport = Arrays.asList(t);
    }
    @Expose
    private List<Transport> transport = new ArrayList<Transport>();

    /**
     *
     * @return
     * The transport
     */
    public List<Transport> getTransport() {
        return transport;
    }

    /**
     *
     * @param transport
     * The transport
     */
    public void setTransport(List<Transport> transport) {
        this.transport = transport;
    }

}