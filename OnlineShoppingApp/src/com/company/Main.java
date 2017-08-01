package com.company;

public class Main {

    public static void main(String[] args) {

        Item bowTie = new Item("Bow Tie", 30);
        Item cookie = new Item("cookie",2);
        Item shoe = new Item("shoe", 10);


        ItemOrder order1 = new ItemOrder(bowTie,3);
        ItemOrder order2 = new ItemOrder(bowTie,5);
        ItemOrder order3 = new ItemOrder(bowTie,12);

        ShoppingCart myCart = new ShoppingCart();
        myCart.add(order1);
        myCart.add(order2);
        myCart.add(order3);
        System.out.println("Total cost of my cart is " + myCart.totalPrice());

        myCart.remove(order2);
        myCart.add(new ItemOrder(cookie,6));
        System.out.println("Total cost of my cart is " + myCart.totalPrice());// The cost didn't consider accumulative bulk items for all orders

    }
}
