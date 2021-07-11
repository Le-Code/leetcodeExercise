package com.yaojian.page2;

import com.yaojian.Solution;

public class Solution81 implements Solution {
    @Override
    public void solution() {
        int[] nums = new int[]{2,5,6,0,0,1,2};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[l] && nums[mid] == nums[r]) {
                l++;
                r--;
            }else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[nums.length - 1] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
