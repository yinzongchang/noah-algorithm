package com.noah.demo.linkedlist;

/**
 * Title: RotateRight.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/3
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int len = 1;

        ListNode curr = head;

        while (curr.next != null) {

            curr = curr.next;
            len++;
        }

        curr.next = head;

        int step = len - (k % len);


        ListNode newHead = head.next;
        ListNode tail = head;

        for (int i = 0; i < step; i++) {

            newHead = newHead.next;
            tail = tail.next;
        }

        tail.next = null;

        return newHead;
    }

}
