package com.appinventiv.cleanarchitecturesample.algorithm.recursion;

import java.util.Arrays;

public class RMergeSort {

    public void mergeSortRecursion(){
        int [] arr = {8,3,4,12,5,6};
        System.out.println("Merge sort with Recursion ");
//        merge(new int[]{3,4,8}, new int[]{5,6,12});
        mergeSort(arr);
    }

    private int[] mergeSort(int[] arr){
        if (arr.length == 1) return arr;
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int i=0,j=0,k=0;
        int[] result = new int[left.length + right.length];
        while(i< left.length && j< right.length) {
            if (left[i] < right[j])
                result[k++] = left[i++];
             else
                result[k++] = right[j++];
        }
        for (;i< left.length;i++)
            result[k++] = left[i];
        for (;j< right.length;j++)
            result[k++] = right[j];
        return result;
    }


}
