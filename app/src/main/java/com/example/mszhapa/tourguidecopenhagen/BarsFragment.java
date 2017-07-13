package com.example.mszhapa.tourguidecopenhagen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by MsZhapa on 26/06/2017.
 */

public class BarsFragment extends Fragment {

    public BarsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //the array of locations
        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.location_name_first_bar), getString(R.string.description_first_bar), getString(R.string.hours_first_bar), getString(R.string.address_first_bar), getString(R.string.website_first_bar), getString(R.string.phone_first_bar), R.drawable.jazzhus));
        locations.add(new Location(getString(R.string.location_name_second_bar), getString(R.string.description_second_bar), getString(R.string.hours_second_bar), getString(R.string.address_second_bar), getString(R.string.website_second_bar), getString(R.string.phone_second_bar), R.drawable.blume));
        locations.add(new Location(getString(R.string.location_name_third_bar), getString(R.string.description_third_bar), getString(R.string.hours_third_bar), getString(R.string.address_third_bar), getString(R.string.website_third_bar), getString(R.string.phone_third_bar), R.drawable.bar7));
        locations.add(new Location(getString(R.string.location_name_forth_bar), getString(R.string.description_forth_bar), getString(R.string.hours_forth_bar), getString(R.string.address_forth_bar), getString(R.string.website_forth_bar), getString(R.string.phone_forth_bar), R.drawable.ruby));
        locations.add(new Location(getString(R.string.location_name_fifth_bar), getString(R.string.description_fifth_bar), getString(R.string.hours_fifth_bar), getString(R.string.address_fifth_bar), getString(R.string.website_fifth_bar), getString(R.string.phone_fifth_bar), R.drawable.mexibar));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.colorPrimary);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener for the LocationDescriptionActivity, when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Location location = locations.get(position);

                // Sending location object to LocationDescriptionActivity
                Intent i = new Intent(v.getContext(), LocationDescriptionActivity.class);
                // passing array index and rest of attributes
                i.putExtra("id", position);
                i.putExtra("image", location.getImageResourceId());
                i.putExtra("name", location.getLocationName());
                i.putExtra("description", location.getLocationDescription());
                i.putExtra("hours", location.getLocationHours());
                i.putExtra("address", location.getLocationAddress());
                i.putExtra("website", location.getLocationWebsite());
                i.putExtra("phone", location.getLocationPhone());

                startActivity(i);
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}