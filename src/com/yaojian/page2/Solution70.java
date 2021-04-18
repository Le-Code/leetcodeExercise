package com.yaojian.page2;

import com.yaojian.Solution;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 */
public class Solution70 implements Solution {
    @Override
    public void solution() {
        System.out.println(climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int step1 = 1;
        int step2 = 2;
        for (int i = 3; i <= n; i++) {
            int res = step1 + step2;
            step1 = step2;
            step2 = res;
        }
        return step2;
    }
}
