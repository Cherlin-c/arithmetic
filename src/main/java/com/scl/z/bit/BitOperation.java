package com.scl.z.bit;

import java.util.Arrays;

/**
 * 位运算
 *
 * @author : scl
 * @date :  2022/8/21
 */
public class BitOperation {
    public static void main(String[] args) {
        /*
        位运算
        a^a=0
        0^a=a
         */

        int[] arr1 = {1, 2, 4, 5, 6, 4, 3, 2, 1, 6, 5};
        System.out.println("findOne(arr1) = " + findOne(arr1));
        int[] arr2 = {1, 2, 4, 5, 6, 4, 3, 2, 1, 6};
        System.out.println("findTwo(arr2) = " + Arrays.toString(findTwo(arr2)));
    }

    /**
     * 有一个数组，其中只有一个数出现奇数次，其余出现偶数次，求这个数
     */
    public static int findOne(int[] arrays) {
        int result = 0;
        for (int arr : arrays) {
            result ^= arr;
        }
        return result;
    }

    /**
     * 有一个数组，其中只有两个数出现奇数次，其余出现偶数次，求这个数
     */
    public static int[] findTwo(int[] arrays) {
        int result = 0;
        for (int arr : arrays) {
            result ^= arr;
        }
        //result = a^b
        //取最右边的1
        int i = result & (~result + 1);
        int a = 0;
        for (int array : arrays) {
            if ((array & i) == 0) {
                a ^= array;
            }
        }
        return new int[]{a, result ^ a};
    }
}