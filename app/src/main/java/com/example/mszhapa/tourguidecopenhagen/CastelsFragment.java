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

public class CastelsFragment extends Fragment {

    public CastelsFragment() {
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

        locations.add(new Location("Christiansborg Palace", "Christiansborg Palace, located on the tiny island of Slotsholmen, contains the Danish Parliament Folketinget, the Supreme Court, and the Ministry of State.", "Monday-Sunday from 10-17.", "Prins Jørgens Gård, 1468 København K", "www.kongeligeslotte.dk", "+45 3392 6492", R.drawable.christiansborg));
        locations.add(new Location("Kronborg Castle", "Kronborg Castle is probably the most famous Danish castle, known worldwide from Shakespeare's Hamlet.","Tuesday-Sunday, from 11-17.","Kronborg 2C, 3000 Helsingør","www.kongeligeslotte.dk","+45 4921 3078",R.drawable.kronborg));
        locations.add(new Location("Amalienborg Palace", "Amalienborg Palace is a must for anyone with a taste for royal history and the life of Denmark’s royal family who still resides inside the palace.","Monday-Sunday from 10-17.","Amalienborg, 1257 København K","www.kongernessamling.dk","+45 3312 2186",R.drawable.amalienborg));
        locations.add(new Location("Rosenborg Castle", "A royal hermitage set in the King’s Garden in the heart of Copenhagen, Rosenborg Castle features 400 years of splendor, royal art treasures and the Crown Jewels and Royal Regalia.","Monday-Sunday from 10-17.","Øster Voldgade 4A, 1350 København K","www.kongernessamling.dk/rosenborg/","+45 3315 3286", R.drawable.rosenborg));
        locations.add(new Location("Frederiksborg Castle", "Frederiksborg Palace is situated on three islets in the castle lake in Hillerød, north of Copenhagen.","Monday-Sunday from 10-17.","Møntportvejen 10, 3400 Hillerød","www.frederiksborgslot.dk","+45 4826 0439", R.drawable.frederiksborg));


        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.colorPrimary);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
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
                // passing array index & rest of attributes
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