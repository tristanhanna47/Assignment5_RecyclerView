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
        final Item Current = mPictureList.get(position);
        holder.pictureItemView.setImageResource(Current.getImageId());

        holder.pictureItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (mcontext, DetailActivity.class);
                //intent.putParcelableArrayListExtra("image", mPictureList);
                mcontext.startActivity(intent);
                //intent.putStringArrayListExtra("Image", mPictureList[holder.getAdapterPosition()]);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mPictureList.size();
    }
}
