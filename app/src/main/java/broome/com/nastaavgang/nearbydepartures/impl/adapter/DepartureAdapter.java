package broome.com.nastaavgang.nearbydepartures.impl.adapter;

import android.broome.com.nastaavgang.R;
import broome.com.nastaavgang.nearbydepartures.impl.model.Departure;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by robin on 30/08/15.
 */
public class DepartureAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Departure> objects;

    private class ViewHolder {
        TextView number;
        TextView destination;
        TextView timeLeft;
    }

    public DepartureAdapter(Context context, List<Departure> objects) {
        inflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    public int getCount() {
        return objects.size();
    }

    public Departure getItem(int position) {
        return objects.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_next_station, null);
            holder.number = (TextView) convertView.findViewById(R.id.item_next_station_number_txt);
            holder.destination = (TextView) convertView.findViewById(R.id.item_next_station_station_txt);
            holder.timeLeft = (TextView) convertView.findViewById(R.id.item_next_station_timeleft_txt);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String nr = objects.get(position).getNumber();

        holder.number.setTextColor(convertView.getResources().getColor(objects.get(position).getPrimaryColor()));
        holder.number.setBackgroundColor(convertView.getResources().getColor(objects.get(position).getSecondaryColor()));
        holder.number.setText(nr);
        holder.destination.setText(objects.get(position).getToStation());
        holder.timeLeft.setText(objects.get(position).getTimeLeft());

        return convertView;
    }
    
}
