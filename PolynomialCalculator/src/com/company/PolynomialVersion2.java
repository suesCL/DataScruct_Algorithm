package com.company;

/**
 * Created by zsu00 on 4/11/2017.
 */
public class PolynomialVersion2 implements Comparable {
    double[] coeff;

    //constructor
    public PolynomialVersion2(double[] coeff){
        this.coeff = coeff;
    }


    //add method
    public PolynomialVersion2 add (PolynomialVersion2 poly){
        int degP = poly.coeff.length;
        int degthis = this.coeff.length;

        int mindegree = Math.min(degP, degthis);
        int maxdegree = Math.max(degP,degthis);


        double[] newcoeffs = new double[maxdegree];

        //Part one is calculate lower term
        for(int i = 0; i < mindegree; i++){
            newcoeffs[i] = poly.coeff[i] + this.coeff[i];
        }

        //Part two is calculate higher term
        if(degP - degthis > 0) {
            for (int i = mindegree; i < maxdegree; i++) {
                newcoeffs[i] = poly.coeff[i];
            }
        }else{
            for (int i = mindegree; i < maxdegree; i++) {
                newcoeffs[i] = this.coeff[i];
            }
        }

        PolynomialVersion2 newPoly = new PolynomialVersion2(newcoeffs);

        return newPoly;
    }

    //Get polynomial coefficient
    public double[] getCoeff(){
        return this.coeff;
    }

    //Implement interface method Less
    public boolean less(PolynomialVersion2 poly){
        //compare highest power
        if(this.coeff.length < poly.getCoeff().length){
            return true;
        }
        //Same degree, compare coefficient
        int i = this.coeff.length - 1;
        while(i >= 0){
            if(this.coeff[i] < poly.getCoeff()[i]){
                return true;
            }else if(this.coeff[i] > poly.getCoeff()[i]){
                return false;
            }else{
                i--;
            }
        }
        return false;
    }



    //Implement greater method
    public boolean greater(PolynomialVersion2 poly){
        //compare highest power
        if(this.coeff.length > poly.getCoeff().length){
            return true;
        }
        //Same degree, compare coefficient
        int i = this.coeff.length - 1;
        while(i >= 0){
            if(this.coeff[i] > poly.getCoeff()[i]){
                return true;
            }else if(this.coeff[i] < poly.getCoeff()[i]){
                return false;
            }else{
                i--;
            }
        }
        return false;
    }



    //Implement greaterEqual method
    public boolean greaterEqual(PolynomialVersion2 poly){
        //compare highest power
        if(this.coeff.length > poly.getCoeff().length){
            return true;
        }
        //Same degree, compare coefficient
        int i = this.coeff.length - 1;
        int count = 0;
        while(i >= 0){
            if(this.coeff[i] > poly.getCoeff()[i]){
                return true;
            }else if(this.coeff[i] == poly.getCoeff()[i]){
                count ++;
            }else{
                i--;
            }
        }
        //When all coefficients are equal, two polynomial are equal
        if(count == this.coeff.length){
            return true;
        }
        return false;
    }


    //Implement lessEqual method
    public boolean lessEqual(PolynomialVersion2 poly){
        //compare highest power
        if(this.coeff.length < poly.getCoeff().length){
            return true;
        }
        //Same degree, compare coefficient
        int i = this.coeff.length - 1;
        int count = 0;
        while(i >= 0){
            if(this.coeff[i] < poly.getCoeff()[i]){
                return true;
            }else if(this.coeff[i] == poly.getCoeff()[i]){
                count ++;
            }else{
                i--;
            }
        }
        //When all coefficients are equal, two polynomial are equal
        if(count == this.coeff.length){
            return true;
        }
        return false;
    }



    /** It evaluates polynomial at specified position
     * input: double position
     * output: double result
     */
    public double evaluate(double position){
        double result = 0;
        for(int i = 0; i< this.coeff.length; i++){
            result = result + this.coeff[i] * Math.pow(position,i);
        }
        return result;
    }

    /** Print String representation of polynomial
     * output: String
     */
    public String toString(){
        String result = "" + (this.coeff[0]);

        for(int i = 1; i < this.coeff.length; i++){
            result = result + " + " + this.coeff[i] + "x^" + i;
        }

        return result;
    }
}
