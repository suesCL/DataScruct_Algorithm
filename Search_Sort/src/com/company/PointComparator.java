package com.company;

import java.awt.*;
import java.util.Comparator;

/**
 * Created by zsu00 on 5/22/2017.
 */
public class PointComparator implements Comparator<Point> {
    public int compare(Point p1, Point p2){
        double dist1 = Math.hypot(p1.getX(), p1.getY());
        double dist2 = Math.hypot(p2.getX(), p2.getY());
        if(dist1 == dist2){
            return 0;
        }else if(dist1 < dist2){
            return -1;
        }else{
            return 1;
        }
    }

}
