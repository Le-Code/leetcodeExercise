package com.yaojian.page1;

import com.yaojian.Solution;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Solution46 implements Solution {

    @Override
    public void solution() {
        int[] nums = new int[]{1,2,3,4};
        List<List<Integer>> res = permute(nums);
        for (List<Integer> item : res) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        f(nums, 0, res);
        return res;
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    private void f(int[] nums, int start, List<List<Integer>> res) {
        if (start >= nums.length) {
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                item.add(nums[i]);
            }
            res.add(item);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            f(nums, start + 1, res);
            swap(nums, i, start);
        }
    }

}
