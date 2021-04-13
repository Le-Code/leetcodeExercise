package com.yaojian.page2;

import com.yaojian.Solution;

/**
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 *
 */
public class Solution58 implements Solution {

    @Override
    public void solution() {
        System.out.println(lengthOfLastWord("hello world"));
    }

    public int lengthOfLastWord(String s) {
//        String[] arr = s.split("\\s");
//        return arr.length == 0 ? 0 : arr[arr.length - 1].length();
        s = s.trim();
        int res = 0;
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ' '){
                break;
            }
            res++;
        }
        return res;
    }
}
