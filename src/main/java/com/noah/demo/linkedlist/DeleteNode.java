package com.noah.demo.linkedlist;

/**
 * Title: DeleteNode.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/10
 */
public class DeleteNode {


    public ListNode deleteNode(ListNode head, int val) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode curr = dummyNode;

        while (head != null) {

            if (head.val == val) {

                curr.next = head.next;
            } else {
                curr = curr.next;
            }

            head = head.next;
        }

        return dummyNode.next;
    }

}
