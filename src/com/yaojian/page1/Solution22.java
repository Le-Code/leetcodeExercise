package com.yaojian.page1;

import com.yaojian.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class Solution22 implements Solution {

    @Override
    public void solution() {
        int n = 3;
        List<String> res_array = generateParenthesis(n);
        System.out.println(Arrays.toString(res_array.toArray()));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(0, 0, res, n, "");
        return res;
    }

    public void generate(int ln, int rn, List<String> res, int n, String tmpS) {
        if (ln > n || rn > n) {
            return;
        }
        if (ln == n && rn == n) {
            res.add(tmpS);
            return;
        }
        if (ln <= rn) {
            generate(ln + 1, rn, res,  n, tmpS + "(");
        } else {
            generate(ln + 1, rn, res, n, tmpS + "(");
            generate(ln, rn + 1, res,  n, tmpS + ")");
        }
    }
}
