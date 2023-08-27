package com.scl.z.sort.recursion;

import java.util.Arrays;

/**
 * 快排
 *
 * @author : scl
 * @date :  2023/3/5
 */
public class QuickSortSelf {
    public static void main(String[] args) {
        int[] arr = {6, 1, 26, 4, 14, 4, 26, 7, 2};
        sort(arr, 0, arr.length - 1);
        System.out.println("sort(arr) = " + Arrays.toString(arr));

//        int[] intArr = SortUtil.makeIntArr(50);
//        int[] intArr2 = SortUtil.copyArray(intArr);
//        sort(intArr, 0, intArr2.length - 1);
//        Arrays.sort(intArr2);
//        System.out.println(SortUtil.isIntArrEquals(intArr, intArr2) ? "success" : "fail");
    }

    public static int[] sort(int[] arr, int left, int right) {
        if (left == right) {
            return arr;
        }
        int point = arr[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (arr[l] < point) {
                l++;
            } else if (arr[l] > point) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                r--;
            } else {
                l++;
            }
        }
        int temp = arr[l];
        arr[l] = arr[left];
        arr[left] = temp;
        return new int[]{l-1,l+1};
    }
}