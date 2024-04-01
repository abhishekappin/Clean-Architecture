package com.appinventiv.cleanarchitecturesample.algorithm.recursion;

import android.util.Log;

public class HalfPyramid {

    public void printHalfPyramid() {
        System.out.println("Pyramid Print");
//        printHalfPyramidPattern(0,4);
        printPyramidPattern(0,0);
    }

    private void printPyramidPattern(int row, int col) {
        if (col == 4) return;
        if (row == col){
            System.out.println("* ");
            printPyramidPattern(0, ++col);
        } else {
            System.out.print("* ");
            printPyramidPattern(++row, col);
        }
    }

    private void printHalfPyramidPattern(int row, int col){
        if (col == 0) return;
        if(row<col) {
            System.out.print("* ");
            printHalfPyramidPattern(++row, col);
        } else {
            System.out.println("");
            printHalfPyramidPattern(0, --col);
        }

    }
}
