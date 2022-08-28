package com.scl.sort.heap;

import java.util.Arrays;

/**
 * 根据位数桶排序
 * 基数排序
 *
 * @author : scl
 * @date :  2022/8/28
 */
public class RadioSort {
    public static void main(String[] args) {
        int[] arr = {1, 26, 43, 7, 2, 4, 43, 6, 53, 2, 32, 1, 3, 6};
//        int[] arr = {1, 26, 4, 14, 4, 26, 7, 2};
        sort(arr, getMaxDigit(arr));
        System.out.println("sort(arr) = " + Arrays.toString(arr));
//        int[] intArr = SortUtil.makeIntArr(50);
//        int[] intArr2 = SortUtil.copyArray(intArr);
//        sort(intArr);
//        Arrays.sort(intArr2);
//        System.out.println(SortUtil.isIntArrEquals(intArr, intArr2) ? "success" : "fail");
    }


    private static void sort(int[] arrayInt, int maxDigit) {
        int[] bucket = new int[10];
        for (int i = 0; i < maxDigit; i++) {
            for (int index = 0; index < arrayInt.length; index++) {
//                arrayInt[index]
            }
        }
    }

    private static int getMaxDigit(int[] arrayInt) {
        int max = Integer.MIN_VALUE;
        for (int i : arrayInt) {
            max = Math.max(i, max);
        }
        return getDigit(max);
    }

    /**
     * 获取位数
     *
     * @param num
     * @return int
     **/
    public static int getDigit(int num) {
        int digit = 0;
        while (num != 0) {
            num = num / 10;
            digit++;
        }
        return digit;
    }
}