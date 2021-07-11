package com.yaojian.page2;

import com.yaojian.Solution;
import com.yaojian.struct.ListNode;
import com.yaojian.utils.ListNodeUtil;

import javax.rmi.CORBA.Util;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 */
public class Solution82 implements Solution {
    @Override
    public void solution() {
        ListNode node = ListNodeUtil.generateListNode(new int[]{1,1,1});
        ListNode res = deleteDuplicates(node);
        ListNodeUtil.showList(res);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode resNode = new ListNode(-1);
        resNode.next = head;
        ListNode startNode = resNode;
        ListNode pointNode = head.next;
        boolean flag = false;
        boolean lastSameFlag = true;
        while (pointNode != null) {
            if (pointNode.val == startNode.next.val) {
                pointNode = pointNode.next;
                flag = true;
                lastSameFlag = true;
            } else {
                if (!flag) {
                    startNode = startNode.next;
                }
                startNode.next = pointNode;
                pointNode = pointNode.next;
                startNode.next.next = null;
                flag = false;
                lastSameFlag = false;
            }
        }
        if (lastSameFlag) {
            startNode.next = null;
        }
        return resNode.next;
    }
}
