package com.yaojian.page2;

import com.yaojian.Solution;
import com.yaojian.struct.ListNode;
import com.yaojian.utils.ListNodeUtil;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 */
public class Solution83 implements Solution {
    @Override
    public void solution() {
        ListNode node = ListNodeUtil.generateListNode(new int[]{1,2,3,3});
        ListNode res = deleteDuplicates(node);
        ListNodeUtil.showList(res);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode point = head.next;
        while (point != null) {
            if (p.val == point.val) {
                point = point.next;
            } else {
                p.next = point;
                p = p.next;
                point = point.next;
            }
        }
        p.next = null;
        return head;
    }
}
