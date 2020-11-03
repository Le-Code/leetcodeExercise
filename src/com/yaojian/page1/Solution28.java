package com.yaojian.page1;

import com.yaojian.Solution;

public class Solution28 implements Solution {

    @Override
    public void solution() {
        System.out.println(strStr("hello", "ll"));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
