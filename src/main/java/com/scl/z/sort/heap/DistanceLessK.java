package com.scl.z.sort.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 排序数小于K
 *
 * @author : scl
 * @date :  2022/8/28
 */
public class DistanceLessK {
    /**
     * 已知一个从小到大几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，
     * 并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。
     */
    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 32, 11, 26, 53, 43};
        sort(arr, 3);
        System.out.println("sort(arr) = " + Arrays.toString(arr));

    }

    private static void sort(int[] arrayInt, int k) {
        //默认小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        int i = 0;
        for (; i < Math.min(arrayInt.length, k); i++) {
            priorityQueue.add(arrayInt[i]);
        }
        for (; i < arrayInt.length; i++) {
            priorityQueue.add(arrayInt[i]);
            arrayInt[i - k] = priorityQueue.poll();
        }
        while (!priorityQueue.isEmpty()) {
            arrayInt[i - k--] = priorityQueue.poll();
        }
    }

}