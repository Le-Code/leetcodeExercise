package com.yaojian;

public class Solutionx2 implements Solution {

    private String min = null;

    @Override
    public void solution() {
        System.out.println(removeDuplicateLetters("rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws"));
    }

    public String removeDuplicateLetters(String s) {
        int[] flags = new int[26];
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if (flags[pos] == 0) {
                total++;
                flags[pos] = 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            flags[i] = 0;
        }

        for (int i = 0; i <= s.length() - total; i++) {
            if (min != null && min.charAt(0) < s.charAt(i)) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            func(i, s.length(), sb, total, flags, s);
            for (int j = 0; j < 26; j++) {
                flags[j] = 0;
            }
        }
        return min;
    }

    private void func(int start, int length, StringBuilder sb, int total, int[] flags, String str) {
        if (sb.length() == total) {
            if (min == null || min.compareTo(sb.toString()) > 0) {
                min = sb.toString();
            }
            return;
        }
        if (start == length || (length - start + 1) < (total - sb.length())) {
            return;
        }

        for (int i = start; i < length; i++) {
            int pos = str.charAt(i) - 'a';
            if (flags[pos] == 0) {
                sb.append(str.charAt(i));
                if (min != null && min.substring(0, sb.length()).compareTo(sb.toString()) < 0) {
                    flags[pos] = 0;
                    sb.setLength(sb.length() - 1);
                    continue;
                }
                flags[pos] = 1;
                func(i + 1, length, sb, total, flags, str);
                sb.setLength(sb.length() - 1);
                flags[pos] = 0;
            }
        }
    }
}
