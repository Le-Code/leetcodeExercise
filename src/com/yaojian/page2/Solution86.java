package com.yaojian.page2;

import com.yaojian.Solution;
import com.yaojian.struct.ListNode;
import com.yaojian.utils.ListNodeUtil;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 */
public class Solution86 implements Solution {
    @Override
    public void solution() {
        ListNode node = ListNodeUtil.generateListNode(new int[]{1,4,3,0,2,5,2});
        ListNode res = partition(node, 3);
        ListNodeUtil.showList(res);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode p = root;
        ListNode partLeftPoint = null;
        ListNode partRightPoint = null;
        while (p.next != null) {
            if (p.next.val >= x) {
                partLeftPoint = p;
                partRightPoint = p.next;
                break;
            } else {
                p = p.next;
            }
        }
        if (partLeftPoint == null || partRightPoint == null) {
            return root.next;
        }
        p = partRightPoint.next;
        while (p != null) {
            if (p.val >= x) {
                partRightPoint.next = p;
                partRightPoint = partRightPoint.next;
                p = p.next;
            } else {
                ListNode tmpNode = p.next;
                p.next = partLeftPoint.next;
                partLeftPoint.next = p;
                partLeftPoint = partLeftPoint.next;
                p = tmpNode;
            }
        }
        partRightPoint.next = null;
        return root.next;
    }
}
