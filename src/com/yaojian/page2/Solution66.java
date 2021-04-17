package com.yaojian.page2;

import com.yaojian.Solution;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 */
public class Solution66 implements Solution {

    @Override
    public void solution() {
        int[] digits = new int[]{0,3,2,1};
        int[] res = plusOne(digits);
        System.out.println(Arrays.toString(res));
    }

    public int[] plusOne(int[] digits) {
        int step = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += step;
            step = digits[i] / 10;
            digits[i] = digits[i] % 10;
            if (step == 0) {
                break;
            }
        }
        int[] res;
        if (step == 1) {
            res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
        } else {
            int pos = 0;
            while (digits[pos++] == 0);
            pos--;
            res = new int[digits.length - pos];
            int idx = 0;
            for (; pos < digits.length; pos++) {
                res[idx++] = digits[pos];
            }
        }
        return res;
    }
}
