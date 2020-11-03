package com.yaojian.page1;


import com.yaojian.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution17 implements Solution {

    @Override
    public void solution() {
        List<String> letterCombinations = letterCombinations("23");
        System.out.println(Arrays.toString(letterCombinations.toArray()));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        String[] digitsLabel = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] digitsArr = digits.toCharArray();
        int pos = digitsArr[0] - '0';
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < digitsLabel[pos].length(); i++) {
            stack.push(digitsLabel[pos].charAt(i) + "");
        }
        while (!stack.isEmpty()) {
            String s = stack.pop();
            if (s.length() == digitsArr.length) {
                result.add(s);
                continue;
            }
            pos = digitsArr[s.length()] - '0';
            for (int i = 0; i < digitsLabel[pos].length(); i++) {
                stack.push(s + digitsLabel[pos].charAt(i));
            }
        }
        return result;
    }
}
