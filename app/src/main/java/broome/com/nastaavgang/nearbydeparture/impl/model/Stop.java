package broome.com.nastaavgang.nearbydeparture.impl.model;

/**
 * Created by robin on 13/08/16.
 */
public class Stop {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getRtDepTime() {
        return rtDepTime;
    }

    public void setRtDepTime(String rtDepTime) {
        this.rtDepTime = rtDepTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    private String name;
    private String depTime;
    private String rtDepTime;
    private String arrTime;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;

}
