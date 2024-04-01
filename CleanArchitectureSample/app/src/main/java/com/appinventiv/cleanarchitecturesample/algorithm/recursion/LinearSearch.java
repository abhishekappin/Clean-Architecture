package com.appinventiv.cleanarchitecturesample.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

    int[] numArray = {3,2,1,18,9};
    int [] numberArray = {1,2,3,9,9,8,18};
    public void linearSearch(){
        int number = 18;
        int result = linearSearch(0, number);
        if (result > -1)
            System.out.println("The "+number+" is at index "+ result);
        else    System.out.println("The "+number+" does not exists in the given array");
    }

    private int linearSearch(int index, int number){
        if (numArray[index] == number) return index;
        if (index == numArray.length-1) return -1;
        return linearSearch(++index, number);
    }

    public void allNumberLinearSearch(){
        int number = 9;
        ArrayList<Integer> resultList = new ArrayList<>();
        resultList = allLinearSearch(number, 0, resultList);
        if (resultList.size() > 0)
            System.out.println("The "+number+" is at index "+ resultList);
        else    System.out.println("The "+number+" does not exists in the given array");
    }

    private ArrayList<Integer> allLinearSearch(int number, int index, ArrayList<Integer> resultList){
        if (numberArray[index] == number) resultList.add(index);
        if (index == numberArray.length-1) return resultList;
        return allLinearSearch(number, ++index, resultList);

    }
}
