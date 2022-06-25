package com.noah.demo.linkedlist;

import org.junit.Test;

/**
 * Title: DeleteDuplicates.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/18
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;

            while (next != null && curr.val == next.val) {

                next = next.next;
            }

            curr.next = next;
            curr = curr.next;
        }

        return head;
    }


    @Test
    public void test() {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);

        ListNode listNode2 = new DeleteDuplicates().deleteDuplicates(listNode);





    }
}
