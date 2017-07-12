package com.example.mszhapa.tourguidecopenhagen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by MsZhapa on 27/06/2017.
 */

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new RestaurantsFragment())
                .commit();
    }
}
