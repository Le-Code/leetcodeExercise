package com.yaojian.page2;

import com.yaojian.Solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 */
public class Solution57 implements Solution {

    @Override
    public void solution() {
        int[][] intervals = new int[][]{
                {1,3},
                {6,9}
        };
        int[] newIntervals = new int[]{2,5};
        int[][] res = insert(intervals, newIntervals);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] matrix = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            matrix[i] = intervals[i];
        }
        matrix[intervals.length] = newInterval;
        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int resIdx = 0;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] <= matrix[resIdx][1] && matrix[i][1] > matrix[resIdx][1]) {
                matrix[resIdx][1] = matrix[i][1];
            } else if (matrix[i][0] > matrix[resIdx][1]) {
                matrix[++resIdx][0] = matrix[i][0];
                matrix[resIdx][1] = matrix[i][1];
            }
        }

        int[][] res = new int[resIdx + 1][2];
        for (int i = 0; i <= resIdx; i++) {
            res[i] = matrix[i];
        }
        return res;
    }
}
