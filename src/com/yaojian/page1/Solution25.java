package com.yaojian.page1;

import com.yaojian.Solution;
import com.yaojian.struct.ListNode;
import com.yaojian.utils.ListNodeUtil;

import java.util.Stack;

public class Solution25 implements Solution {

    @Override
    public void solution() {
        ListNode pNode = ListNodeUtil.generateListNode(new int[]{1, 2, 3, 4, 5});
        ListNode res = reverseKGroup(pNode, 3);
        ListNodeUtil.showList(res);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        ListNode resNode = new ListNode(-1);
        ListNode tmp = resNode;
        int dump = k;
        while (p != null) {
            stack.push(p);
            p = p.next;
            dump--;
            if (dump == 0) {
                while (!stack.isEmpty()) {
                    tmp.next = stack.pop();
                    tmp = tmp.next;
                }
                dump = k;
            }
        }
        for (ListNode pNode : stack) {
            tmp.next = pNode;
            tmp = tmp.next;
        }
        tmp.next = null;
        return resNode.next;
    }
}
