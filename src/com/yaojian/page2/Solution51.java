package com.yaojian.page2;

import com.yaojian.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后问题
 */
public class Solution51 implements Solution {

    @Override
    public void solution() {
        List<List<String>> res = solveNQueens(4);
        for (List<String> items : res) {
            System.out.println(Arrays.toString(items.toArray()));
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        int[] row = new int[n];
        int[] col = new int[n];
        int[] rl = new int[2 * n + 1];
        int[] ll = new int[2 * n + 1];
        f(matrix, 0, 0, n, row, col, rl, ll, res);
        return res;
    }

    private void f(char[][] matrix, int x, int start, int n, int[] row, int[] col, int[] rl, int[] ll, List<List<String>> res) {
        if (start >= n) {
            List<String> items = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                items.add(new String(matrix[i]));
            }
            res.add(items);
            return;
        }
        for (int i = x; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ok(matrix, i, j, row, col, rl, ll, n)) {
                    matrix[i][j] = 'Q';
                    row[i] = 1;
                    col[j] = 1;
                    rl[i + j] = 1;
                    if (j > i) {
                        ll[j - i] = 1;
                    }else {
                        ll[n + i - j] = 1;
                    }
                    f(matrix, i + 1, start + 1, n, row, col, rl, ll, res);
                    matrix[i][j] = '.';
                    row[i] = 0;
                    col[j] = 0;
                    rl[i + j] = 0;
                    if (j > i) {
                        ll[j - i] = 0;
                    }else {
                        ll[n + i - j] = 0;
                    }
                }
            }
        }
    }

    private boolean ok(char[][] matrix, int x, int y, int[] row, int[] col, int[] rl, int[] ll, int n) {
        if (row[x] == 1) {
            return false;
        }
        if (col[y] == 1) {
            return false;
        }
        if (rl[x + y] == 1) {
            return false;
        }
        if (y - x > 0) {
            return ll[y - x] == 0;
        }else {
            return ll[matrix.length + x - y] == 0;
        }
    }
}
