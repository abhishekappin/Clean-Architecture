package com.appinventiv.cleanarchitecturesample.algorithm.sorting;

public class QuickSort {
    int[] arr = {10,5,8,9,3,6,15,12,16};

    public void quickSortAlgo(){
        System.out.println("Quick Sort Algorithm");
        int partition = quickSort(1, arr.length-1);
        quickSort(1, partition );
        quickSort(partition+1, arr.length-1 );
    }
    private int quickSort(int low, int high){
        int pivot = 0;
        int i = low, j = high;
        while (i<j) {
            while (arr[pivot] > arr[i]) {
                i++;
            }
            while (arr[pivot] < arr[j]) {
                j--;
            }
            if (i < j)
                swapNumbers(i, j);
        }
        swapNumbers(arr[pivot], arr[j]);
        return j;
    }

    private void swapNumbers(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }
}
