package com.company;

import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * Created by zsu00 on 4/18/2017.
 */
public class ShoppingCart {
    private ArrayList<ItemOrder> cart;
    private double totalPrice;

    //Constructor
    public ShoppingCart(){
        cart = new ArrayList<ItemOrder>();
        totalPrice = 0;
    }

    public void add(ItemOrder order){
        cart.add(order);
        totalPrice = totalPrice + order.getCost();
    }

    public void remove(ItemOrder order){
        cart.remove(order);
        totalPrice = totalPrice - order.getCost();
    }

    //check if item is already in shopping cart
    public Boolean find(Item item){
        for(int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getItem() == item) {
                return true;
            }
        }
        return false;
    }

    public double totalPrice(){
        return totalPrice;
    }
}
