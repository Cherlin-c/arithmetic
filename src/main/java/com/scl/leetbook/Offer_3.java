package com.scl.leetbook;

/**
 * 数组中重复的数字
 *
 * @author : scl
 * @date :  2022/9/12
 */
public class Offer_3 {
    public static void main(String[] args) {
        int[] ints = {6, 3, 0, 0, 2, 5, 3};
//        int[] ints = {0, 3, 1, 3, 2, 5, 6};
        System.out.println("findRepeatNumber(ints) = " + findRepeatNumber2(ints));
    }
    /*
    找出数组中重复的数字。
    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
    示例 1：
    输入：
    [2, 3, 1, 0, 2, 5, 3]
    输出：2 或 3
    限制：
    2 <= n <= 100000
     */

    public static int findRepeatNumber(int[] nums) {
        Integer[] ints = new Integer[nums.length];
        for (int num : nums) {
            if (ints[num] != null) {
                return num;
            }
            ints[num] = num;
        }
        return -1;
    }

    public static int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            int num = nums[i];
            if (i == num) {
                i++;
                continue;
            }
            if (num == nums[num]) {
                return num;
            }
            int temp = nums[num];
            nums[num] = num;
            nums[i] = temp;
        }
        return -1;
    }


}