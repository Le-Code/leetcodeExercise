package com.yaojian.page2;

import com.yaojian.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class Solution90 implements Solution {
    @Override
    public void solution() {
        List<List<Integer>> lists = subsetsWithDup(new int[]{1, 2, 2});
        for (List<Integer> item : lists) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        Arrays.sort(nums);
        f(0, nums, res, item);
        return res;
    }

    public void f(int start, int[] nums, List<List<Integer>> res, List<Integer> item) {
        if (start > nums.length) {
            return;
        } else {
            res.add(new ArrayList<>(item));
        }
        int i = start;
        while (i < nums.length) {
            item.add(nums[i]);
            f(i + 1, nums, res, item);
            item.remove(item.size() - 1);
            while (++i < nums.length && nums[i] == nums[i - 1]);
        }
    }
}
