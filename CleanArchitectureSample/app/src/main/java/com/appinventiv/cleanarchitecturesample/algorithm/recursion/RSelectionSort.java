package com.appinventiv.cleanarchitecturesample.algorithm.recursion;

public class RSelectionSort {

    int[] arr = {3,1,5,4,2};
    public void selectionSort(){
        System.out.println("Selection Sort");
        int[] index = selectionSort(arr.length-1, 0, 0);
        System.out.println(" max index"+index);
    }
    private int[] selectionSort(int row, int col, int max){
        if (row == 0) return arr;
        if (row == col) {
            if (arr[max] > arr[col]){
                int temp = arr[max];
                arr[max] = arr[col];
                arr[col] = temp;
            }
            return selectionSort(--row, 0, 0);
        }
        else {
            if (arr[max] < arr[col])
                max = col;
            return selectionSort(row, ++col, max);
        }
    }
}


