package com.appinventiv.cleanarchitecturesample.algorithm.recursion;

public class ReverseNum {

    public void reverseANum(){
        int num = 473;
        int result = reverseNumber(0, num);
        System.out.println(num+" reverse is = " + result);
    }

    private int reverseNumber(int remainder, int num){
        int div = num/10;
        int rem = num%10;
        if (div == 0) return remainder + rem;
        rem = remainder+rem;
        return reverseNumber(rem*10, div);
    }
}
