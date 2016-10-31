package broome.com.nastaavgang.nearbydepartures.impl.adapter;

import android.broome.com.nastaavgang.R;
import android.os.Build;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import broome.com.nastaavgang.nearbydepartures.impl.model.Departure;

/**
 * Created by robin on 24/01/16.
 */
public class DepartureViewHolder extends ParentViewHolder {
    private static final float INITIAL_POSITION = 0.0f;
    private static final float ROTATED_POSITION = 180f;

    TextView number;
    TextView destination;
    TextView timeLeft;
    View convertView;

    public DepartureViewHolder(View convertView){
        super(convertView);
        this.convertView = convertView;
        number = (TextView) convertView.findViewById(R.id.item_next_station_number_txt);
        destination = (TextView) convertView.findViewById(R.id.item_next_station_station_txt);
        timeLeft = (TextView) convertView.findViewById(R.id.item_next_station_timeleft_txt);
    }
    public void bind(Departure departure){
        String nr = departure.getNumber();

        number.setTextColor(convertView.getResources().getColor(departure.getPrimaryColor()));
        number.setBackgroundColor(convertView.getResources().getColor(departure.getSecondaryColor()));
        number.setText(nr);
        destination.setText(departure.getToStation());
        timeLeft.setText(departure.getTimeLeft());
    }
    @Override
    public void onExpansionToggled(boolean expanded) {
        super.onExpansionToggled(expanded);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            RotateAnimation rotateAnimation;
            if (expanded) { // rotate clockwise
                rotateAnimation = new RotateAnimation(ROTATED_POSITION,
                        INITIAL_POSITION,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
            } else { // rotate counterclockwise
                rotateAnimation = new RotateAnimation(-1 * ROTATED_POSITION,
                        INITIAL_POSITION,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
            }

            rotateAnimation.setDuration(200);
            rotateAnimation.setFillAfter(true);

        }
    }

}
