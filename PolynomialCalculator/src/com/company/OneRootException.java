package com.company;

/**
 * Created by zsu00 on 4/11/2017.
 */
public class OneRootException extends RuntimeException {
    double b;
    double a;

    //Constructor
    public OneRootException(double b, double a){
        this.b = b;
        this.a = a;
    }

    /**method getRoot for the case there is one root
     * input: double coefficient b and a
     * output: double root
     */
    public double getRoot(){
        return (0-b)/(2*a);
    }

}
