package com.scl.interview.doublePointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * K 和数对的最大数目
 *
 * @author : scl
 * @date :  30/8/2023
 */
public class Mid1679 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2};
        int k = 3;
        System.out.println("maxOperations(nums, k) = " + maxOperations2(nums, k));
    }

    /*
    给你一个整数数组 nums 和一个整数 k 。
    每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
    返回你可以对数组执行的最大操作数。

    示例 1：
    输入：nums = [1,2,3,4], k = 5
    输出：2
    解释：开始时 nums = [1,2,3,4]：
    - 移出 1 和 4 ，之后 nums = [2,3]
    - 移出 2 和 3 ，之后 nums = []
    不再有和为 5 的数对，因此最多执行 2 次操作。
    示例 2：
    输入：nums = [3,1,3,4,3], k = 6
    输出：1
    解释：开始时 nums = [3,1,3,4,3]：
    - 移出前两个 3 ，之后nums = [1,4,3]
    不再有和为 6 的数对，因此最多执行 1 次操作。

    提示：
    1 <= nums.length <= 105
    1 <= nums[i] <= 109
    1 <= k <= 109
    */

    public static int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (num < k) {
                map.merge(num, 1, Integer::sum);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer entryValue = entry.getValue();
            while (entryValue > 0) {
                int v = k - key;
                Integer value = map.get(v);
                if (value != null && value > 0) {
                    if (key != v) {
                        result++;
                        entryValue--;
                        map.put(v, value - 1);
                    } else if (value > 1) {
                        result++;
                        entryValue -= 2;
                        map.put(v, entryValue);
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            map.put(key, entryValue);
        }
        return result;
    }

    /**
     * 先快排，再双指针
     **/
    public static int maxOperations2(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int result = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > k) {
                r--;
            } else if (sum < k) {
                l++;
            } else {
                r--;
                l++;
                result++;
            }
        }
        return result;
    }
}