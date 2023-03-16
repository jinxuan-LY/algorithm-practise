package com.lyq.algorithm;

import com.lyq.algorithm.util.PrintUtil;

/**
 * @author yuanqiang.liao
 * @description 快排
 * @createTime 2023-02-28 17:32:00
 */
public class QuickSortUtil {
    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 4};
        quickSort(array, 0, array.length - 1);
        PrintUtil.printArray(array);
    }

    public static void quickSort(int[] array, int start, int end) {
        if (array == null || array.length <= 1 || start >= end) {
            return;
        }

        quickSelect(array, start, end);

        int i = start;
        int j = end;
        int current = array[start];

        while (i < j) {
            while (i < j && array[j] >= current) {
                j--;
            }
            array[i] = array[j];

            while (i < j && array[i] <= current) {
                i++;
            }

            array[j] = array[i];
        }
        array[j] = current;

        quickSort(array, start, j - 1);
        quickSort(array, j + 1, end);
    }

    private static void quickSelect(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[right] < arr[mid]) {
            swap(arr, right, mid);
        }
        // 枢纽值被放在序列头部
        swap(arr, left, mid);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
}
