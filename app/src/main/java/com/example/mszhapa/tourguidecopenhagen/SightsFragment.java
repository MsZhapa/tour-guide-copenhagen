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

        locations.add(new Location("Nyhavn", "Especially during summer Nyhavn is the perfect place to end a long day. Have dinner at one of the cosy restaurants or do like the locals and buy a beer from a nearby store and enjoy the view.", "Daily between 10 until 22, and even later in the summertime weekends.", "Nyhavn 1-71, 1051 København K", "www.nyhavn.com", "+45 3312 3233", R.drawable.nyhavn));
        locations.add(new Location("Tivoli Gardens", "Tivoli Gardens amusement park in Copenhagen is a must for all visitors to the city, young and old.","Daily between 10-23","Vesterbrogade 3, 1630 København V","www.tivoligardens.com","+45 3315 1001",R.drawable.tivoli));
        locations.add(new Location("Little Mermaid", "At Langelinje Pier you will find one of Copenhagen's most famous tourist attractions: The sculpture of The Little Mermaid.","Daily between 10, until sunset.","Langelinie, 2100 København Ø","www.mermaidsculpture.dk","+45 24279602 (contact if you want to buy one)", R.drawable.mermaid));
        locations.add(new Location("Christiania", "Ready for something different? Then head out to freetown Christiania in the district of Christianshavn.","Daily between 10 until 22, and even later in the summertime.","Prinsessegade, 1422 København K", "nytforum@christiania.org","+45 3295 6507" ,R.drawable.christiania));
        locations.add(new Location("Strøget", "Copenhagen's largest shopping area is centered around Strøget in the heart of the city. Strøget is one of Europe's longest pedestrian streets with a wealth of shops.", "All days 10 - 19, and 23 for restaurants" ,"Frederiksberggade, 1459 København K", "www.kcc.dk","No contact for this location.", R.drawable.stroget));


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