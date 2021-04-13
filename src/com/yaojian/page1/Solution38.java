package com.yaojian.page1;

import com.yaojian.Solution;

public class Solution38 implements Solution {

    @Override
    public void solution() {
        System.out.println(countAndSay(5));
    }

    public String countItem(String content) {
        char[] arr = content.toCharArray();
        char preNum = arr[0];
        int c = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if (preNum != arr[i]) {
                sb.append(c + "" + preNum);
                preNum = arr[i];
                c = 1;
            } else {
                c++;
            }
        }
        sb.append(c + "" + preNum);
        return sb.toString();
    }

    public String countAndSay(int n) {
        String content = "1";
        for (int i = 1; i < n; i++) {
            content = countItem(content);
        }
        return content;
    }
}
