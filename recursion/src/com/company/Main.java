package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
//        System.out.println("The double digits for 0 is " + doubleDigits(0));
//        System.out.println("The double digits for 348 is " + doubleDigits(348));
//        System.out.println("The double digits for -789 is " + doubleDigits(-789));
//
//        System.out.println("The method call writeSquares for 9 gives: ");
//        writeSquares(9);
//        System.out.println("The method call writeSquares for 1 gives: ");
//        writeSquares(1);
//        System.out.println("The method call writeSquares for 0 gives: ");
//        writeSquares(0);
//
//       System.out.println("The permutations for (6,3) is " + permut(6,3));
//       System.out.println("The permutations for (7,4) is " + permut(7,4));
//
//        System.out.println("The sum of squares for 289 is below: ");
//        printSquares(289);
//        System.out.println("The sum of squares for 1 is below: ");
//        printSquares(1);
//        System.out.println("The sum of squares for 0 is below: ");
//        printSquares(0);
//        System.out.println("The sum of squares for 128 is below: ");
//        printSquares(128);

//        Board b = new Board(8);
//        eightQueen chess = new eightQueen(b);
//        chess.explore(1);
//        System.out.print(chess.getSolutionCount());
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(4);
        q.add(3);
        q.add(9);
        System.out.println(helper(q));
        rearrange(helper(q));
    }

    //problem 4 : doubleDigits
    //precon: integer n
    //postcon: integer
    public static int doubleDigits(int n){
        if(n == 0){
            return n;
        }else if(n > 0){
            int count = 0;
            int m = n;

            while(m > 9){
                count ++;
                 m = m/10;
            }

            int temp = (int)(n - m*pow(10,count));
            m = (int)((m*10 + m)*pow(100,count));
            return m + doubleDigits(temp);
        }else{
            return -1 * doubleDigits(abs(n));
        }
    }

    //6
    public static void writeSquares(int n){
        if(n < 1){
            throw new IllegalArgumentException();
        }else if(n == 1){
            System.out.print(1);
        }else{
            if(n%2 == 0){
                writeSquares(n-1);
                System.out.print(", " + n*n);
            }else{
                System.out.print(n*n + ", ");
                writeSquares(n-1);
            }
        }
    }

    //15 precon: n > r
    public static int permut(int n, int r){
        if(r == 1){
            return n;
        }else{
            return n * permut(n-1,r-1);
        }
    }

    //22 printSquares takes in an positive integer and prints the sum of unique positive integers' square
    //precon: n >= 0
    public static void printSquares(int n ){
        explore( new ArrayList<Integer>(), n, 1);
    }

    private static void explore(ArrayList<Integer> list, int n, int num){
        if( n == 0){
            printHelper(list);

        }else if(n>0){
            for(int i= num; i<= Math.sqrt(n); i++){
                if(n-i*i >= 0){
                    list.add(i);
                    explore(list,n-i*i,i+1);
                    list.remove(list.size()-1);
                }
            }

        }
    }

    //Helper method to print sum of integers'square for printSquare method
    public static void printHelper(ArrayList<Integer> list){

        if(list.size() >= 1) {
            String result = list.get(0) + "^2";
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    result = result + " + " + list.get(i) + "^2";
                }
            }
            System.out.println(result);
        }
    }

    //Queue
    public static void rearrange(Queue<Integer> q){
        q = helper(q);
        System.out.println(helper(q));

    }


    public static Queue<Integer> helper(Queue<Integer> q){
        Stack<Integer> s = new Stack<Integer>();


        int size = q.size();
        for(int i = 0; i < size; i++){
            int n = q.remove();
            if(n % 2 != 0){
                s.push(n);

            }else{
                q.add(n);
            }
        }


        while(!s.isEmpty()){
            q.add(s.pop());
        }

        return q;

    }

    public static void reverseHalf(Queue<Integer> q){
        Stack<Integer> s = new Stack<Integer>();


        int size = q.size();
        int index = 0;
        for(int i = 0; i < size; i++) {
            int n = q.remove();
            if (index % 2 == 0) {
                q.add(n);

            } else {
                s.push(n);

            }
            index++;
        }

        while(!s.isEmpty()){
            int n = q.remove();
            q.add(n);
            q.add(s.pop());
        }

    }


}
