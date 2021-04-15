package com.yaojian.page2;

import com.yaojian.Solution;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 */
public class Solution59 implements Solution {
    @Override
    public void solution() {
        int[][] res = generateMatrix(4);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int len = n / 2;
        int start = 1;
        int total = n * n;
        for (int i = 0; i <= len; i++) {
            int row = i;
            int col = i;
            for (; col < n - i; col++) {
                matrix[row][col] = start++;
            }
            if (start > total) {
                break;
            }
            col = n - 1 - i;
            row = i + 1;
            for (; row < n - i; row++) {
                matrix[row][col] = start++;
            }
            if (start > total) {
                break;
            }
            row = n - 1 -i;
            col = n - 2 - i;
            for (; col >= i; col--) {
                matrix[row][col] = start++;
            }
            if (start > total) {
                break;
            }
            row = n - 2 - i;
            col = i;
            for (; row >= i + 1; row--) {
                matrix[row][col] = start++;
            }
            if (start > total) {
                break;
            }
        }
        return matrix;
    }
}
