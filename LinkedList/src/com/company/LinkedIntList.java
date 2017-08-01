package com.company;

import java.util.List;

/**
 * Created by zsu00 on 5/30/2017.
 */
public class LinkedIntList {
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current !=  null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }





    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /////////////////////////////////////////////////////
        /*This is my in class assignment method
        * everything is publishers' code*/


    //#3 isSorted
    //return true if list is in increasing order
    //false if otherwise
    public boolean isSorted(){
        ListNode current = front;
        if(current == null){
            return true;
        }else{
            //loop through each node to check order
            while(current.next != null && current.data <= current.next.data){
                current = current.next;
            }
            //check if reaches the end of list
            if(current.next == null){
                return true;
            }else{
                return false;
            }
        }
    }

    //countDuplicates return the number of duplicates in a sorted list
    public int countDuplicates(){
        int num = 0;
        ListNode current = front;
        //loop through list to find duplicates
        while(current != null && current.next != null){
            //check neighboring nodes
            if(current.data == current.next.data){
                num ++;
            }
            current = current.next;
        }
        return num;
    }


    //removes all occurrences of a given value
    public LinkedIntList removeAll(int val){
        ListNode current = front;
        if(current != null){
            //check if there are occurrences at the beginning
            //remove all occurrences at the beginning
            while(current != null && current.next != null && current.data == val){
                front = front.next;
                current = front;
            }

            //check occurrence when there are one node left
            if(current != null && current.data == val){
                front = null;
            }
            //check from the second node to the second to last node
            while(current.next != null && current.next.next != null){
                //check if next node's value is the value to be removed
                if(current.next.data == val){
                    //remove the next node
                    current.next = current.next.next;
                }else{
                    current = current.next;
                }
            }
            //check the last node if it is the value
            if(current.next != null && current.next.data == val){
                current.next = null;
            }
        }

        return this;
    }

    //removes the values in even-numbered indexes from a list
    //return a new list of those removed values
    public LinkedIntList removeEvens(){
        //special case when it is empty list
        if(front == null){
            return this;
        }

        //create a Linkedlist of removed evens
        LinkedIntList newList = new LinkedIntList();
        newList.front = this.front;
        ListNode list2 = newList.front;

        //modifies the front node of list1
        front = front.next;
        ListNode list1 = front;

        while(list2.next != null && list2.next.next != null
                && list1.next != null && list1.next.next != null ){
            //connect even-numbered nodes for list2
            list2.next = list2.next.next;
            list2 = list2.next;
            //connect odd numbered nodes for lsit1
            list1.next = list1.next.next;
            list1 = list1.next;
        }
        //handle the last nodes for list2
        if(list2.next != null && list2.next.next == null){
            list2.next = null;
        }else if(list2.next != null && list2.next.next != null){
            list2.next = list2.next.next;
        }
        //handle last few nodes for list1
        if(list1.next != null){
            list1.next = null;
        }

        return newList ;
    }

    //reverse the list items
    public LinkedIntList reverse(){
        ListNode current = front;
        ListNode start = front;

        //case when it is empty list
        if(front != null && front.next != null){

            //insert the last node to the front
            while(current.next.next != null){
                current = current.next;
            }

            //set insertion node to be last node
            ListNode insertion = current.next;
            //insertion node point to the starting node of the list
            insertion.next = start;
            //set the current node to null
            current.next = null;

            //front node points to current node
            front = insertion;
            //current point to start
            current = start;


            //reverse the rest of node
            while(start.next != null){

                //move current to point at second to last node
                while(current.next.next != null){
                    current = current.next;
                }
                //point last node to the starting node of the list
                current.next.next = start;

                //insertion node points to current node
                insertion.next = current.next;

                //current node points to null
                current.next = null;

                //update the insertion node to newly inserted node
                insertion = insertion.next;

                //current point to start
                current = start;

            }

        }

        return this;
    }


    //Find second to last node
    public ListNode findSecondLastNode(){
        ListNode current = front;
        //empty list
        if(current == null){
            return null;
        }else if(current.next == null){
            //when there is one item in list
            return null;
        }else {
            while (current.next.next != null) {
                current = current.next;
            }
            return current;
        }
    }

    //find middle point
    public ListNode findMiddle(){
        ListNode middle = front;
        ListNode runner = front;

        if(front == null){
            return null;
        }else if(front.next == null){
            //when there is one item in list
            return middle;
        }else {
            while(runner.next.next != null){
                runner = runner.next.next;
                middle = middle.next;
            }
        }
        return middle;
    }







    ////////////////////////////////////////////////////////
}