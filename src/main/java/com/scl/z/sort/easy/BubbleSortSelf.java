package com.scl.z.sort.easy;

import com.scl.z.sort.SortUtil;

import java.util.Arrays;

/**
 * 冒泡排序自写
 *
 * @author : scl
 * @date :  2023/3/5
 */
public class BubbleSortSelf {
    public static void main(String[] args) {
        int[] intArr = SortUtil.makeIntArr(50);
        int[] intArr2 = SortUtil.copyArray(intArr);
        sort(intArr);
        Arrays.sort(intArr2);
        System.out.println(SortUtil.isIntArrEquals(intArr, intArr2) ? "success" : "fail");
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}