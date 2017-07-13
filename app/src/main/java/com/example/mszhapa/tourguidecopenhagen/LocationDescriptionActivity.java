package com.example.mszhapa.tourguidecopenhagen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MsZhapa on 26/06/2017.
 */

public class LocationDescriptionActivity extends AppCompatActivity {

    private String name;
    private String description;
    private String hours;
    private String address;
    private String website;
    private String phone;
    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_description_activity);

        ImageView imageLocation = (ImageView)findViewById(R.id.location_image_extended);
        TextView txtName = (TextView)findViewById(R.id.location_name_extended);
        TextView txtDesc = (TextView)findViewById(R.id.location_description_extended);
        TextView txtHours = (TextView)findViewById(R.id.location_hours);
        TextView txtAddress = (TextView)findViewById(R.id.location_address);
        TextView txtWebsite = (TextView)findViewById(R.id.location_website);
        TextView txtPhone = (TextView)findViewById(R.id.location_phone);

        Bundle location = getIntent().getExtras();

        if (location != null) {

            name = location.getString("name");
            txtName.setText(name);

            image = location.getInt("image");
            imageLocation.setImageResource(image);

            description = location.getString("description");
            txtDesc.setText(description);

            hours = location.getString("hours");
            txtHours.setText(hours);

            address = location.getString("address");
            txtAddress.setText(address);

            website = location.getString("website");
            txtWebsite.setText(website);

            phone = location.getString("phone");
            txtPhone.setText(phone);

            Button backButton = (Button) findViewById(R.id.category_button);

            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), GridActivity.class);
                    startActivity(intent);
                }
            });

        }

    }
}