package com.yaojian.page1;

import com.yaojian.Solution;

/**
 * 罗马数字转阿拉伯数字
 */
public class Solution13 implements Solution {

    @Override
    public void solution() {
        System.out.println(romanToInt2("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int[] a = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] b = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        char[] sArr = s.toCharArray();
        int i = 0;
        int pos = 0;
        int res = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        while (i < sArr.length) {
            flag1 = false;
            flag2 = false;
            String s_i_1 = sArr[i] + "";
            if (s_i_1.equals(b[pos])) {
                flag1 = true;
                res += a[pos];
                i += 1;
            }
            if (!flag1) {
                if (i < sArr.length - 1) {
                    String s_i_2 = sArr[i] + "" + sArr[i + 1];
                    if (s_i_2.equals(b[pos + 1])) {
                        res += a[pos + 1];
                        flag2 = true;
                        i += 2;
                        pos += 1;
                    }
                }
            }
            if (!(flag1 || flag2)) {
                pos++;
            }
        }
        return res;
    }

    /**
     * 第二种方法，只用一个循环
     * @param s
     * @return
     */
    public int romanToInt2(String s) {
        char[] sArr = s.toCharArray();
        int right = 0;
        int res = 0;
        for (int i = sArr.length-1; i >= 0; i--) {
            int t = getValue(sArr[i]);
            if (t < right) {
                res -= t;
            }else {
                res += t;
                right = t;
            }
        }
        return res;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'X': return 10;
            case 'V': return 5;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
