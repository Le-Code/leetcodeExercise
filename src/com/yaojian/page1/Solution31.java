package com.yaojian.page1;

import com.yaojian.Solution;

import java.sql.Struct;
import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 通过次数96,422提交次数278,549
 */
public class Solution31 implements Solution {

    @Override
    public void solution() {
        int[] nums = new int[]{1, 3, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    for (int k = i - 1; k >= j; k--) {
                        nums[k + 1] = nums[k];
                    }
                    nums[j] = tmp;
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
}
