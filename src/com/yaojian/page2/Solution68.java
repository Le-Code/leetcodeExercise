package com.yaojian.page2;

import com.yaojian.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Solution68 implements Solution {
    @Override
    public void solution() {
        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        List<String> res = fullJustify(words, 16);
        System.out.println(Arrays.toString(res.toArray()));
    }

    private String format(String str, int maxWidth) {
        int zeroCount = maxWidth - str.length();
        String[] strArr = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        if (strArr.length == 1) {
            sb.append(str);
            for (int i = 0; i < zeroCount; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int needInsertZeroCount = strArr.length - 1;
        int zeroItem = zeroCount / needInsertZeroCount;
        if (zeroCount % needInsertZeroCount == 0) {
            for (int i = 0; i < strArr.length - 1; i++) {
                sb.append(strArr[i] + " ");
                for (int j = 0; j < zeroItem; j++) {
                    sb.append(" ");
                }
            }
            sb.append(strArr[strArr.length - 1]);
            return sb.toString();
        } else {
            int remainZeroCount = zeroCount % needInsertZeroCount;
            for (int i = 0; i < strArr.length - 1; i++) {
                sb.append(strArr[i] + " ");
                for (int j = 0; j < zeroItem; j++) {
                    sb.append(" ");
                }
                if (remainZeroCount > 0) {
                    sb.append(" ");
                    remainZeroCount--;
                }
            }
            sb.append(strArr[strArr.length - 1]);
            return sb.toString();
        }
    }

//    ["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]
//    ["Science   is what we","understand      well","enough to explain to","a   computer. Art is","everything  else  we","do                  "]

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justify = new ArrayList<>();
        int pos = 0;
        while (pos < words.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(words[pos]);
            pos++;
            while (pos < words.length) {
                if (sb.length() + 1 + words[pos].length() <= maxWidth) {
                    sb.append(" " + words[pos]);
                    pos++;
                } else {
                    break;
                }
            }
            if (pos >= words.length) {
                int remainZero = maxWidth - sb.length();
                for (int j = 0; j < remainZero; j++) {
                    sb.append(" ");
                }
                justify.add(sb.toString());
            } else {
                justify.add(format(sb.toString(), maxWidth));
            }
        }
        return justify;
    }
}
