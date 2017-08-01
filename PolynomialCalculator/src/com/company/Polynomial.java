package com.company;

/**
 * Created by zsu00 on 4/5/2017.
 */

public class Polynomial {
    //fields
    private double[] coefficients;
    private int[]    power;
    int size;

    //Take inputs of double and integer arrays
    //Precon: inputs are arrays
    public Polynomial(double[] initCoeff, int[] initPower){
        if( initCoeff == null || initPower == null){
            throw new NullPointerException();
        }
        this.coefficients = initCoeff;
        this.power = initPower;
        this.size = initCoeff.length;
    }

    //Access the array of power of polynomial
    public int[] getPower(){
        return this.power;
    }

    //Access the array of coefficient of polynomial
    public double[] getCoefficients(){
        return this.coefficients;
    }

    //Get the length of coefficient or power
    public int getSize(){
        return size;
    }


   /*Implements an add() method that can take doubles or Polynomial objects,
   ** and that returns a new polynomial object that contains the sum.
   **
   ** input: Polynomial object
   ** output: Polynomial object
   */
   public Polynomial add (Polynomial poly) {
       int powerSize = this.size + poly.getSize();
       int coeffSize = this.size + poly.getSize();
       //Create arrays for power and coefficient for new polynomial
       int[] newPower = new int[powerSize];
       double[] newCoeff = new double[coeffSize];

       int k = 0;
       //Iterates through each element of this polynomial
       // to find match in power with new polynomial
       for(int i = 0; i < this.size; i++) {
               boolean match = false;
               int j = 0;

               while (!match && (j < poly.getSize())) {
                   if (this.power[i] == poly.getPower()[j]) {
                       newPower[k] = this.power[i];
                       newCoeff[k] = this.coefficients[i] + poly.getCoefficients()[j];
                       match = true;
                       k++;
                   }else {
                       j++;
                   }
               }

               if(!match){
                   newPower[k] = this.getPower()[i];
                   newCoeff[k] = this.getCoefficients()[i];
                   k++;
               }
       }


       //Iterates through new polynomial to find power terms
       // that aren't matched with this polynomial
       for(int i = 0; i < poly.getSize(); i++){
           boolean match = false;
           int j = 0;
           while(!match && j<this.size){
               if(poly.getPower()[i] != this.power[j]) {
                   match = false;
                   j++;
               }else{
                   match = true;
               }
           }
           if(!match){
               newPower[k] = poly.getPower()[i];
               newCoeff[k] = poly.getCoefficients()[i];
               k++;
           }
       }

       Polynomial newPoly = new Polynomial(newCoeff, newPower);
       return newPoly;
   }




   /*toString method prints string representation of object
   input: none
   output: String
    */
   public String toString (){
       String result = "";
       //Print the first monomial
       if(Math.abs(this.coefficients[0]) > 0.00001){
           //Format decimal coefficient with four  digits
           String coeff = "";
           if(this.coefficients[0] - Math.round(this.coefficients[0]) != 0 ){
               coeff = String.format("%.4f",this.coefficients[0]);
           }else{
               coeff = Double.toString(this.coefficients[0]);
           }

           if(Math.abs(this.coefficients[0]) == 1) {
               if (this.power[0] == 0) {
                   result = coeff;
               } else if (this.power[0] == 1) {
                   result = "x";
               } else {
                   result = "x^" + this.power[0];
               }
           }else{
               if(this.power[0] == 0){
                   result = coeff + "";
               }else if(this.power[0] == 1) {
                   result = coeff + "x";
               }else {
                   result = coeff + "x^" + this.power[0];
               }
           }
       }else{
           result = "0";
       }

       //print the rest monomials
       for(int i = 1; i < this.size; i++){
           if(Math.abs(this.coefficients[i]) > 0.00001){
               //Format decimal coefficient with four  digits
               String coeff = "";
               if(this.coefficients[i] - Math.round(this.coefficients[i]) != 0 ){
                   coeff = String.format("%.4f",this.coefficients[i]);
               }else{
                   coeff = Double.toString(this.coefficients[i]);
               }

               //negative coefficient
               if(this.coefficients[i] < 0){
                   if(this.coefficients[i] == -1){
                       if(this.power[i] == 0){
                           result = result + " " + coeff;
                       }else if(this.power[i] == 1) {
                           result = result + " " + " - " + "x";
                       }else{
                           result = result + " " + " - " + "x^" + this.power[i];
                       }

                   }else{
                       if(this.power[i] == 0){
                           result = result + " " + coeff;
                       }else if(this.power[i] == 1) {
                           result = result + " " + coeff + "x";
                       }else{
                           result = result + " " + coeff + "x^" + this.power[i];
                       }
                   }

               }else{//positive coefficient case
                   if(this.coefficients[i] == 1){
                       if(this.power[i] == 0){
                           result = result + " + " + coeff;
                       }else if(this.power[i] == 1) {
                           result = result + " " + " + " + "x";
                       }else{
                           result = result + " " + " + " + "x^" + this.power[i];
                       }
                   }else{
                       if(this.power[i] == 0){
                           result = result + " + " + coeff;
                       }else if(this.power[i] == 1) {
                           result = result + " + " + coeff + "x";
                       }else{
                           result = result + " + " + coeff + "x^" + this.power[i];
                       }
                   }
               }
               if(Math.abs(this.coefficients[i]) == 1){
               }
           }
       }
       return result;
   }


   /* It evaluates polynomial at specified position
   input: double position
   output: double result
    */
   public double evaluate(double position){
       double result = 0;
       for(int i = 0; i< this.power.length; i++){
           result = result + this.coefficients[i]*Math.pow(position,this.power[i]);
       }
       return result;
   }

}
