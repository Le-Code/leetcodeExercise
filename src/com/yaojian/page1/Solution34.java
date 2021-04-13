package com.yaojian.page1;

import com.yaojian.Solution;

import java.util.Arrays;

public class Solution34 implements Solution {

    @Override
    public void solution() {
        int[] ints = searchRange(new int[]{2, 2}, 3);
        System.out.println(Arrays.toString(ints));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        int leftPoint = right;
        int rightPoint = left;
        while (left <= leftPoint) {
            int mid_left = (left + leftPoint) / 2;
            if (nums[mid_left] >= target) {
                leftPoint = mid_left - 1;
            } else {
                left = mid_left + 1;
            }
        }
        while (rightPoint <= right) {
            int mid_right = (rightPoint + right) / 2;
            if (nums[mid_right] <= target) {
                rightPoint = mid_right + 1;
            } else {
                right = mid_right - 1;
            }
        }
        if (left < nums.length && nums[left] == target) {
            return new int[]{left, right};
        } else {
            return new int[]{-1, -1};
        }
    }
}
