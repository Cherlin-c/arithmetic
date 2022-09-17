package com.scl.leetbook;

/**
 * 旋转数组的最小数字
 *
 * @author : scl
 * @date :  2022/9/17
 */
public class Offer_11 {

    public static void main(String[] args) {
        int[] numbers = {3, 3, 3};
//        int[] numbers = {2, 3, 6};
        System.out.println("minArray(numbers) = " + minArray(numbers));
        System.out.println("minArray(numbers) = " + minArray2(numbers));
    }
    /*
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    给你一个可能存在重复元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
    请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
    注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。

    示例 1：
    输入：numbers = [3,4,5,1,2]
    输出：1
    示例 2：
    输入：numbers = [2,2,2,0,1]
    输出：0
    提示：
    n == numbers.length
    1 <= n <= 5000
    -5000 <= numbers[i] <= 5000
    numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
     */

    public static int minArray(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }

    //二分
    public static int minArray2(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (numbers[mid] > numbers[j]) {
                i = mid + 1;
            } else if (numbers[mid] < numbers[j]) {
                j = mid;
            } else {
                j--;
            }
        }
        return numbers[j];
    }
}