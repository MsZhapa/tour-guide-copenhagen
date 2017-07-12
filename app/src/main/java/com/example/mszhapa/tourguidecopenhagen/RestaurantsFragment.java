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

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
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

        locations.add(new Location("Cock's and cows", "At Cock's & Cows there is a burger for everyone. There is everything from the traditional cheeseburger to a big burger with pork called 'The Bohemian Pork Rib'.", "Tuesday – Thursday 17.30-24.00Sun – Thur: 11:30 – 21:30, Fri – Sat:  11:30 – 22:30", "Gammel Strand 34, 1202 København K", "www.cocksandcows.dk", "+45 69 69 60 00", R.drawable.cocks));
        locations.add(new Location("The Union Kitchen", "The Union Kitchen is located in Store Strandstræde street near Nyhavn in Copenhagen. Here you will be served breakfast, English \"balls\" and tasteful cocktails in classic surroundings.", "All days from 8 until 17, and midnight in weekends.", "Store Strandstrade 21, 1255 København K", "www.theunionkitchen.dk", "+45 3314 5488", R.drawable.union));
        locations.add(new Location("Nova", "Located in central Copenhagen just off Stroget, Nova is an ideal place for a break on a shoppedag or for a cozy dinner with friends and family.", "Everyday from 11 until midnight.", "Skindergade 34, 1159 København K", "www.restaurantnova.com", "+45 33 11 12 49", R.drawable.nova));
        locations.add(new Location("Nimb Bar'n'Grill", "Nimb Bar'n'Grill Tivoli serves seafood and steakhouse classics with a creative culinary edge.In the middle of Tivoli Gardens you will find Nimb Bar'n'Grill, which, as the name reveals, offers both great steaks as well as alcohol.", "Monday to Saturday, from 17-23.", "Bernstorffsgade 5,1577 København V", "www.bargrill.nimb.dk", "+45 8870 0060", R.drawable.nimb));
        locations.add(new Location("Restaurant Kanalen", "Beautiful, idyllic and with the serenity of old Copenhagen lies Restaurant Kanalen in the house that used to serve as customs office for the area of Christianshavn.", "Monday to Saturday, from 11.30-23.30.", "Wilders Plads 2, 1403 København K", "www.restaurant-kanalen.dk", "+45 3295 1330", R.drawable.kanalen));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.colorPrimary);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // location_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
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