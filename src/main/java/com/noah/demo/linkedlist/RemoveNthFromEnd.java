package com.noah.demo.linkedlist;

/**
 * Title: RemoveNthFromEnd.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/16
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return fast;
            }
            fast = fast.next;
        }

        ListNode slow = dummy;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

}
