package com.yaojian.page1;

import com.yaojian.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 implements Solution {
    List<List<Integer>> res = new ArrayList<>();

    @Override
    public void solution() {
        int[] candidates = new int[]{3,1,3,5,1,1};
        List<List<Integer>> res = combinationSum2(candidates, 8);
        for (List<Integer> item : res) {
            System.out.println(Arrays.toString(item.toArray()));
        }
//1,1,1,3,3,5
//        [[1,1,1,5],[1,1,3,3],[3,5],[3,5]]
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> item = new ArrayList<>();
        f(candidates, 0, target, item);
        return res;
    }

    private void f(int[] candidates, int start, int target, List<Integer> item) {
        if (target == 0) {
            res.add(new ArrayList<>(item));
            return;
        }
        if (start > candidates.length) {
            return;
        }
        if (start == 4 && target == 5) {
            System.out.println();
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                item.add(candidates[i]);
                f(candidates, i + 1, target - candidates[i], item);
                item.remove(item.size() - 1);
                while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) {
                    i++;
                }
            }
        }
    }
}
