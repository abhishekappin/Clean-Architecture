package com.appinventiv.cleanarchitecturesample.algorithm.sorting;

public class BubbleSort {

    int[] arr = {3,1,5,4,2};
    public void bubbleSort(){
        bubbleSorting();
    }

    private int[] bubbleSorting(){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
