package broome.com.nastaavgang.nearbydepartures.impl.adapter;

import android.broome.com.nastaavgang.R;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

import broome.com.nastaavgang.nearbydepartures.impl.model.Departure;

/**
 * Created by robin on 24/01/16.
 */
public class Departure2Adapter extends ExpandableRecyclerAdapter<DepartureViewHolder,ImageViewHolder> {

    private LayoutInflater mInflator;


    public Departure2Adapter(Context context, @NonNull List<? extends ParentListItem> parentItemList) {
        super(parentItemList);
        mInflator = LayoutInflater.from(context);
    }

    @Override
    public DepartureViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View departureView = mInflator.inflate(R.layout.item_next_station, null);
        return new DepartureViewHolder(departureView);
    }

    @Override
    public ImageViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View imageView = mInflator.inflate(R.layout.list_item_child, childViewGroup, false);
        return new ImageViewHolder(imageView);
    }

    public void onBindParentViewHolder(DepartureViewHolder departureViewHolder, int position, ParentListItem parentListItem) {

    }
    @Override
    public void onBindChildViewHolder(ImageViewHolder imageViewHolder, int position, Object childListItem) {
        Departure departure = (Departure) childListItem;
        imageViewHolder.bind("TEMP");
    }


}
