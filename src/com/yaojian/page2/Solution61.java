package com.yaojian.page2;

import com.yaojian.Solution;
import com.yaojian.struct.ListNode;
import com.yaojian.utils.ListNodeUtil;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 */
public class Solution61 implements Solution {
    @Override
    public void solution() {
        ListNode node = ListNodeUtil.generateListNode(new int[]{1});
        ListNode res = rotateRight(node, 1);
        ListNodeUtil.showList(res);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode tmpNode = head;
        int num = 0;
        ListNode end = null;
        while (tmpNode != null) {
            num++;
            if (tmpNode.next == null) {
                end = tmpNode;
            }
            tmpNode = tmpNode.next;
        }
        tmpNode = head;
        int pos = num - k % num - 1;
        while (pos > 0) {
            pos--;
            tmpNode = tmpNode.next;
        }
        ListNode nextNode = tmpNode.next;
        if (nextNode == null) {
            return head;
        }
        tmpNode.next = null;
        end.next = head;
        return nextNode;
    }
}
