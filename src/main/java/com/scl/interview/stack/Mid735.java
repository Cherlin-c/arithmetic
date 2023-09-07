package com.scl.interview.stack;

import java.util.Arrays;

/**
 * 行星碰撞
 *
 * @author : scl
 * @date :  6/9/2023
 */
public class Mid735 {

    public static void main(String[] args) {
        int[] asteroids = new int[]{-2, -2, 1, -2};
        System.out.println("asteroidCollision(asteroids) = " + Arrays.toString(asteroidCollision(asteroids)));
    }
    /*
    给定一个整数数组 asteroids，表示在同一行的行星。
    对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。
    每一颗行星以相同的速度移动。找出碰撞后剩下的所有行星。
    碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。

    示例 1：
    输入：asteroids = [5,10,-5]
    输出：[5,10]
    解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
    示例 2：
    输入：asteroids = [8,-8]
    输出：[]
    解释：8 和 -8 碰撞后，两者都发生爆炸。
    示例 3：
    输入：asteroids = [10,2,-5]
    输出：[10]
    解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。

    提示：
    2 <= asteroids.length <= 104
    -1000 <= asteroids[i] <= 1000
    asteroids[i] != 0
    */

    public static int[] asteroidCollision(int[] asteroids) {
        int length = asteroids.length;
        int[] copy = new int[length];
        int index = 0;
        a:
        for (int i = 0; i < length; i++) {
            if (index == 0 || copy[index - 1] < 0) {
                copy[index++] = asteroids[i];
                continue;
            }
            if (asteroids[i] > 0) {
                copy[index++] = asteroids[i];
            } else {
                while (index > 0 && copy[index - 1] > 0) {
                    if (copy[index - 1] > -asteroids[i]) {
                        continue a;
                    } else if (copy[index - 1] == -asteroids[i]) {
                        index--;
                        continue a;
                    } else {
                        index--;
                    }
                }
                copy[index++] = asteroids[i];
            }
        }
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = copy[i];
        }
        return result;
    }
}