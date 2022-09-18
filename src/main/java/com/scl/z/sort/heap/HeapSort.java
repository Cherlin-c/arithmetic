package com.scl.z.sort.heap;

import com.scl.z.sort.SortUtil;

import java.util.Arrays;

/**
 * 桶排序
 *
 * @author : scl
 * @date :  2022/8/28
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 26, 43, 7, 2, 4, 43, 6, 53, 2, 32, 1, 3, 6};
//        int[] arr = {1, 26, 4, 14, 4, 26, 7, 2};
        sort(arr);
        System.out.println("sort(arr) = " + Arrays.toString(arr));
//        int[] intArr = SortUtil.makeIntArr(50);
//        int[] intArr2 = SortUtil.copyArray(intArr);
//        sort(intArr);
//        Arrays.sort(intArr2);
//        System.out.println(SortUtil.isIntArrEquals(intArr, intArr2) ? "success" : "fail");
    }

    private static void sort(int[] arrayInt) {
        //O(N)
        for (int i = 0; i < arrayInt.length; i++) {
            //O(logN)
            heapInsert(arrayInt, i);
        }
        int heapSize = arrayInt.length;
        //O(N)
        while (heapSize > 0) {
            //O(1)
            SortUtil.swap2(arrayInt, 0, --heapSize);
            //O(logN)
            heapify(arrayInt, 0, heapSize);
        }
    }

    /**
     * 排成大根堆
     *
     * @param arrayInt 原数组
     * @param index    排序的下标
     * @author scl
     * @date 2022/8/28
     **/
    private static void heapInsert(int[] arrayInt, int index) {
        //往上比
        while (arrayInt[index] > arrayInt[(index - 1) / 2]) {
            //交换
            SortUtil.swap(arrayInt, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arrayInt, int index, int heapSize) {
        int left = index * 2 + 1;
        //有左子节点就一定有子节点
        while (left < heapSize) {
            //比较左孩子还是右孩子大
            int largest = left + 1 < heapSize && arrayInt[left] < arrayInt[left + 1]
                    ? left + 1 : left;
            if (arrayInt[largest] > arrayInt[index]) {
                SortUtil.swap2(arrayInt, largest, index);
                index = largest;
                left = index * 2 + 1;
            } else {
                break;
            }
        }
    }
}