
package broome.com.nastaavgang.trafiklab.impl.model.stations;

import android.util.Log;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Example {

    @Expose
    private Stationsinzoneresult stationsinzoneresult;

    /**
     *
     * @return
     * The stationsinzoneresult
     */
    public Stationsinzoneresult getStationsinzoneresult() {
        return stationsinzoneresult;
    }

    /**
     *
     * @param stationsinzoneresult
     * The stationsinzoneresult
     */
    public void setStationsinzoneresult(Stationsinzoneresult stationsinzoneresult) {
        this.stationsinzoneresult = stationsinzoneresult;
        Log.d("TEST","HMMM");
    }

}