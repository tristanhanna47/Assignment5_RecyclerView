package com.example.t00584336.assignment5recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class PictureListAdapter extends
        RecyclerView.Adapter<PictureListAdapter.PictureViewHolder> {

    public static final String ITEM_IMAGE_KEY = "ITEM_IMAGE_KEY";
    public static final String ITEM_NAME_KEY = "ITEM_NAME_KEY";
    public static final String ITEM_ID_KEY = "0";
    public static final String  ITEM_PRIORITY_KEY = "0";

    private LayoutInflater mInflater;
    private final ArrayList<Item> mPictureList;
    private Context mcontext;

    public PictureListAdapter(Context mcontext,
                           ArrayList<Item> PictureList) {
        mInflater = LayoutInflater.from(mcontext);
        this.mPictureList = PictureList;
        this.mcontext = mcontext;
    }

    class PictureViewHolder extends RecyclerView.ViewHolder{
        public final ImageView pictureItemView;
        final PictureListAdapter adapter;

        public PictureViewHolder (View itemView, PictureListAdapter adapter)
        {
            super(itemView);
            pictureItemView = itemView.findViewById(R.id.picture);
            this.adapter = adapter;
        }
    }

    @NonNull
    @Override
    public PictureListAdapter.PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mItemView = mInflater.inflate(R.layout.picturelist_item,
                parent, false);
        return new PictureViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull final PictureViewHolder holder, final int position) {
        final Item currentItem = mPictureList.get(position);
        holder.pictureItemView.setImageResource(currentItem.getImageId());

        holder.pictureItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (mcontext, DetailActivity.class);
                intent.putExtra(ITEM_IMAGE_KEY, currentItem.getImage());
                intent.putExtra(ITEM_NAME_KEY, currentItem.getName());
                intent.putExtra(ITEM_ID_KEY, currentItem.getImageId());
                intent.putExtra(ITEM_PRIORITY_KEY, currentItem.getPriority());
                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mPictureList.size();
    }
}
