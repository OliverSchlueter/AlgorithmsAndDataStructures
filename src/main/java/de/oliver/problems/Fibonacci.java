package de.oliver.problems;

import java.util.HashMap;

public class Fibonacci {

    /*
        Return the n'th fibonacci number

        fib(1) = 1
        fib(2) = 1
        fib(3) = 2
        fib(4) = 3
        fib(5) = 5
        fib(6) = 8
     */


    public static long fib(int n){
        if(n == 1 || n == 2){
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    /*
        Do it with dynamic programming
     */
    public static HashMap<Integer, Long> cache = new HashMap<>();

    public static long dynamicFib(int n){
        if(cache.containsKey(n)){
            return cache.get(n);
        }

        long result;

        if(n == 1 || n == 2){
            result = 1;
        } else {
            result = dynamicFib(n-1) + dynamicFib(n-2);
        }

        cache.put(n, result);

        return result;
    }


    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.print(dynamicFib(i) + ", ");
        }

        System.out.println();

        for (int i = 1; i <= 20; i++) {
            System.out.print(fib(i) + ", ");
        }

        System.out.println();
    }

}
