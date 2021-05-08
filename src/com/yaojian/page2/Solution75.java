package com.yaojian.page2;

import com.yaojian.Solution;

import java.util.Arrays;

public class Solution75 implements Solution {

    @Override
    public void solution() {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}
