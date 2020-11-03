package com.yaojian.page1;

import com.yaojian.Solution;
import com.yaojian.struct.ListNode;
import com.yaojian.utils.ListNodeUtil;

import java.util.List;

import static com.yaojian.utils.ListNodeUtil.generateListNode;
import static com.yaojian.utils.ListNodeUtil.showList;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class Solution23 implements Solution {

    @Override
    public void solution() {
        ListNode[] lists = new ListNode[] {
                generateListNode(new int[]{1, 4, 5}),
                generateListNode(new int[]{1, 3, 4}),
                generateListNode(new int[]{2, 6})
        };
        ListNode res = mergeKLists(lists);
        showList(res);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode root = lists[0];
        for (int i = 1; i < lists.length; i++) {
            root = combine(root, lists[i]);
        }
        return root;
    }

    public ListNode combine(ListNode n1, ListNode n2) {
        ListNode root = new ListNode(-1);
        ListNode p = root;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                p.next = n1;
                n1 = n1.next;
            } else {
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }
        while (n1 != null) {
            p.next = n1;
            n1 = n1.next;
            p = p.next;
        }
        while (n2 != null) {
            p.next = n2;
            n2 = n2.next;
            p = p.next;
        }
        return root.next;
    }


}
