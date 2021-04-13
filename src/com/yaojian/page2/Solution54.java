package com.yaojian.page2;

import com.yaojian.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class Solution54 implements Solution {

    @Override
    public void solution() {
        int[][] matrix = new int[][]{
                {7},
                {9},
                {6}
        };
        List<Integer> res = spiralOrder(matrix);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int x = matrix.length / 2;
        List<Integer> res = new ArrayList<>();
        int[][] visited = new int[matrix.length][matrix[0].length];
        for (int i = 0; i <= x; i++) {
            int start = i;
            int size = matrix[0].length - 2 * i;
            int row = i;
            if (start < matrix[0].length && visited[row][start] == 1) {
                break;
            }
            for (int j = 0; j < size; j++) {
                res.add(matrix[row][start]);
                visited[row][start++] = 1;
            }

            start = i + 1;
            size = matrix.length - 1 - 2 * i;
            int col = matrix[0].length -1 - i;
            if (start < matrix.length && visited[start][col] == 1) {
                break;
            }
            for (int j = 0; j < size; j++) {
                res.add(matrix[start][col]);
                visited[start++][col] = 1;
            }

            start = matrix[0].length - i - 2;
            size = matrix[0].length - 2 * i - 1;
            row = matrix.length - 1 - i;
            if (start >= 0 && visited[row][start] == 1) {
                break;
            }
            for (int j = 0; j < size; j++) {
                res.add(matrix[row][start]);
                visited[row][start--] = 1;
            }

            start = matrix.length - i - 2;
            size = matrix.length - 2 * i - 2;
            col = i;
            if (start >= 0 && visited[start][col] == 1) {
                break;
            }
            for (int j = 0; j < size; j++) {
                res.add(matrix[start][col]);
                visited[start--][col] = 1;
            }
        }
        return res;
    }
}