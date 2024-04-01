package com.appinventiv.cleanarchitecturesample.algorithm.sorting;

public class MergeSort {

    private int[] left = {2,8,15,18,20,25,27,31};
    private int[] right = {5,9,12,17,19,21};

    public void mergeSortAlgo(){
        int[] result = merge(left, right);
        System.out.println("Merge Sort Algorithm Result = " );
        for (int element : result) {
            System.out.println(element);
        }
    }
    private int[] merge(int [] left, int [] right){
        int [] result = new int[left.length + right.length];
        int i=0,j=0,k=0;
        while (i<left.length && j<right.length){
            if (left[i] < right[j])
                result[k++] = left[i++];
            else result[k++] = right[j++];
        }
        for (;i<left.length;i++)
            result[k++] = left[i];
        for (;j<right.length;j++)
            result[k++] = right[j++];

        return result;
    }
}
