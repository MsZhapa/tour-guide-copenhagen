package com.example.mszhapa.tourguidecopenhagen;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.TextView;

/**
 * Created by MsZhapa on 25/06/2017.
 */

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        // Create an adapter that knows which fragment should be shown on each page
        OptionsAdapter adapter = new OptionsAdapter(this, getSupportFragmentManager());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //Set the layout, name, icon and position of tabs
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText(R.string.sights);
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sightsicon, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText(R.string.castels);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.castelsicon, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText(R.string.bars);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.baricon, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFour.setText(R.string.restaurants);
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.restaurantsicon, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);

        //show the exact category selected from previous activity
        int position = 0;
        Bundle category = getIntent().getExtras();
        if(category != null) {
            position = category.getInt("grid_view_position");
        }
        viewPager.setCurrentItem(position);
    }

}