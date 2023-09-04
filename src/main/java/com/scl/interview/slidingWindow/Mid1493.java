package com.scl.interview.slidingWindow;

/**
 * 删掉一个元素以后全为 1 的最长子数组
 *
 * @author : scl
 * @date :  3/9/2023
 */
public class Mid1493 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1};
        System.out.println("longestSubarray(nums) = " + longestSubarray1(nums));
    }
    /*
    给你一个二进制数组 nums ，你需要从中删掉一个元素。
    请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
    如果不存在这样的子数组，请返回 0 。

    提示 1：
    输入：nums = [1,1,0,1]
    输出：3
    解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。

    示例 2：
    输入：nums = [0,1,1,1,0,1,1,0,1]
    输出：5
    解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。

    示例 3：
    输入：nums = [1,1,1]
    输出：2
    解释：你必须要删除一个元素。

    提示：
    1 <= nums.length <= 105
    nums[i] 要么是 0 要么是 1 。
    */

    public static int longestSubarray(int[] nums) {
        int n = nums.length;

        int[] pre = new int[n];
        int[] suf = new int[n];

        pre[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            pre[i] = nums[i] != 0 ? pre[i - 1] + 1 : 0;
        }

        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            suf[i] = nums[i] != 0 ? suf[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != 0) continue;
            int preSum = i == 0 ? 0 : pre[i - 1];
            int sufSum = i == n - 1 ? 0 : suf[i + 1];
            ans = Math.max(ans, preSum + sufSum);
        }

        return ans;
    }

    public static int longestSubarray1(int[] nums) {
        int ans = 0;
        int p0 = 0, p1 = 0;
        for (int num : nums) {
            if (num == 0) {
                p1 = p0;
                p0 = 0;
            } else {
                ++p0;
                ++p1;
            }
            ans = Math.max(ans, p1);
        }
        if (ans == nums.length) {
            --ans;
        }
        return ans;
    }
}