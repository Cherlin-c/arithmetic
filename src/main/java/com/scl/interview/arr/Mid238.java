package com.scl.interview.arr;

import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 *
 * @author : scl
 * @date :  27/8/2023
 */
public class Mid238 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,1,0,-3,3};
        System.out.println("productExceptSelf(nums) = " + Arrays.toString(productExceptSelf(nums)));
    }
    /*
    给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
    题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

    请不要使用除法，且在 O(n) 时间复杂度内完成此题。

    示例 1:
    输入: nums = [1,2,3,4]
    输出: [24,12,8,6]

    示例 2:
    输入: nums = [-1,1,0,-3,3]
    输出: [0,0,9,0,0]

    提示：
    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
    */

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int[] right = new int[length];
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}