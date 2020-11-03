package com.yaojian.utils;

import com.yaojian.struct.ListNode;

public class ListNodeUtil {

    public static ListNode generateListNode(int[] arr) {
        ListNode root = new ListNode(-1);
        ListNode p = root;
        for (int i = 0; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        return root.next;
    }

    public static void showList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
