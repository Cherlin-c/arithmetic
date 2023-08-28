package com.scl.interview.arr;

/**
 * 递增的三元子序列
 *
 * @author : scl
 * @date :  28/8/2023
 */
public class Md334 {
    public static void main(String[] args) {
        int[] nums = new int[]{20, 100, 10, 12, 5, 13};
        System.out.println("increasingTriplet(nums) = " + increasingTriplet3(nums));

    }
    /*
    给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。

    如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，
    使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。

    示例 1：
    输入：nums = [1,2,3,4,5]
    输出：true
    解释：任何 i < j < k 的三元组都满足题意
    示例 2：
    输入：nums = [5,4,3,2,1]
    输出：false
    解释：不存在满足题意的三元组
    示例 3：
    输入：nums = [2,1,5,0,4,6]
    输出：true
    解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6

    提示：
    1 <= nums.length <= 5 * 105
    -231 <= nums[i] <= 231 - 1

    进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
    */

    public static boolean increasingTriplet(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                if (++index >= 2) return true;
            } else {
                index = 0;
            }
        }
        return false;
    }

    /**
     * 一：双向遍历
     * 时间复杂度：O(n)，其中 n 是数组 nums 的长度。需要遍历数组三次。
     * 空间复杂度：O(n)，其中 n 是数组 nums 的长度。需要创建两个长度为 n 的数组 leftMin 和 rightMax。
     **/
    public static boolean increasingTriplet2(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) {
                return true;
            }
        }
        return false;
    }
    /**
     * 二：贪心
     * 时间复杂度：O(n)，其中 n 是数组 nums 的长度。需要遍历数组一次。
     * 空间复杂度：O(1)。
     *
     **/
    public static boolean increasingTriplet3(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }
}