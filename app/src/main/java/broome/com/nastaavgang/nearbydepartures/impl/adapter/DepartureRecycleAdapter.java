package broome.com.nastaavgang.nearbydepartures.impl.adapter;

import android.broome.com.nastaavgang.R;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.Collections;
import java.util.List;

import broome.com.nastaavgang.nearbydepartures.impl.model.Departure;
import broome.com.nastaavgang.nearbydepartures.impl.view.MyView;

/**
 * Created by robin on 12/08/16.
 */
public class DepartureRecycleAdapter extends RecyclerView.Adapter<DepartureRecycleAdapter.ViewHolder>{
    private static final int UNSELECTED =-1;
    private LayoutInflater inflater;
    private Context context;

    private RecyclerView recyclerView;
    private int selectedItem = UNSELECTED;

    List<Departure> data = Collections.emptyList();

    public DepartureRecycleAdapter(RecyclerView recyclerView,List<Departure> data){
        this.recyclerView = recyclerView;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        this.context = parent.getContext();
        inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_next_station,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.bind(position);

        Departure current = data.get(position);

        holder.number.setTextColor(context.getResources().getColor(current.getPrimaryColor()));
        holder.number.setBackgroundColor(context.getResources().getColor(current.getSecondaryColor()));
        holder.number.setText(current.getNumber());
        holder.destination.setText(current.getToStation());
        holder.timeLeft.setText(current.getTimeLeft());
        //holder.stops.setText("NrOfStops: " +current.getNrOfStops());
        holder.stops.setStops(current.getStops());

    }

    @Override
    public int getItemCount(){
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ExpandableLayout expandableLayout;
        private LinearLayout expandButton;
        private int position;
        TextView number;
        TextView destination;
        TextView timeLeft;
        MyView stops;

        public ViewHolder(View itemView){
            super(itemView);
            expandableLayout = (ExpandableLayout) itemView.findViewById(R.id.expandable_layout);
            expandButton = (LinearLayout) itemView.findViewById(R.id.expand_station);

            expandButton.setOnClickListener(this);

            number = (TextView) itemView.findViewById(R.id.item_next_station_number_txt);
            destination = (TextView) itemView.findViewById(R.id.item_next_station_station_txt);
            timeLeft = (TextView) itemView.findViewById(R.id.item_next_station_timeleft_txt);
            stops = (MyView) itemView.findViewById(R.id.youarehereview);
        }

        public void bind(int position){
            this.position = position;
            expandButton.setSelected(false);
            expandableLayout.collapse(false);


        }
        @Override
        public void onClick(View view){
            ViewHolder holder = (ViewHolder) recyclerView.findViewHolderForAdapterPosition(selectedItem);
            if(holder != null){
                holder.expandButton.setSelected(false);
                holder.expandableLayout.collapse();
            }
            if(position == selectedItem){
                selectedItem = UNSELECTED;
            }else{
                expandButton.setSelected(true);
                expandableLayout.expand();
                selectedItem = position;
            }
        }
    }
}
