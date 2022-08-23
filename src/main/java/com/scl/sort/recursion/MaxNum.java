package com.scl.sort.recursion;

/**
 * 递归获取最大值
 *
 * @author : scl
 * @date :  2022/8/23
 */
public class MaxNum {
    public static void main(String[] args) {
        int[] arr = {1, 26, 43, 7, 2, 4, 43, 6, 53, 2, 32, 1, 3, 6};
        System.out.println("getMaxNum(arr,0,arr.length) = " + getMaxNum(arr, 0, arr.length - 1));
    }

    //arr[L...R]上求最大值
    private static int getMaxNum(int[] arr, int left, int right) {
        //求中点
//        int mid=(left+right)/2;
//        (left+right)/2==left+(right-left)/2;
        if (right == left) {
            return arr[left];
        }
        int mid = left + ((right - left) >> 1);
        int num1 = getMaxNum(arr, left, mid);
        int num2 = getMaxNum(arr, mid + 1, right);
        return Math.max(num1, num2);
    }
}