package com.scl.interview.hash;

import java.util.*;

/**
 * 相等行列对
 *
 * @author : scl
 * @date :  5/9/2023
 */
public class Mid2352 {
    public static void main(String[] args) {
        int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        System.out.println("equalPairs(grid) = " + equalPairs_2(grid));
    }
    /*
    给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
    如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。

    示例 1：
    输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
    输出：1
    解释：存在一对相等行列对：
    - (第 2 行，第 1 列)：[2,7,7]
    示例 2：
    输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
    输出：3
    解释：存在三对相等行列对：
    - (第 0 行，第 0 列)：[3,1,2,2]
    - (第 2 行, 第 2 列)：[2,4,2,2]
    - (第 3 行, 第 2 列)：[2,4,2,2]

    提示：
    n == grid.length == grid[i].length
    1 <= n <= 200
    1 <= grid[i][j] <= 105
    */

    public static int equalPairs(int[][] grid) {
        int length = grid.length;
        HashMap<Integer, String> map = new HashMap<>(length);
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                temp[j] = grid[j][i];
            }
            String value = map.get(Arrays.hashCode(temp));
            if (value == null) {
                map.put(Arrays.hashCode(temp), "" + i);
            } else {
                map.put(Arrays.hashCode(temp), value + "," + i);
            }
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            int[] nums = grid[i];
            String value = map.get(Arrays.hashCode(nums));
            if (value != null) {
                String[] split = value.split(",");
                for (String s : split) {
                    int y = Integer.parseInt(s);
                    boolean flag = true;
                    for (int j = 0; j < length; j++) {
                        if (nums[j] != grid[j][y]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static int equalPairs_2(int[][] grid) {
        int length = grid.length;
        HashMap<List<Integer>, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                list.add(grid[j][i]);
            }
            map.put(list, map.getOrDefault(list, 0) + 1);
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            int[] nums = grid[i];
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
             list.add(num);
            }
            result += map.getOrDefault(list, 0);

        }
        return result;
    }

    public static int equalPairs2(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> cnt = new HashMap<>();
        for (int[] row : grid) {
            List<Integer> arr = new ArrayList<>();
            for (int num : row) {
                arr.add(num);
            }
            cnt.put(arr, cnt.getOrDefault(arr, 0) + 1);
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(grid[i][j]);
            }
            if (cnt.containsKey(arr)) {
                res += cnt.get(arr);
            }
        }
        return res;
    }

}