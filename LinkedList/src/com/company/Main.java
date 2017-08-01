package com.company;



public class Main {

    public static void main(String[] args) {

        //check isSorted output
        LinkedIntList list = new LinkedIntList();
        list.add(1);
        list.add(2);
        list.add(3);
        LinkedIntList list1 = new LinkedIntList();
        list.add(1);
        list.add(0);
        list.add(3);
        LinkedIntList list2 = new LinkedIntList();
//        System.out.println("Is the list [1,0,3] sorted? " + list.isSorted());
//        System.out.println("Is the list [1,2,3] sorted? " + list1.isSorted());
//        System.out.println("Is the list [] sorted? " + list2.isSorted());

        //check countDuplicates
        LinkedIntList list3 = new LinkedIntList();
        list3.add(1);
        list3.add(2);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(4);
        //System.out.println("the number of duplicates are " + list3.countDuplicates());

        //check removeAll
        LinkedIntList list4 = new LinkedIntList();
        list4.add(1);
        list4.add(2);
        list4.add(3);
        list4.add(1);
        list4.add(0);
        list4.add(3);
      //System.out.println("The list is after removeAll " + list4.removeAll(3));

        //check removeEvens
        LinkedIntList list5 = new LinkedIntList();
        list5.add(1);
        list5.add(6);
        list5.add(11);
        list5.add(33);
        list5.add(1);
        list5.add(2);
        LinkedIntList list6 = new LinkedIntList();
        list6.add(1);
        list6.add(6);
        list6.add(11);
        list6.add(33);
        list6.add(1);
//        System.out.println("The list is after removeEvens is " + list5.removeEvens());
//        System.out.println("The original list is after removeEvens is " + list5);
//
//        System.out.println("The list is after removeEvens is " + list6.removeEvens());
//        System.out.println("The original list is after removeEvens is " + list6);

        //check reverse
        System.out.println("The list [1,6,11,33,1] after reverse is " + list6.reverse());


    }
}
