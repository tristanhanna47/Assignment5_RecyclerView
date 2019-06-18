package com.example.t00584336.assignment5recyclerview;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class MainActivity extends Activity {

    private RecyclerView PictureList;
    private PictureListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    SharedPreferences sharedPreferences;

    final ArrayList<Item> mPictureList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PictureList = findViewById(R.id.PictureView);
        layoutManager = new GridLayoutManager(MainActivity.this, 2);
        sharedPreferences = getSharedPreferences(DetailActivity.MY_SHARED_PREF_NAME, MODE_PRIVATE);

        String json = loadJSONFromAsset();

        try{
            JSONObject rootObject = new JSONObject(json);
            JSONArray jsonArray = rootObject.getJSONArray("items");

            for (int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Log.v("potato", "Actual Element Name: " + jsonObject.get("id") + " " + jsonObject.get("name"));

                Item item = new Item (jsonObject.getString("name"), jsonObject.getString("image"));
                item.setPriority(sharedPreferences.getInt(item.getName(), 0));
                item.setImageId(getResources().getIdentifier(jsonObject.getString("image"),"drawable",getPackageName()));

                mPictureList.add(item);
            }
            }

            catch(JSONException e)
            {
                e.printStackTrace();
            }

        Collections.sort(mPictureList);
        adapter = new PictureListAdapter(this, mPictureList);
        PictureList.setAdapter(adapter);
        PictureList.setLayoutManager(layoutManager);
    }

        public String loadJSONFromAsset () {
            String json = null;
            try {
                InputStream is = this.getAssets().open("items.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex)
                {
                    ex.printStackTrace();
                    return null;
                }
                return json;
    }
}