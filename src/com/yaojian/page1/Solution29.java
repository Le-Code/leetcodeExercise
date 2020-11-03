package com.yaojian.page1;

import com.yaojian.Solution;

public class Solution29 implements Solution {

    @Override
    public void solution() {
        System.out.println(divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor) {
        int flag = -1;
        if (dividend <= 0 && divisor <= 0 || dividend >=0 && divisor >= 0) {
            flag = 1;
        }
        long a = dividend;
        a = dividend <= 0 ? -a : a;
        long b = divisor;
        b = divisor <= 0 ? -b : b;
        long c = div(a, b);
        return (int) (flag > 0 ? c > Integer.MAX_VALUE ? Integer.MAX_VALUE : c : -c);
    }

    public long div(long a, long b) {
        if (a < b) {
            return 0;
        }
        long count = 1;
        long tb = b;
        while ((tb << 1) <= a) {
            count = count << 1;
            tb = tb << 1;
        }
        return count + div(a - tb, b);
    }
}
