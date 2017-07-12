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

        locations.add(new Location("Jazzhus Montmartre", "Legendary venue for live jazz with a program of gigs by famous American & European musicians.", "Tuesday – Thursday 17.30-24.00\n" + "Friday – Saturday 17.30-02.00", "Store Regnegade 19A, 1110 København K", "montmartre@bojesen.dk", "+45 27 90 30 63", R.drawable.jazzhus));
        locations.add(new Location("Blume", "High level innovative cocktails and extraordinary service, combined with intimate sorroundings and a distinct music profile will ensure the remarkable party.", "Fri – Sun, 20.00 – 05.00","Studiestræde 14,1455 Købehavn K", "wwww.blumecph.dk","+45 60 61 71 58",R.drawable.blume));
        locations.add(new Location("Bar7", "Stylish bar for drinks & cocktails in a choice of rooms with comfy designer sofas & funky decor.","All days between 16-4. Closed on Monday." ,"Studiestræde 7, 1455 København K" , "www.bar7.dk","+45 27 77 77 87",R.drawable.bar7));
        locations.add(new Location("Ruby", "Classic & creative modern cocktails in a cool hangout with comfy sofas & an intimate ambience.","Every day, 16-2.","Nybrogade 10, 1203 København K","www.rby.dk","+45 33 93 12 03", R.drawable.ruby));
        locations.add(new Location("Mexibar", "The bar has existed for many years and is known for its festive atmosphere and cheap cocktails.","Monday-Saturday , from 19-3.", "Elmegade 27, 2200 København N","www.mexibar.com","+45 35 37 77 66", R.drawable.mexibar));

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