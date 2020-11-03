package com.yaojian.page1;

import com.yaojian.Solution;

public class Solution27 implements Solution {

    @Override
    public void solution() {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int len = removeElement(nums, 2);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int removeElement(int[] nums, int val) {
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[insertPos++] = nums[i];
            }
        }
        return insertPos;
    }
}
