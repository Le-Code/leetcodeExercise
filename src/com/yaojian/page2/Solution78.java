package com.yaojian.page2;

import com.yaojian.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution78 implements Solution {
    @Override
    public void solution() {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> items : subsets) {
            System.out.println(Arrays.toString(items.toArray()));
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        Stack<Integer> posStack = new Stack<>();
        stack.push(new ArrayList<>());
        posStack.push(0);
        while (!stack.isEmpty()) {
            List<Integer> item = stack.pop();
            res.add(item);
            int pos = posStack.pop();
            for (int i = pos; i < nums.length; i++) {
                List<Integer> it = new ArrayList<>(item);
                it.add(nums[i]);
                stack.push(it);
                posStack.push(i + 1);
            }
        }
        return res;
    }
}
