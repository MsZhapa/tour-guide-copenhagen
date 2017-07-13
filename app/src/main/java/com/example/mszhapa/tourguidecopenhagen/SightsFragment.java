package com.example.mszhapa.tourguidecopenhagen;

/**
 * Created by MsZhapa on 26/06/2017.
 */

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
 * Created by MsZhapa on 25/06/2017.
 */

public class SightsFragment extends Fragment {
    public SightsFragment() {
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

        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.location_name_first_sight), getString(R.string.description_first_sight), getString(R.string.hours_first_sight), getString(R.string.address_first_sight), getString(R.string.website_first_sight), getString(R.string.phone_first_sight), R.drawable.nyhavn));
        locations.add(new Location(getString(R.string.location_name_second_sight), getString(R.string.description_second_sight), getString(R.string.hours_second_sight), getString(R.string.address_second_sight), getString(R.string.website_second_sight), getString(R.string.phone_second_sight), R.drawable.tivoli));
        locations.add(new Location(getString(R.string.location_name_third_sight), getString(R.string.description_third_sight), getString(R.string.hours_third_sight), getString(R.string.address_third_sight), getString(R.string.website_third_sight), getString(R.string.phone_third_sight), R.drawable.mermaid));
        locations.add(new Location(getString(R.string.location_name_forth_sight), getString(R.string.description_forth_sight), getString(R.string.hours_forth_sight), getString(R.string.address_forth_sight), getString(R.string.website_forth_sight), getString(R.string.phone_forth_sight), R.drawable.christiania));
        locations.add(new Location(getString(R.string.location_name_fifth_sight), getString(R.string.description_fifth_sight), getString(R.string.hours_fifth_sight), getString(R.string.address_fifth_sight), getString(R.string.website_fifth_sight), getString(R.string.phone_fifth_sight), R.drawable.stroget));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.colorPrimary);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // location_list.xml layout file.
        final ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Location location = locations.get(position);

                // Sending location object to LocationDescriptionActivity
                Intent i = new Intent(view.getContext(), LocationDescriptionActivity.class);
                // passing array index and the other attributes
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