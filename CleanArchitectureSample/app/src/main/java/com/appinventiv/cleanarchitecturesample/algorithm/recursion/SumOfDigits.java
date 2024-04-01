package com.appinventiv.cleanarchitecturesample.algorithm.recursion;

public class SumOfDigits {

    public void sumOfDigit(){
        int num = 1342;
        int result = calculateSumOfDigit(num);
        System.out.println(" Sum of Digits of "+ num + " is equal to " + result);
    }

    private int calculateSumOfDigit(int num){
        int div = num/10;
        int rem = num%10;
        if (div == 0) return rem;
        return rem + calculateSumOfDigit(div);
    }

}
