package broome.com.nastaavgang.nearbystations.impl.adapter;

import android.broome.com.nastaavgang.R;
import broome.com.nastaavgang.nearbystations.impl.model.Station;
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
public class StationAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Station> objects;

    private class ViewHolder {

        TextView stationName;

    }

    public StationAdapter(Context context, List<Station> objects) {
        inflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    public int getCount() {
        return objects.size();
    }

    public Station getItem(int position) {
        return objects.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_nearby_station, null);
            holder.stationName = (TextView) convertView.findViewById(R.id.item_nearby_station_txt);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.stationName.setText(objects.get(position).getName());
        //holder.timeLeft.setText(objects.get(position).getTimeLeft());

        return convertView;
    }

}
