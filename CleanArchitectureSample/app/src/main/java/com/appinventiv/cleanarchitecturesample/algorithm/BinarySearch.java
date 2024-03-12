package com.appinventiv.cleanarchitecturesample.algorithm;

public class BinarySearch {

    public int[] binarySearchArr = {3,6,8,12,14,17,25,29,31,36,42,47,53,55,62};

    public void BinarySearchAlgorithm(boolean isIterative){
        int num = 36;
        int index;
        if (isIterative)
            index = iterativeSearch(num);
        else index = recursiveSearch(0, binarySearchArr.length-1, num);
        if (index == -1) System.out.println(num+" doesn't exists in the given array");
        else System.out.println(num+" exists at "+index);}
    private int iterativeSearch(int num){
        int low=0, high= binarySearchArr.length-1;
        int mid;
        while(low <= high){
            mid = (low+high)/2;
            if (binarySearchArr[mid] == num)
                return mid;
            if (binarySearchArr[mid] < num) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
    private int recursiveSearch(int low, int high, int num){
        int mid = (low+high)/2;
        if (low == high){
            if (binarySearchArr[mid] == num) return mid;
            else return -1;
        } else {
            if (binarySearchArr[mid] == num)
                return mid;
            if (binarySearchArr[mid] < num)
                return recursiveSearch(mid + 1, high, num);
            else return recursiveSearch(low, mid - 1, num);
        }
    }
}
