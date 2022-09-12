package com.scl.leetbook;

/**
 * 在排序数组中查找数字
 *
 * @author : scl
 * @date :  2022/9/12
 */
public class Offer_53_1 {

    public static void main(String[] args) {
        int[] ints = {5, 7, 7, 8, 8, 10};
        int target = 7;
        System.out.println("search(ints,target) = " + search2(ints, target));
    }
    
    /*
    统计一个数字在排序数组中出现的次数。
    示例 1:
    输入: nums = [5,7,7,8,8,10], target = 8
    输出: 2
    示例2:
    输入: nums = [5,7,7,8,8,10], target = 6
    输出: 0
    提示：
    0 <= nums.length <= 105
    -109<= nums[i]<= 109
    nums是一个非递减数组
    -109<= target<= 109
     */

    public static int search(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        if (tail < 0 || target < nums[head] || target > nums[tail]) {
            return 0;
        }
        while (head <= tail) {
            Boolean isBreak = Boolean.TRUE;
            if (nums[head] < target) {
                head++;
                isBreak = Boolean.FALSE;
            }
            if (nums[tail] > target) {
                tail--;
                isBreak = Boolean.FALSE;
            }
            if (isBreak) {
                break;
            }
        }
        return tail - head + 1;
    }

    public static int search2(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    //    输入: nums = [5,7,7,8,8,10], target = 8
    private static int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}