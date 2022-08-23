package com.scl.sort.recursion;

import com.scl.sort.SortUtil;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author : scl
 * @date :  2022/8/23
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {1, 26, 43, 7, 2, 4, 43, 6, 53, 2, 32, 1, 3, 6};
//        sort(arr, 0, arr.length - 1);
//        System.out.println("sort(arr) = " + Arrays.toString(arr));
        int[] intArr = SortUtil.makeIntArr(50);
        int[] intArr2 = SortUtil.copyArray(intArr);
        sort(intArr,0,intArr2.length-1);
        Arrays.sort(intArr2);
        System.out.println(SortUtil.isIntArrEquals(intArr, intArr2) ? "success" : "fail");
    }

    private static void sort(int[] arrayInt, int left, int right) {
        if (left != right) {
            //中点
            int mid = left + ((right - left) >> 1);
            sort(arrayInt, left, mid);
            sort(arrayInt, mid + 1, right);
            merge(arrayInt, left, mid, right);
        }

    }

    private static void merge(int[] arrayInt, int left, int mid, int right) {
        int i = 0;
        int l = left;
        int r = mid + 1;
        int[] temp = new int[right - left + 1];
        while (l <= mid && r <= right) {
            temp[i++] = arrayInt[l] < arrayInt[r] ? arrayInt[l++] : arrayInt[r++];
        }
        while (l <= mid) {
            temp[i++] = arrayInt[l++];
        }
        while (r <= right) {
            temp[i++] = arrayInt[r++];
        }
        for (int j = 0; j < temp.length; j++) {
            arrayInt[left + j] = temp[j];
        }
    }
}