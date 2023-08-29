package com.scl.interview.doublePointer;

import java.util.Arrays;

/**
 * 移动零
 *
 * @author : scl
 * @date :  29/8/2023
 */
public class Easy283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12,0};
        moveZeroes(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }
    /*
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    请注意 ，必须在不复制数组的情况下原地对数组进行操作。

    示例 1:
    输入: nums = [0,1,0,3,12]
    输出: [1,3,12,0,0]
    示例 2:
    输入: nums = [0]
    输出: [0]

    提示:
    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1


    进阶：你能尽量减少完成的操作次数吗？
    */

    public static void moveZeroes(int[] nums) {
        int l = 0;
        int length = nums.length;
        for (int i = 0; l < length && i < length; i++) {
            if (nums[i] == 0) {
                if (l <= i) {
                    l = i + 1;
                }
                while (l < length) {
                    if (nums[l] != 0) {
                        int temp = nums[l];
                        nums[l++] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                    l++;
                }
            }
        }
    }
}