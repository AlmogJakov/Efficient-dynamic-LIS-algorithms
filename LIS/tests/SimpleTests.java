package LIS.tests;

import java.util.Arrays;

import LIS.src.LIS;

public class SimpleTests {
    //////////////////////////////////////////////////////////////
    //////////////////////////// Main ////////////////////////////
    //////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        int arr[] = { 16, 5, 8, 6, 1, 10, 5, 2, 15, 3, 2, 4, 1 };
        // int arr[] = {4, 5, 3, 2, 6, 7};
        LIS check = new LIS(arr, 5);
        System.out.println("Num Of LIS: " + check.numOfLIS());
        System.out.println("Len Of LIS: " + check.lengthLIS());
        int[][] a = check.allLIS();
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();

        int arr3[] = { 2, -3, 4, 90, -2, -1, -10, -9, -8, 2, -3, 4, 90, -2, -1, -10, -9, -8 }; // len=3 num=4
        check = new LIS(arr3, 5);
        System.out.println("Len Of LIS: " + check.lengthLIS());
        System.out.println("Num Of LIS: " + check.numOfLIS());
        int[][] aa = check.allLIS();
        for (int i = 0; i < aa.length; i++) {
            System.out.println(Arrays.toString(aa[i]));
        }
        System.out.println();

        // int[] arr5 = {0,0,0,0,0,0,1,1,1,1,2,3,0,0,0,1,1,0,1,1,0,1,0,3};
        int[] arr5 = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        check = new LIS(arr5, 5);
        System.out.println("Len Of LIS: " + check.lengthLIS());
        System.out.println("Num Of LIS: " + check.numOfLIS());
        int[][] ab = check.allLIS();
        for (int i = 0; i < ab.length; i++) {
            System.out.println(Arrays.toString(ab[i]));
        }
        System.out.println();

        int[] arr6 = { 5, 5 };
        check = new LIS(arr6, 2);
        System.out.println("Len Of LIS: " + check.lengthLIS());
        System.out.println("Num Of LIS: " + check.numOfLIS());
        int[][] ac = check.allLIS();
        for (int i = 0; i < ac.length; i++) {
            System.out.println(Arrays.toString(ac[i]));
        }
        System.out.println();

        int[] arr7 = {};
        check = new LIS(arr7, 1);
        System.out.println("Len Of LIS: " + check.lengthLIS());
        System.out.println("Num Of LIS: " + check.numOfLIS());
        int[][] acc = check.allLIS();
        for (int i = 0; i < acc.length; i++) {
            System.out.println(Arrays.toString(acc[i]));
        }
        System.out.println();

        int[] arr8 = { 5 };
        check = new LIS(arr8, -1);
        System.out.println("Len Of LIS: " + check.lengthLIS());
        System.out.println("Num Of LIS: " + check.numOfLIS());
        int[][] acd = check.allLIS();
        for (int i = 0; i < acd.length; i++) {
            System.out.println(Arrays.toString(acd[i]));
        }
        System.out.println();

        int[] arr9 = { 2, 4, 90, -3, -2, -1, -10, -9, -8 };
        check = new LIS(arr9, 5);
        System.out.println("Len Of LIS: " + check.lengthLIS());
        System.out.println("Num Of LIS: " + check.numOfLIS());
        int[][] acde = check.allLIS();
        for (int i = 0; i < acde.length; i++) {
            System.out.println(Arrays.toString(acde[i]));
        }
        System.out.println();

        // No Support For Input With Duplicated Numbers!
        // int[] arr10 = { 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1 };
        // check = new LIS(arr10, 10);
        // System.out.println("Len Of LIS: " + check.lengthLIS());
        // System.out.println("Num Of LIS: " + check.numOfLIS());
        // int[][] acded = check.allLIS();
        // for (int i = 0; i < acded.length; i++) {
        //     System.out.println(Arrays.toString(acded[i]));
        // }
        // System.out.println();

        int[] arr11 = { 0, 4, 12, 2, 10, 6, 14, 9, 13, 11 };
        check = new LIS(arr11, 10);
        System.out.println("Len Of LIS: " + check.lengthLIS());
        System.out.println("Num Of LIS: " + check.numOfLIS());
        int[][] acdee = check.allLIS();
        for (int i = 0; i < acdee.length; i++) {
            System.out.println(Arrays.toString(acdee[i]));
        }
        System.out.println();

        // int arr[] = {1,2,5,7,8,12,15,13,17,0};
        // getLengthByLIS(arr);
        // getNumOfStringsLCS();
        // System.out.println("Number Of Strings: "+numOfStrs+".");
        // int []arr2 = {2,4,90,-3,-2,-1,-10,-9,-8}; // len=3 num=3
        // getLengthByLIS(arr2);
        // getNumOfStringsLCS();
        // System.out.println("Number Of Strings: "+numOfStrs+".");

        // int arr4[] = {2,4,90,-3,-2,-1,-10,-9,-8}; // len=3 num=4
        // check = new LIS(arr4,50);
        // check.getNumOfStringsLCS();
        // check.allLIS();
        //
        // int arr4[] = {1,2,5,7,8,12,15,13,17,0};
        // check = new LIS(arr4,50);
        // check.getNumOfStringsLCS();

        // getLengthByLIS(arr3);
        // getNumOfStringsLCS();
        // System.out.println("Number Of Strings: "+numOfStrs+".");
    }
}
