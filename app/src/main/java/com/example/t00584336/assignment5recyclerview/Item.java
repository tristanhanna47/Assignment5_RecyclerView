package com.example.t00584336.assignment5recyclerview;

class Item implements Comparable<Item> {
    private String name;
    private String image;
    private int priority;
    private int imageId;

    public Item() {
        super();
    }

    public Item(String name, String image) {
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
    public int compareTo(Item item) {

        if (this.priority == item.getPriority())
        {
            return 0;
        }
        else if (this.priority < item.getPriority())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
