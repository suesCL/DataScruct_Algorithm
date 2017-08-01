package com.company;

/**
 * Created by zsu00 on 4/18/2017.
 */

public class ItemOrder {
    private int numOfItem;
    private Item item;

    public ItemOrder(Item item, int quantity){
        this.numOfItem = quantity;
        this.item = item;
    }

    public double getCost(){
        int discountNum = numOfItem/5;
        return numOfItem * item.getPrice() + discountNum * item.getPrice()/2;
    }

    public Item getItem(){
        return item;
    }

}
