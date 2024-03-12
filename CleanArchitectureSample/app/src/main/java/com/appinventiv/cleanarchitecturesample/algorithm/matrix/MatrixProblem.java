package com.appinventiv.cleanarchitecturesample.algorithm.matrix;

public class MatrixProblem {
    public int[][] myArr = {{2,7,15},{4,9,19},{6,10,24}};

    public void totalNumbersGreaterThan(int num){
        int row = 0, col = myArr.length-1;
        int count = 0;
        while (row <myArr.length && col >=0){
            if (myArr[row][col] >= num) {
                count = count+ myArr.length-row;
                col--;
            } else row++;

        }
        System.out.println("Total "+count+" numbers are less than or equal to "+num);
    }
    public void totalNumbersLessThan(int num){
        int row = 0, col = myArr.length-1;
        int count = 0;
        while (row <myArr.length && col >=0){
            if (myArr[row][col] <= num) {
                count = count+col+1;
                row++;
            } else col--;

        }
        System.out.println("Total "+count+" numbers are less than or equal to "+num);
    }
    public void findNumber(int num){
        int row = 0, col = myArr.length-1;
        while (row < myArr.length && col >= 0){
            if (myArr[row][col] == num) {
                System.out.println("Number " + num + " is present at row= " + row + " col= " + col);
                return;
            }
            if (myArr[row][col] > num) col--;
            else row++;
        }

    }
}
