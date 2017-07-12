package com.example.mszhapa.tourguidecopenhagen;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MsZhapa on 26/06/2017.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    private int mColorResourceId;

    public LocationAdapter(Activity context, ArrayList<Location> locations, int colorResourceId) {


        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, locations);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Get the {@link Location} object located at this position in the list
        Location currentLocation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID location_name
        TextView locationTitleTextView = (TextView) listItemView.findViewById(R.id.location_name);
        // Get the version name from the current Location object and
        // set this text on the name TextView
        locationTitleTextView.setText(currentLocation.getLocationName());

        // Find the TextView in the list_item.xml layout with the ID location_description
        TextView locationDescriptionTextView = (TextView) listItemView.findViewById(R.id.location_description);
        // Get the description from the current Location object and
        // set this text on the number TextView
        locationDescriptionTextView.setText(currentLocation.getLocationDescription());

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentLocation.hasImage()) {
            // Get the image resource ID from the current Location object and
            // set the image to iconView
            iconView.setImageResource(currentLocation.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        } else {
            iconView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.textHolder);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
