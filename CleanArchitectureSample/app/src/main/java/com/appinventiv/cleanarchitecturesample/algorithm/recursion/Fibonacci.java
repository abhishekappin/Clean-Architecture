package com.appinventiv.cleanarchitecturesample.algorithm.recursion;

public class Fibonacci {
    public void fibonacciSeries(){
        int n = 50;
        int result = fibonacci(n);
        System.out.println("The "+n+"th element of Fibonacci Series is "+ result);

    }
    private int fibonacci(int num) {
        if (num<2){
            return num;
        }
        return fibonacci(num-1) + fibonacci(num-2);
    }
}
