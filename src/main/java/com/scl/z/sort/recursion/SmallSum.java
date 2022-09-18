package com.scl.z.sort.recursion;

/**
 * 小和问题
 *
 * @author : scl
 * @date :  2022/8/24
 */
public class SmallSum {
    public static void main(String[] args) {
//        int[] arr = {1, 26, 43, 7, 2, 4, 43, 6, 53, 2, 32, 1, 3, 6};
        //4+1+0+0+0  = 0+1+2+1+1
        int[] arr = {1, 26, 43, 7, 2};
        System.out.println("getSmallSum(arr,0,arr.length-1) = " + getSmallSum(arr, 0, arr.length - 1));
    }

    /**
     * 一个数组中，每一个数的左边比当前数小的数累计起来，叫做这个数组的小和。
     * 一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印所有逆序对。
     **/
    //需要排序+求和
    private static int getSmallSum(int[] arr, int left, int right) {
        if (right == left) {
            return 0;
        }
        //求中点
        int mid = left + ((right - left) >> 1);
        return getSmallSum(arr, left, mid)
                + getSmallSum(arr, mid + 1, right)
                + getSum(arr, left, mid, right);
    }

    private static int getSum(int[] arrayInt, int left, int mid, int right) {
        int i = 0;
        int l = left;
        int r = mid + 1;
        int sum = 0;
        int[] temp = new int[right - left + 1];
        while (l <= mid && r <= right) {
            sum += arrayInt[l] < arrayInt[r] ? (right - r + 1) * arrayInt[l] : 0;
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
        return sum;
    }
}