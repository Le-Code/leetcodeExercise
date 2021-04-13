package com.yaojian.page1;

import com.yaojian.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Solution39 implements Solution {

    List<List<Integer>> res = new ArrayList<>();

    @Override
    public void solution() {
        int[] candidates = new int[]{2,3,5};

        List<List<Integer>> res = combinationSum(candidates, 8);
        for (List<Integer> item : res) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
        List<Integer> item = new ArrayList<>();
        f(candidates, 0, target, item);
        return res;
    }

    private void f(int[] candidates, int start, int target, List<Integer> item) {
        if (target == 0) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                item.add(candidates[i]);
                f(candidates, i, target - candidates[i], item);
                item.remove(item.size() - 1);
            }
        }
    }
}
