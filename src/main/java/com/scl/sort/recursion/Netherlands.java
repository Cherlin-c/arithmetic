package com.scl.sort.recursion;

import com.scl.sort.SortUtil;

import java.util.Arrays;

/**
 * 荷兰国旗
 *
 * @author : scl
 * @date :  2022/8/23
 */
public class Netherlands {
    public static void main(String[] args) {
        int[] arr = {1, 26, 43, 7, 2, 4, 43, 6, 53, 2, 32, 1, 3, 6};
        int num = 3;
        sort(arr, num);
        System.out.println("sort(arr) = " + Arrays.toString(arr));
        sort3(arr, num);
        System.out.println("sort3(arr) = " + Arrays.toString(arr));
    }

    /*
    小于num的排左边，大于num的排右边
     */

    public static void sort(int[] arr, int num) {
        int data = arr[num];
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < data) {
                if (temp != i) {
                    SortUtil.swap(arr, temp, i);
                }
                temp++;
            }
        }
    }
    /*
    小于num的排左边，等于num的排中间，大于num的排右边
     */

    public static void sort3(int[] arr, int num) {
        int data = arr[num];
        int lowTemp = 0;
        int highTemp = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < data) {
                if (lowTemp != i) {
                    SortUtil.swap(arr, lowTemp, i);
                }
                lowTemp++;
            }
            if (arr[i] > data) {
                if (highTemp != i) {
                    SortUtil.swap(arr, highTemp, i);
                }
                highTemp--;
            }
        }
    }
}