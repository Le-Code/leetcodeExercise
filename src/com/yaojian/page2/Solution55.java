package com.yaojian.page2;

import com.yaojian.Solution;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 */
public class Solution55 implements Solution {
    @Override
    public void solution() {
        int[] nums = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        boolean[] canJump = new boolean[nums.length];
        canJump[nums.length - 1] = true;
        int preOk = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
//            for (int idx = 1; idx <= nums[i]; idx++) {
//                if (canJump[idx + i]) {
//                    canJump[i] = true;
//                    break;
//                }
//            }
            int endStep = i + nums[i];
            if (endStep >= nums.length || endStep >= preOk) {
                canJump[i] = true;
                preOk = i;
            } else {
                canJump[i] = false;
            }
        }
        return canJump[0];
    }
}
