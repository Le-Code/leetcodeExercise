package com.yaojian.page2;

import com.yaojian.Solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class Solution56 implements Solution {
    @Override
    public void solution() {
        int[][] intervals = new int[][] {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        int[][] res = merge(intervals);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int resIdx = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[resIdx][1] && intervals[i][1] > intervals[resIdx][1]) {
                intervals[resIdx][1] = intervals[i][1];
            } else if (intervals[i][0] > intervals[resIdx][1]) {
                intervals[++resIdx][0] = intervals[i][0];
                intervals[resIdx][1] = intervals[i][1];
            }
        }
        int[][] matrix = new int[resIdx + 1][2];
        for (int i = 0; i <= resIdx; i++) {
            matrix[i] = intervals[i];
        }
        return matrix;
    }
}
