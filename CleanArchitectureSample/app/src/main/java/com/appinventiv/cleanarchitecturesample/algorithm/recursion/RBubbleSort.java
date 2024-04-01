package com.appinventiv.cleanarchitecturesample.algorithm.recursion;

public class RBubbleSort {

    int[] arr = {3,1,5,4,2};

    public void RecursionBubbleSort(){
        System.out.println("sorting Bubble sorting");
        bubbleSort(arr.length-1, 0);
        System.out.println("the result is "+arr);
    }

    private void bubbleSort(int row, int col){
        if (row == 0) return;
        if (row == col){
            bubbleSort(--row, 0);
        } else {
            if (arr[col] > arr[col + 1]) {
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            bubbleSort(row, ++col);
        }
    }
}
