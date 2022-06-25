package com.noah.demo.linkedlist;

/**
 * Title: HasCycle.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/15
 */
public class HasCycle {


    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode dummy = new ListNode(0).next = head;

        ListNode slow = dummy.next;
        ListNode fast = dummy.next.next;

        while (slow != fast) {

            if (fast == null || fast.next == null) {
                return false;
            } else {

                slow = slow.next;
                fast = fast.next.next;
            }
        }

        return true;
    }


}
