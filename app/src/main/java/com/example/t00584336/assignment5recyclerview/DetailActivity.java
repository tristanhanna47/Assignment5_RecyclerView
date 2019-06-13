package com.example.t00584336.assignment5recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView mPlace = findViewById(R.id.imageView);

        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null){
            mPlace.setImageResource(mBundle.getInt("Image"));
        }
    }
}
