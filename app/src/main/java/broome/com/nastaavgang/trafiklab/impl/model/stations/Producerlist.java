package broome.com.nastaavgang.trafiklab.impl.model.stations;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Producerlist {

    public Producerlist(Producer ... p){
        producer = Arrays.asList(p);
    }

    @Expose
    private List<Producer> producer = new ArrayList<Producer>();

    /**
     *
     * @return
     * The producer
     */
    public List<Producer> getProducer() {
        return producer;
    }

    /**
     *
     * @param producer
     * The producer
     */
    public void setProducer(List<Producer> producer) {
        this.producer = producer;
    }

}