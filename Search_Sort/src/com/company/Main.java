package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here 4/12/13/15
        Point point1 = new Point(2,4);
        Point point2 = new Point(-2,3);
        Point[] pointArray = {point1, point2, new Point(-1,2)};
        Arrays.sort(pointArray, new PointComparator());
        System.out.println(Arrays.toString(pointArray));
    }
}
