package com.yaojian.page1;

import com.yaojian.Solution;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class Solution49 implements Solution {

    @Override
    public void solution() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs);
        for (List<String> items : res) {
            System.out.println(Arrays.toString(items.toArray()));
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> visited = new HashMap<>();
        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            List<String> c = visited.get(new String(strArr));
            if (c == null) {
                c = new ArrayList<>();
                visited.put(new String(strArr), c);
            }
            c.add(str);
        }
        for (Map.Entry<String, List<String>> entry : visited.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
