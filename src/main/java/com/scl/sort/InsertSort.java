package com.scl.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author : scl
 * @date :  2022/8/21
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {1, 26, 43, 7, 2, 4, 43, 6, 53, 2, 32, 1, 3, 6};
//        sort(arr);
//        System.out.println("sort(arr) = " + Arrays.toString(arr));
        int[] intArr = SortUtil.makeIntArr(50);
        int[] intArr2 = SortUtil.copyArray(intArr);
        sort(intArr);
        Arrays.sort(intArr2);
        System.out.println(SortUtil.isIntArrEquals(intArr, intArr2) ? "success" : "fail");
    }

    private static void sort(int[] arrayInt) {
        int length = arrayInt.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (arrayInt[j] < arrayInt[j - 1]) {
                    SortUtil.swap(arrayInt, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }


}