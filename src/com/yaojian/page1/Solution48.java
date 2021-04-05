package com.yaojian.page1;

import com.yaojian.Solution;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 */
public class Solution48 implements Solution {

    @Override
    public void solution() {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int itemLength = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < itemLength - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[itemLength - j - 1][i];
                matrix[itemLength - j - 1][i] = matrix[itemLength - i - 1][itemLength - j - 1];
                matrix[itemLength - i - 1][itemLength - j - 1] = matrix[j][itemLength - i - 1];
                matrix[j][itemLength - i - 1] = tmp;
            }

        }
    }
}
