package com.company;

import java.util.ArrayList;

/**
 * Created by zsu00 on 4/21/2017.
 */
public class MemoCalculator extends Calculator {

    int memCount;
    int compCount;
    ArrayList<Integer> memPrime;
    ArrayList<Integer> memPrimN;
    ArrayList<Integer> memFib;
    ArrayList<Integer> memFibN;

    public MemoCalculator(int seed) {
        super(seed);
        memCount = 0;
        compCount = 0;

        memPrime = new ArrayList<Integer>();
        memPrimN = new ArrayList<Integer>();

        memFib = new ArrayList<Integer>();
        memFibN = new ArrayList<Integer>();
    }





    public int getComputeCount() {
        return compCount;


    }


    public int getMemoCount() {
        return memCount;
    }


    public int prime(int n) {
        //check if n match existing number
        if (memPrimN.contains(n)) {
            memCount++;
            return memPrime.get(memPrimN.indexOf(n));

        } else {
            compCount++;
            int prime = super.prime(n);
            memPrime.add(prime);
            memPrimN.add(n);
            return prime;

        }
    }


   public int fib(int n) {
       //check if n match existing number
       if (memFibN.contains(n)) {
           memCount++;
           return memFib.get(memFibN.indexOf(n));

       } else {
           compCount++;
           int fib = super.fib(n);
           memFib.add(fib);
           memFibN.add(n);
           return fib;

       }
   }

}

