package com.example.t00584336.assignment5recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

class Item implements Parcelable {
    private String name;
    private String image;
    private int priority;
    private int imageId;

    public Item() {
        super();
    }

    public Item(String name, String Image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getPriority() {
        return priority;
    }

    public int getImageId() {
        return imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Item(Parcel source) {
        name = source.readString();
        image = source.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(image);
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[0];
        }
    };
}
