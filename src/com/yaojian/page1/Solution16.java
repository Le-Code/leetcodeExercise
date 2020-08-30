package com.yaojian.page1;

import com.yaojian.Solution;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 */
public class Solution16 implements Solution {
    @Override
    public void solution() {
        int[] nums = new int[]{1,2,4,8,16,32,64,128};
        int target = 82;
        System.out.println(threeSumClosest(nums, target));
    }

    /**
     * 双指针
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        int closeSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                int sub = sum - target;
                if (sub > 0) {
                    right--;
                }else {
                    left++;
                }
                int absSub = Math.abs(sub);
                if (minGap > absSub) {
                    minGap = absSub;
                    closeSum = sum;
                }
            }
        }
        return closeSum;
    }
}
