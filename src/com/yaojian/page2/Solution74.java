package com.yaojian.page2;

import com.yaojian.Solution;

public class Solution74 implements Solution {
    @Override
    public void solution() {
        int[][] matrix = new int[][]{
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,50}
        };
        System.out.println(searchMatrix(matrix, 10));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        if (m == 0 && n == 0) {
            return matrix[0][0] == target;
        }
        int start = 0;
        int row = m;
        int mid = 0;
        while (start <= row) {
            mid = (start + row) / 2;
            if (matrix[mid][n] > target) {
                row = mid;
            } else if (matrix[mid][n] < target) {
                start = mid + 1;
            } else {
                return true;
            }
            if (mid == start) {
                break;
            }
        }
        row = mid;
        start = 0;
        while (start <= n) {
            mid = (start + n) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                n = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
