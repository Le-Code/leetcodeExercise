package com.yaojian.page2;

import com.yaojian.Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 */
public class Solution88 implements Solution {
    @Override
    public void solution() {
        int[] nums1 = new int[]{0,1,1,2,2,0,0,0};
        int[] nums2 = new int[]{0,3,3};
        merge(nums1, 5, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        LinkedList<Integer> tmpBuffer = new LinkedList<>();
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                if (!tmpBuffer.isEmpty()) {
                    if (nums1[i] >= tmpBuffer.peekFirst()) {
                        tmpBuffer.offer(nums1[i]);
                        nums1[i] = tmpBuffer.pollFirst();
                    }
                }
                i++;
            } else {
                if (!tmpBuffer.isEmpty()) {
                    int tmp = tmpBuffer.peekFirst();
                    if (tmp > nums2[j]) {
                        tmpBuffer.offer(nums1[i]);
                        nums1[i++] = nums2[j++];
                    } else {
                        tmpBuffer.offer(nums1[i]);
                        nums1[i++] = tmp;
                        tmpBuffer.pollFirst();
                    }
                } else {
                    tmpBuffer.offer(nums1[i]);
                    nums1[i++] = nums2[j++];
                }
            }
        }
        while (i < m && !tmpBuffer.isEmpty()) {
            if (nums1[i] > tmpBuffer.peekFirst()) {
                tmpBuffer.offer(nums1[i]);
                nums1[i] = tmpBuffer.pollFirst();
            }
            i++;
        }
        while (j < n && !tmpBuffer.isEmpty()) {
            if (nums2[j] < tmpBuffer.peekFirst()) {
                nums1[i++] = nums2[j++];
            } else {
                nums1[i++] = tmpBuffer.pollFirst();
            }
        }
        while (j < n) {
            nums1[i++] = nums2[j++];
        }
        while (!tmpBuffer.isEmpty()) {
            nums1[i++] = tmpBuffer.pollFirst();
        }
    }
}
