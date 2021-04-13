package com.yaojian.page1;

import com.yaojian.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution47 implements Solution {

    @Override
    public void solution() {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> res = permuteUnique(nums);
        for (List<Integer> item : res) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        HashSet<String> collect = new HashSet<>();
        f(nums, 0, res, collect);
        return res;
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    private void f(int[] nums, int start, List<List<Integer>> res, HashSet<String> collect) {
        if (start >= nums.length) {
            List<Integer> item = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                item.add(nums[i]);
                sb.append(nums[i]);
            }
            if (!collect.contains(sb.toString())) {
                res.add(item);
                collect.add(sb.toString());
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            f(nums, start + 1, res, collect);
            swap(nums, i, start);
        }
    }
}
