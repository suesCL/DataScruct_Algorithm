package com.company;

/**
 * Created by zsu00 on 4/18/2017.
 */
public class Item {
    private  String itemName;
    private double price;

    public Item(String name, double price){
        this.itemName = name;
        this.price = price;
    }

    public String getItemName(){
        return this.itemName;
    }

    public double getPrice(){
        return this.price;
    }

}
