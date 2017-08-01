package com.company;

public class Main {

    public static void main(String[] args) {
	    // problem #3, #4, #5, #6, #14, #15, #16
        Point point = new Point(5,7);

        //calculate manhattan distance
        System.out.println("The Manhattan distance of point(1,6) is " +
                point.manhattanDistance(new Point(1,6)));

        //determine if two points are aligned vertically
        System.out.println("Whether point(4,3) and point(5,7) is aligned vertically: " +
                point.isVertical(new Point(4,3)));

        //calculate slope of two points
        System.out.println("The slope between point(4,2) and point(5,7) is " +
                point.slope(new Point(4,2)));


        //determine if three points are collinear
        Point p1 = new Point(2,5);
        Point p2 = new Point(7,4);
        System.out.println("Whether point(2,5) and point(7,4) is collinear: " +
                point.isCollinear(p1,p2));

        //create a line and print it in string
        Line line = new Line(p1,p2);
        System.out.println("The string representation of line that passes " +
                "point(2,5) and point(7,4) is " + line);
        System.out.println("The slope of the above line is " + line.getSlope());

        //create a line using a different constructor
        Line line1 = new Line(2,4,7,4);
        System.out.println("The line that used different constructor is printed as " + line);

    }
}
