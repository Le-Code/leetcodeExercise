package com.yaojian.page2;

import com.yaojian.Solution;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class Solution67 implements Solution {
    @Override
    public void solution() {
        System.out.println(addBinary("100", "010"));
    }

    public String addBinary(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        int aIdx = aArr.length - 1;
        int bIdx = bArr.length - 1;
        int step = 0;
        int[] res = new int[Math.max(aArr.length, bArr.length) + 1];
        int resIdx = res.length - 1;
        while (aIdx >= 0 && bIdx >= 0) {
            int sum = (aArr[aIdx] - '0') + (bArr[bIdx] - '0') + step;
            res[resIdx--] = sum % 2;
            step = sum / 2;
            aIdx--;
            bIdx--;
        }
        while (aIdx >= 0) {
            int sum = aArr[aIdx] - '0' + step;
            res[resIdx--] = sum % 2;
            step = sum / 2;
            aIdx--;
        }
        while (bIdx >= 0) {
            int sum = bArr[bIdx] - '0' + step;
            res[resIdx--] = sum % 2;
            step = sum / 2;
            bIdx--;
        }
        res[resIdx] = step;
        int pos = step == 0 ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        for (; pos < res.length; pos++) {
            sb.append(res[pos]);
        }
        return sb.toString();
    }
}
