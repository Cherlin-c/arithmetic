package com.scl.sort;

import java.util.Random;

/**
 * 测试数据生成工具
 *
 * @author : scl
 * @date :  2022/8/21
 */
public class SortUtil {

    protected static int[] makeIntArr(int size) {
        int[] intArr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            intArr[i] = random.nextInt(size);
        }
        return intArr;
    }

    protected static int[] copyArray(int[] arrSource) {
        int length = arrSource.length;
        int[] arrTarget = new int[length];
        for (int i = 0; i < length; i++) {
            arrTarget[i] = arrSource[i];
        }
        return arrTarget;
    }

    protected static Boolean isIntArrEquals(int[] arr1, int[] arr2) {
        int length = arr2.length;
        if (arr1.length != length) {
            return Boolean.FALSE;
        }
        for (int i = 0; i < length; i++) {
            if (arr1[i] != arr2[i]) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /**
     * 位运算 数组交换位置
     * p^p=0
     * 0^p=p
     *
     * @param arr 原数组
     * @param p   位置1
     * @param q   位置2
     * @date 2022/8/21
     **/
    protected static void swap(int[] arr, int p, int q) {
        arr[p] = arr[p] ^ arr[q];
        arr[q] = arr[p] ^ arr[q];
        arr[p] = arr[p] ^ arr[q];
    }
}