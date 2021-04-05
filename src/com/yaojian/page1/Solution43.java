package com.yaojian.page1;

import com.yaojian.Solution;


/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 */
public class Solution43 implements Solution {

    @Override
    public void solution() {
        System.out.println(multiply("99", "99"));
    }

    public String multiply(String num1, String num2) {
        int[] nums = new int[num1.length() + num2.length()];
        char[] num2Arr = num2.toCharArray();
        char[] num1Arr = num1.toCharArray();
        int mix = 0;
        int numsIdx = 0;
        for (int i = num2Arr.length - 1; i >= 0; i--) {
            int num = num2Arr[i] - '0';
            int tmp = numsIdx;
            for (int j = num1Arr.length - 1; j >= 0; j--) {
                int n = num1Arr[j] - '0';
                int sum = num * n + mix;
                nums[tmp] += sum;
                mix = nums[tmp] / 10;
                nums[tmp++] %= 10;
            }
            if (mix != 0) {
                nums[tmp] += mix;
                mix = 0;
            }
            numsIdx++;
        }
        if (mix != 0) {
            nums[num1.length() + num2.length() - 1] = mix;
        }
        boolean firstZeroFlag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                firstZeroFlag = true;
            }
            if (firstZeroFlag) {
                sb.append(nums[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
