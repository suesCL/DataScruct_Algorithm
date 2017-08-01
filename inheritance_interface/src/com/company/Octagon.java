package com.company;

/**
 * Created by zsu00 on 4/14/2017.
 */
public class Octagon implements Shape{
    double sideLen;

    public Octagon(double sideLength){
        sideLen = sideLength;

    }

    public double getArea(){
        return 2*Math.pow(sideLen,2)*(1+Math.sqrt(2));
    }

    public double getPerimeter(){
        return 8*sideLen;
    }



}
