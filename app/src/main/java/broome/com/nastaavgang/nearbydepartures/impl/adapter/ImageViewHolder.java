package broome.com.nastaavgang.nearbydepartures.impl.adapter;

import android.broome.com.nastaavgang.R;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

/**
 * Created by robin on 24/01/16.
 */
public class ImageViewHolder extends ChildViewHolder {
    private TextView mImageTextView;

    public ImageViewHolder(View itemView) {
        super(itemView);
        // add a temporary textview here to test expand
        mImageTextView = (TextView) itemView.findViewById(R.id.image_textview);
    }

    public void bind(String departureImage) {
        mImageTextView.setText("Random text");
    }

}
