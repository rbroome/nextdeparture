package broome.com.nastaavgang.nearbydepartures.impl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import broome.com.nastaavgang.nearbydepartures.impl.model.Line;
import broome.com.nastaavgang.nearbydepartures.impl.model.Stop;

/**
 * Custom view drawing the graph between stops.
 * Created by robin on 13/08/16.
 */
public class MyView extends View {
    private Paint paint;
    private Paint black;
    private Paint yellow;
    private Paint blue;
    private Paint text;
    private Context c;
    private Canvas canvas;
    List<Stop> stops;
    List<Rect> circles;
    List<Line> lines;
    Rect selectedCircle;
    Rect busAtStop;
    boolean first;
    private int stopNumber;

    public MyView(Context c){
        this(c,null);
        this.c = c;
    }

    public MyView(Context c, AttributeSet s) {
        super(c, s);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);

        black=new Paint();
        black.setColor(Color.BLACK);
        black.setStrokeWidth(4);

        yellow=new Paint();
        yellow.setColor(Color.YELLOW);
        yellow.setStrokeWidth(4);

        blue=new Paint();
        blue.setColor(Color.GREEN);
        blue.setStrokeWidth(4);

        text=new Paint();
        text.setColor(Color.YELLOW);
        text.setTextSize(48f);
        first = true;
        stops = Collections.emptyList();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {

        int width = 2000;
        int height = 400; // Since 3000 is bottom of last Rect to be drawn added and 50 for padding.
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        drawStops(stops);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        Rect touchpoint = new Rect((int)x,(int)y,(int)x+30,(int)y+30);
        int i = 0;
        for(Rect r : circles) {
            if (Rect.intersects(touchpoint, r)) {
                paint.setColor(Color.BLUE);
                selectedCircle = r;
                stopNumber = i;
                invalidate();
                break;
            } else {
                paint.setColor(Color.RED);
                invalidate();
            }
            i++;
        }
        return super.onTouchEvent(event);
    }

    public void drawStops(List<Stop> stops){
        int startY = 200;
        int oldY = 200;
        int oldX = 25;
        int circleRadius = 40;
        boolean stopIsFound = false;

        canvas.drawRect(417,243,30,30,black);

        if(first) {
            first = false;
            circles = new ArrayList<>();
            lines = new ArrayList<>();
            for (int i = 1; i < stops.size()+1; i++) {
                int rand = (int) ((Math.random() * 100) - 50);
                rand = oldY + rand;
                int newY = rand;
                int newX = 200 * i;
                canvas.setDensity(8);
                Line line = new Line(oldX, oldY, newX, newY, black);
                lines.add(line);
                canvas.drawLine(oldX, oldY, newX, newY, black);
                circles.add(new Rect(oldX - circleRadius, oldY - circleRadius, oldX + circleRadius, oldY + circleRadius));
                canvas.drawCircle(oldX, oldY, circleRadius, paint);

                if(!stopIsFound){
                    stopIsFound = isAtStop(stops.get(i-1));
                    if(stopIsFound) {
                        canvas.drawCircle(oldX, oldY, circleRadius, blue);
                        busAtStop= new Rect(oldX,oldY,oldX+30,oldY+30);
                    }


                }
                oldY = newY;
                oldX = newX;


            }
        }
        else{
            for(int i = 0; i < circles.size();i++){
                Line l = lines.get(i);
                Rect c = circles.get(i);
                canvas.drawLine(l.getStartX(),l.getStartY(),l.getStopX(),l.getStopY(),l.getPaint());
                canvas.drawCircle(c.centerX(),c.centerY(),circleRadius,paint);
            }
            if (selectedCircle != null) {
                canvas.drawText(stops.get(stopNumber).getName(), selectedCircle.centerX() - 30, selectedCircle.centerY() - 60, text);
                canvas.drawCircle(selectedCircle.centerX(),selectedCircle.centerY(),circleRadius,yellow);
            }
            if(busAtStop != null){
                canvas.drawCircle(busAtStop.centerX(),busAtStop.centerY(),circleRadius,blue);
            }
        }
    }
    public void setStops(List<Stop> stops){
        this.stops = stops;
    }

    private boolean isAtStop(Stop s){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
        Calendar now = Calendar.getInstance();
        Calendar stop = Calendar.getInstance();

        try {

            if(s.getArrTime() != null){
                stop.setTime(dateFormat.parse(s.getDate() + " "+s.getArrTime()));
            }
            else {
                stop.setTime(dateFormat.parse(s.getDate() + " " + s.getDepTime()));
            }
        }catch (ParseException e){
            Log.e(this.getClass().getSimpleName(),e.getMessage());

        }
        long nowMS = now.getTimeInMillis();
        long stopMS = stop.getTimeInMillis();
        long diff = nowMS-stopMS;
        return diff < 120000 && diff > -120000;
    }

}
