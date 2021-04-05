package com.yaojian.page1;

import com.yaojian.Solution;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 */
public class Solution45 implements Solution {

    @Override
    public void solution() {
        int[] nums = new int[]{2,1};
        System.out.println(jump(nums));
    }

    public int jump(int[] nums) {
        int[] steps = new int[nums.length];
        steps[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int step = nums[i];
            int min = steps[i + 1];
            for (int j = i + 2, idx = 1; idx < step && j < nums.length; idx++, j++) {
                min = Math.min(min, steps[j]);
            }
            steps[i] = min + 1;
        }
        return steps[0];
    }
}
