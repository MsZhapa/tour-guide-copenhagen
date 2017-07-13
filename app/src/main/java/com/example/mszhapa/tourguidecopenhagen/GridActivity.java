package com.example.mszhapa.tourguidecopenhagen;

/**
 * Created by MsZhapa on 24/06/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class GridActivity extends Activity {

    GridView grid;

    int[] category = {
            R.string.sights,
            R.string.castels,
            R.string.bars,
            R.string.restaurants

    };

    int[] imageId = {
            R.drawable.sights,
            R.drawable.castels,
            R.drawable.bars,
            R.drawable.restaurants,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_activity);

        GridAdapter adapter = new GridAdapter(GridActivity.this, category, imageId);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent i = new Intent(view.getContext(), ListActivity.class);
                i.putExtra("grid_view_position", position);
                startActivity(i);
            }
        });
    }
}
