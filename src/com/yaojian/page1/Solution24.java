package com.yaojian.page1;

import com.yaojian.Solution;
import com.yaojian.struct.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.yaojian.utils.ListNodeUtil.generateListNode;
import static com.yaojian.utils.ListNodeUtil.showList;

public class Solution24 implements Solution {

    @Override
    public void solution() {
        ListNode node = generateListNode(new int[]{1, 2, 3});
        ListNode res = swapPairs(node);
        showList(res);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> tmp = new ArrayList<>();
        ListNode p = head;
        int pos = 0;
        while (p != null) {
            if (pos % 2 == 0) {
                tmp.add(p);
            }
            p = p.next;
            pos++;
        }
        p = head;
        pos = 0;
        int i = 0;
        ListNode res = new ListNode(-1);
        ListNode resP = res;
        while (p != null) {
            if (pos % 2 != 0) {
                resP.next = p;
                resP = resP.next;
                p = p.next;
                resP.next = tmp.get(i++);
                resP = resP.next;
            } else {
                p = p.next;
            }
            pos++;
        }
        if (i < tmp.size()) {
            resP.next = tmp.get(i);
            resP = resP.next;
        }
        resP.next = null;
        return res.next;
    }
}
