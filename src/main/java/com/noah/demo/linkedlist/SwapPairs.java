package com.noah.demo.linkedlist;

/**
 * Title: SwapPairs.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/16
 */
public class SwapPairs {

    // dummy -> L1 -> L2 -> L3
    public ListNode swapPairs(ListNode head) {


        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode curr = dummyNode;

        while (curr.next != null && curr.next.next != null) {

            ListNode L1 = curr.next;
            ListNode L2 = curr.next.next;

            curr.next = L2;
            L1.next = L2.next;
            L2.next = L1;

            curr = L1;
        }

        return dummyNode.next;

    }

}
