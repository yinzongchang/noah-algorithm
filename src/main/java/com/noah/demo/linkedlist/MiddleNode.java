package com.noah.demo.linkedlist;

/**
 * Title: MiddleNode.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/16
 */
public class MiddleNode {


    public ListNode middleNode(ListNode head) {


        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {


            if (fast.next == null) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
