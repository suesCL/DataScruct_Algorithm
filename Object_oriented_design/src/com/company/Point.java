package com.company;

/**
 * Created by zsu00 on 4/6/2017.
 */
public class Point {
    int x;
    int y;

    public Point(int initX, int initY){
        x = initX;
        y = initY;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }



    /*It measures manhattan distance between two point objects
      input: Point object
      output: integer distance
     */
    public int manhattanDistance(Point other){
        int xlength = Math.abs(this.x - other.getX());
        int ylength = Math.abs(this.y - other.getY());
        return xlength + ylength;
    }


    /*Determine if this point aligns vertically with given point
      input: Point object
      output: boolean
     */
    public boolean isVertical (Point other){
        if(this.x == other.getX()){
            return true;
        }else{
            return false;
        }
    }

    /*Calculate slope of two points
      input: Point object
      output: double
     */
    public double slope (Point other){
        if(other.getX() == this.x){
            throw new IllegalArgumentException();
        }
        return (double)(other.getY()-this.y)/(other.getX()-this.x);
    }


    /*Determine if this point is collinear with two given points
      input: two Point object
      output: boolean
     */
    public boolean isCollinear(Point p1, Point p2){
        double slope1;
        double slope2;
        double slope3;

        //check x axis of this point and p1
        if(this.x != p1.getX()){
            slope1 = this.slope(p1);
            //check x axis of this point and p2
            if(this.x != p2.getX()){
                slope2 = this.slope(p2);

                if(slope1 != slope2){
                    return false;
                //check x axis of p1 and p2
                }else if(p1.getX() != p2.getX()){
                    slope3 = p2.slope(p1);
                    if(slope3 == slope2){
                        return true;
                    }else{
                        return false;
                    }
                //handle special case of x axis of p1 equals to that of p2
                }else if(p1.getY() == p2.getY()){
                    return true;
                }else{
                    return false;
                }


            //handle special case when x axis of this point equals to p2's
            }else if(this.y == p2.getY()){
                return true;
            }else{
                return false;
            }


         //handle special case when x axis of this point equals to p1
        }else if(this.x == p2.getX()){
            return true;
        }else if(this.y == p1.getY()){
            return true;
        }else{
            return false;
        }
    }




}
