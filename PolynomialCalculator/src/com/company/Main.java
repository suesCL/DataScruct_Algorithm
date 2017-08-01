package com.company;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {


        //Evaluate quadratic P(x) at position 2
        double[] coeff = {2,12,2};
        Quadratic q1 = new Quadratic(coeff);
        System.out.println("P(x) = 2x^2 + 12x + 2 evaluated at 2 is " + q1.evaluate(2));

        // Add method
        double[] coeff1 = {1,2,3};
        Quadratic q2 = new Quadratic(coeff1);
        System.out.println("R(x) = " + q2);
        System.out.println("P(x) + R(x) is " + q1.add(q2));

        //Find roots of quadratic P(x)
        System.out.println("The roots of P(x) are shown below:");
        System.out.println(q1.roots());


        //Find root of quadratic T(x)
        double[] coeff2 = {2,4,2};
        Quadratic q3 = new Quadratic(coeff2);
        System.out.println("The roots of T(x) are shown below:");
        System.out.println(q3.roots());


        //Find roots of quadratic R(x)
//        System.out.println("The roots of R(x) are shown below:");
//        System.out.println(q2.roots());

        //Compare if P(x) is less than R(x)
        System.out.println(q3.greaterEqual(q3));

    }

}
