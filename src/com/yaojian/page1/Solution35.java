package com.yaojian.page1;

import com.yaojian.Solution;

import java.util.Arrays;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 */
public class Solution35 implements Solution {
    @Override
    public void solution() {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums, 2));
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int right = nums.length - 1;
        while (start < right) {
            int mid = (start + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int mid = (start + right) / 2;
        return nums[mid] < target ? mid + 1: mid;
    }
}
