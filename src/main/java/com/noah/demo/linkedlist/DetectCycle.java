package com.noah.demo.linkedlist;

/**
 * Title: DetectCycle.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/15
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        ListNode x = head;

        while (fast != null) {

            if (fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                while (x != slow) {

                    x = x.next;
                    slow = slow.next;
                }

                return x;

            }
        }

        return null;
    }



}
