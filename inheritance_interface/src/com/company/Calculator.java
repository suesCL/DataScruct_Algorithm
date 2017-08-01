package com.company;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by zsu00 on 4/21/2017.
 */
public class Calculator {
        private int seed;
        private Random rand;

        private int primeCallCount;
        private int isPrimeCallCount;

        public Calculator(int seed) {
            this.seed = seed;
            rand = new Random(seed);
        }

        public boolean isPrime(int n) {
            isPrimeCallCount++;
            if (n == 0) {
                return false;
            }
            int prime = 0;
            int index = 0;
            while (prime < n) {
                index++;
                prime = prime(index);
            }
            return (prime == n);
        }

        public int prime(int n) {
            primeCallCount++;
            if(n < 1) {
                throw new IllegalArgumentException();
            }
            Set<Integer> primeSet = new HashSet<Integer>();
            int number = 2;
            while (true) {
                boolean result = true;
                for (int prime : primeSet) {
                    if (number % prime == 0) {
                        result = false;
                        break;
                    }
                }
                if (result) {
                    primeSet.add(number);
                    if (primeSet.size() == n) {
                        return number;
                    }
                }
                number++;
            }
        }

        public int fib(int n) {
            if (n < 1) {
                throw new IllegalArgumentException();
            }
            Set<Integer> primeSet = new HashSet<Integer>();
            int past = 0;
            int current = 1;
            int index = 1;
            while (index < n) {
                int temp = current;
                current += past;
                past = temp;
                index++;
            }
            return current;
        }

        public int rand(int max) {
            if (max < 1) {
                throw new IllegalArgumentException();
            }
            return rand.nextInt(max);
        }

        public int getSeed() {
            return seed;
        }

        public int getPrimeCallCount() {
            return primeCallCount;
        }

        public int getIsPrimeCallCount() {
            return isPrimeCallCount;
        }

}
