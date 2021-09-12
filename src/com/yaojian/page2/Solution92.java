package com.yaojian.page2;

import com.yaojian.Solution;
import com.yaojian.struct.ListNode;
import com.yaojian.utils.ListNodeUtil;

import java.util.Stack;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class Solution92 implements Solution {
    @Override
    public void solution() {
        ListNode listNode = ListNodeUtil.generateListNode(new int[]{1, 2, 3, 4, 5});
        ListNode res = reverseBetween(listNode, 2, 4);
        ListNodeUtil.showList(res);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = new ListNode(-1, head);
        ListNode p = root;
        int tmpLeft = left;
        while (tmpLeft-- > 1) {
            p = p.next;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode q = p.next;
        tmpLeft = left;
        while (q != null && tmpLeft++ <= right) {
            stack.push(q);
            q = q.next;
        }
        ListNode end = q;
        while (!stack.isEmpty()) {
            p.next = stack.pop();
            p = p.next;
        }
        p.next = end;
        return root.next;
    }
}
