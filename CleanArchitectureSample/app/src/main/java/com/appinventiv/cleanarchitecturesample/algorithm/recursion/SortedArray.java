package com.appinventiv.cleanarchitecturesample.algorithm.recursion;

public class SortedArray {

//    int [] numArray = {1,2,4,8,9,12};
    int [] numArray = {1,2,4,8,16, 9,12};
    public void isArraySorted(){
        boolean result = isSortedArray(0);
        System.out.println("The given array is sorted "+result);
    }

    private boolean isSortedArray(int index){
        if (numArray[index] > numArray[index+1])
            return false;
        if (index == numArray.length-2)
            return true;
        return isSortedArray(++index);
    }
}
