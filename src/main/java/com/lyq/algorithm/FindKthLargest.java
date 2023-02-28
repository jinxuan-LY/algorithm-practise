package com.lyq.algorithm;

/**
 * @author yuanqiang.liao
 * @description 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * [3,2,1,5,6,4] 和 k = 2
 * 输出 5
 * @createTime 2023-02-28 16:59:00
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(arr,2));
    }

    public static int findKthLargest(int[] nums, int k) {
        QuickSortUtil.quickSort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }
}
