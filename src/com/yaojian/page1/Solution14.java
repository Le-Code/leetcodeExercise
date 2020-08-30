package com.yaojian.page1;

import com.yaojian.Solution;

import java.util.List;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class Solution14 implements Solution {

    @Override
    public void solution() {
        System.out.println(longestCommonPrefix(new String[]{"aa","a"}));
    }

    class ListNode {
        char ch;
        ListNode next;

        public ListNode(char ch) {
            this.ch = ch;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        ListNode pRoot = new ListNode('r');
        ListNode tmp = pRoot;
        for (int i = 0; i < strs[0].length(); i++) {
            tmp.next = new ListNode(strs[0].charAt(i));
            tmp = tmp.next;
        }
        for (int i = 1; i < strs.length; i++) {
            tmp = pRoot;
            for (int j = 0; j < strs[i].length(); j++) {
                if (tmp.next != null && tmp.next.ch == strs[i].charAt(j)) {
                    tmp = tmp.next;
                }else {
                    tmp.next = null;
                    break;
                }
            }
            tmp.next = null;
        }
        StringBuilder sb = new StringBuilder();
        while (pRoot.next != null) {
            sb.append(pRoot.next.ch);
            pRoot = pRoot.next;
        }
        return sb.toString();
    }
}
