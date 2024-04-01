package com.appinventiv.cleanarchitecturesample.algorithm.recursion;

public class PrintNto1 {

    public void printNumberRecursion(){
        int num = 8;
        System.out.println("Print Number using Recursion");
        printNumber(num);
    }
    private void printNumber(int num){
        if (num == 0) return;
        printNumber(num-1);
        System.out.println(num);
    }
}
