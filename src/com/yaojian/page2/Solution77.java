package com.yaojian.page2;

import com.yaojian.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution77 implements Solution {

    @Override
    public void solution() {
        List<List<Integer>> combine = combine(4, 2);
        for (List<Integer> c : combine) {
            System.out.println(Arrays.toString(c.toArray()));
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        f(1, 1, n, k, item, res);
        return res;
    }

    private void f(int start, int idx, int n, int k, List<Integer> item, List<List<Integer>> res) {
        if (idx > k) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i <= n; i++) {
            item.add(i);
            f(i + 1, idx + 1, n, k, item, res);
            item.remove(item.size() - 1);
        }
    }
}
