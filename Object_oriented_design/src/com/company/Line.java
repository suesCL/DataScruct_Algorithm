package com.company;

/**
 * Created by zsu00 on 4/6/2017.
 */
public class Line {
    Point p1;
    Point p2;

    //Constructor that takes in point objects
    public Line(Point p1,Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    //Constructor that takes integers of x,y coordinates
    public Line(int x1, int y1, int x2, int y2){
        p1 = new Point(x1,y1);
        p2 = new Point(x2,y2);
    }

    //Get this Line's first endpoint
    public Point getP1(){
        return this.p1;
    }

    //Get this line's second endpoint
    public Point getP2(){
        return this.p2;
    }

    //return a string representation of the line
    public String toString(){
        return "[(" + this.getP1().getX() + ", " + this.getP1().getY() + "), (" +
                this.getP2().getX() + ", " + this.getP2().getY() + ")]";
    }

    //return slope of line
    public double getSlope(){
        return p1.slope(p2);
    }






}
