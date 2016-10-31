package broome.com.nastaavgang.nearbydepartures.impl.model;

import android.graphics.Paint;

/**
 * Created by robin on 14/08/16.
 */
public class Line {

    private int startX;
    private int startY;
    private int stopX;
    private int stopY;
    private Paint paint;

    public Line(int startX, int startY, int stopX, int stopY,Paint paint) {
        this.startX = startX;
        this.startY = startY;
        this.stopX = stopX;
        this.stopY = stopY;
        this.paint = paint;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getStopX() {
        return stopX;
    }

    public void setStopX(int stopX) {
        this.stopX = stopX;
    }

    public int getStopY() {
        return stopY;
    }

    public void setStopY(int stopY) {
        this.stopY = stopY;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
