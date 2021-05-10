package com.yaojian.page2;

import com.yaojian.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution77_2 implements Solution {
    @Override
    public void solution() {
        List<List<Integer>> combine = combine(4, 2);
        for (List<Integer> c : combine) {
            System.out.println(Arrays.toString(c.toArray()));
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 1; i <= n - k + 1; i++) {
            List<Integer> item = new ArrayList<>();
            item.add(i);
            stack.push(item);
        }
        while (!stack.isEmpty()) {
            List<Integer> item = stack.pop();
            if (item.size() == k) {
                res.add(item);
            }
            int t = item.get(item.size() - 1);
            for (int i = t + 1; i <= n; i++) {
                List<Integer> tmp = new ArrayList<>(item);
                tmp.add(i);
                stack.push(tmp);
            }
        }
        return res;
    }
}
