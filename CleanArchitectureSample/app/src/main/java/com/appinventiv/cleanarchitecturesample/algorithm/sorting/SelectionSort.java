package com.appinventiv.cleanarchitecturesample.algorithm.sorting;

public class SelectionSort {
    int[] arr = {3,1,5,4,2};
    public void selectionSort(){
        arr  = selectionSorting();
        System.out.println("Now the sorted array is "+ arr);
    }
    private int[] selectionSorting(){
        int index = 0;
        for (int i=0;i<arr.length;i++) {
            int max = getMaxElementIndex(0, arr.length-index);
            if (max != arr.length-1-index)
                swapNumbers(max, arr.length-1-index);
            ++index;
        }
        return arr;
    }

    private void swapNumbers(int start, int end) {
        int temp =  arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    private int getMaxElementIndex(int start, int end) {
        int max = start;
        for (int j = start; j < end; j++)
            if (arr[max] < arr[j])
                max = j;
        return max;
    }
}
