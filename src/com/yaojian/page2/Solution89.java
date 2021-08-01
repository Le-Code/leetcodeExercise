package com.yaojian.page2;

import com.yaojian.Solution;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 *
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 *
 * 格雷编码序列必须以 0 开头。
 *
 */
public class Solution89 implements Solution {
    @Override
    public void solution() {
        List<Integer> integers = grayCode(3);
        System.out.println(Arrays.toString(integers.toArray()));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            res.add(1);
            return res;
        }

        List<String> process = new ArrayList<>();
        process.add("0");
        process.add("1");

        for (int i = 2; i <= n; i++) {
            List<String> tmpList = new ArrayList<>();
            int lastNum = 0;
            for (String str : process) {
                if (lastNum == 0) {
                    tmpList.add(str + "0");
                    tmpList.add(str + "1");
                    lastNum = 1;
                } else {
                    tmpList.add(str + "1");
                    tmpList.add(str + "0");
                    lastNum = 0;
                }
            }
            process = tmpList;
        }
        for (String str : process) {
            res.add(Integer.parseInt(str, 2));
        }
        return res;
    }
}
