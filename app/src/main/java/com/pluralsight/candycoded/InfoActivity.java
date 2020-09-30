package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.net.URI;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***
    public void createMapIntent(View view)
    {
        String uri = "geo:0,0?q=618 E South St Orlando, FL 32801"; // the location of the store
        String mapPackage = "com.google.android.apps.maps"; // make the intent explicit for google maps
        final Uri URI = Uri.parse(uri);

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, URI);
        mapIntent.setPackage(mapPackage);
        if((mapIntent.resolveActivity(getPackageManager()) != null))
        {
            startActivity(mapIntent);
        }
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
    public void createPhoneIntent(View view)
    {
        String telephoneNumber = "tel:0123456789"; //The telephone number used to set the uri in the Intent
        Uri uri = Uri.parse(telephoneNumber); // parse the telephone number to be used as a uri in the intent
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(uri); // add the uri to the intent as data
        startActivity(dialIntent);
    }
}
