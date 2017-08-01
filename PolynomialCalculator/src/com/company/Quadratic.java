package com.company;

import java.util.Arrays;
/**
 * Created by zsu00 on 4/11/2017.
 */
public class Quadratic extends PolynomialVersion2 {
    //Constructor
    public Quadratic(double[] newCoeff){
        super(newCoeff);
    }

    /**Find root method
     * input: None
     * output: double array
     */
     public String roots() {
         double a = coeff[2];
         double b = coeff[1];
         double c = coeff[0];
         double[] roots = new double[2];

         //Java will check b62 - 4ac is not smaller than 0
         double temp = Math.sqrt(Math.pow(b,2) - 4*a*c);
         System.out.println(temp);

         if(temp > 0) {
             roots[0] = (temp - b) / (2 * a);
             roots[1] = (0 - b - temp) / (2 * a);

         }else if(temp == 0) {
             roots[0] = (0 - b) / (2 * a);
             roots[1] = roots[0];
         }else{
             String s = "b^2 - 4ac < 0, there is no root";
             throw new ArithmeticException(s);
         }

         return Arrays.toString(roots);
     }

}
