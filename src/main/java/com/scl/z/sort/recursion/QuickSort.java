package com.scl.z.sort.recursion;

import com.scl.z.sort.SortUtil;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author : scl
 * @date :  2022/8/24
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {1, 26, 43, 7, 2, 4, 43, 6, 53, 2, 32, 1, 3, 6};
        int[] arr = {1, 26, 4, 14, 4, 26, 7, 2};
        sort(arr, 0, arr.length - 1);
        System.out.println("sort(arr) = " + Arrays.toString(arr));
//        int[] intArr = SortUtil.makeIntArr(50);
//        int[] intArr2 = SortUtil.copyArray(intArr);
//        sort(intArr,0,intArr2.length-1);
//        Arrays.sort(intArr2);
//        System.out.println(SortUtil.isIntArrEquals(intArr, intArr2) ? "success" : "fail");
    }

    private static void sort(int[] arrayInt, int left, int right) {
        if (left < right) {
            //随机选中一个数
            double v = Math.random() * (right - left);
            //先换到最后
            SortUtil.swap2(arrayInt, left + (int) v, right);
            int[] partition = partition(arrayInt, left, right);
            sort(arrayInt, left, partition[0] - 1);
            sort(arrayInt, partition[1] + 1, right);
        }

    }

    private static int[] partition(int[] arrayInt, int left, int right) {
        int rightNum = arrayInt[right];
        //区域右边界
        int l = left - 1;
        //区域左边界
        int r = right;
        while (left < r) {
            if (arrayInt[left] < rightNum) {
                SortUtil.swap2(arrayInt, left++, ++l);
            } else if (arrayInt[left] > rightNum) {
                SortUtil.swap2(arrayInt, left, --r);
            } else {
                left++;
            }
        }
        SortUtil.swap2(arrayInt, right, r);
        return new int[]{l + 1, r};
    }

}