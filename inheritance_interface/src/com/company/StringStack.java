
package com.company;
import java.util.*;


public class StringStack {
    private Stack<String> element;

    private Stack<Boolean> call;
    private Stack<String> recall;

    public StringStack() {
        element = new Stack<String>();
        call = new Stack<Boolean>();
        recall = new Stack<String>();
    }

    public void push(String s) {
        element.push(s);
        call.push(true);
    }

    public String pop() {
        String result = element.pop();
        call.push(false);
        recall.push(result);
        return result;
    }

    public boolean isEmpty() {
        return element.isEmpty();
    }

    public int size() {
        return element.size();
    }

    public void secret_undo() {
        if(call.size() > 0) {
            if(call.pop()) {
                element.pop();
            } else {
                element.push(recall.pop());
            }
        }
    }

    public String toString() {
        return "bottom " + element.toString() + " top";
    }

    public boolean equals(Object o) {
        if(o instanceof StringStack) {
            return this.toString().equals(o.toString());
        }
        return false;
    }



//  REPLACEME

}