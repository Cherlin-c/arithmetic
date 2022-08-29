package com.scl.sort.heap;

import com.scl.sort.SortUtil;

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
//        int[] arr = {1, 26, 43, 7, 2, 4, 43, 6, 53, 2, 32, 1, 3, 6};
//        int[] arr = {18, 26, 4, 14, 22};
//        sort(arr, getMaxDigit(arr));
//        System.out.println("sort(arr) = " + Arrays.toString(arr));
        int[] intArr = SortUtil.makeIntArr(50);
        int[] intArr2 = SortUtil.copyArray(intArr);
        sort(intArr, getMaxDigit(intArr));
        Arrays.sort(intArr2);
        System.out.println(SortUtil.isIntArrEquals(intArr, intArr2) ? "success" : "fail");
    }


    private static int[] sort(int[] arrayInt, int maxDigit) {
        int length = arrayInt.length;
        for (int i = 0; i < maxDigit; i++) {
            int[] bucket = new int[10];
            int[] temp = new int[length];
            for (int index = 0; index < length; index++) {
                int mod = mod(arrayInt[index], i);
                bucket[mod]++;
            }
            for (int j = 1; j < bucket.length; j++) {
                bucket[j] += bucket[j - 1];
            }
            for (int index = length - 1; index >= 0; index--) {
                int mod = mod(arrayInt[index], i);
                temp[--bucket[mod]] = arrayInt[index];
            }
            for (int t = 0; t < temp.length; t++) {
                arrayInt[t] = temp[t];
            }
        }
        return arrayInt;
    }

    private static int mod(int num, int i) {
        return i > 0 ? num / (10 * i) % 10 : num % 10;
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