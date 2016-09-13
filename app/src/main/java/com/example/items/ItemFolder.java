package com.example.items;


public class ItemFolder extends ItemInfoContainer {

    String color;
    String name;

    public ItemFolder(String name, String color){
        this.setName(name);
        this.setColor(color);
    }

    public String getName() {
        return name;
    }

    public ItemFolder setName(String name){
        this.name = name;
        return this;
    }

    public String getColor() {
        return color;
    }

    public ItemFolder setColor(String color) {
        this.color = color;
        return this;
    }
}
