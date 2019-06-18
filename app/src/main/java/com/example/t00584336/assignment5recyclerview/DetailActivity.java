package com.example.t00584336.assignment5recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends Activity {

    public static final String MY_SHARED_PREF_NAME = "MY SHARED PREF NAME";
    SharedPreferences sharedPreferences;

    int priority;
    String itemName;
    String imageName;
    TextView priorityview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ImageView mPlace = findViewById(R.id.imageView);
        priorityview = findViewById(R.id.priorityview);

        //Getting item name and image from PictureListAdapter using intents
        Intent myIntent = getIntent();
        imageName = myIntent.getStringExtra(PictureListAdapter.ITEM_IMAGE_KEY);
        itemName = myIntent.getStringExtra(PictureListAdapter.ITEM_NAME_KEY);
        priority = myIntent.getIntExtra(PictureListAdapter.ITEM_PRIORITY_KEY, 0);
        priorityview.setText(itemName + " priority is " + priority);

        sharedPreferences = getSharedPreferences(MY_SHARED_PREF_NAME, MODE_PRIVATE);

        //Sets picture to imageView
        Item item = new Item(itemName,imageName);
        item.setImageId(getResources().getIdentifier(imageName,"drawable", getPackageName()));
        mPlace.setImageResource(item.getImageId());

        Toast.makeText(this, "I am " + itemName, Toast.LENGTH_SHORT).show();

        priority = sharedPreferences.getInt(itemName,priority);
        priorityview.setText(itemName + " priority is " + priority);
    }
    public void addpriority(View view)
    {
        priority = priority + 1;

//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt(itemName, priority);
//        editor.apply();

        priorityview.setText(itemName + " priority is " + priority);

    }

    public void minuspriority(View view)
    {
        priority = priority - 1;

//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt(itemName, priority);
//        editor.apply();

        priorityview.setText(itemName + " priority is " + priority);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(itemName, priority);
        editor.apply();
    }
}
