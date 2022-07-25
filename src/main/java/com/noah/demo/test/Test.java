package com.noah.demo.test;

import com.noah.demo.linkedlist.ListNode;

/**
 * Title: Tets.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/21
 */
public class Test {


    /**
     * 反转部分链表
     *
     *
     *
     * 1->2->3->4->5
     * 开始 2 结束 4
     *
     * 反转之后：
     * 1->4->3->2->5
     */
    public ListNode reverse(ListNode head, int start, int end) {


        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode curr = dummyNode;
        int i = 0;
        for (; i < start - 1; i++) {

            curr = curr.next;
        }

        ListNode left = curr;
        ListNode newHead = left.next;

        ListNode right = curr;
        for (int j = 0; j <= end - start; j++) {

            right = right.next;
        }

        ListNode rightHead = right.next;

        right.next = null;



        ListNode pre = rightHead;

        while (newHead != null) {

            ListNode nextNode = newHead.next;
            newHead.next = pre;
            pre = newHead;
            newHead = nextNode;
        }

        left.next = pre;

        return dummyNode.next;

    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);


        new Test().reverse(head, 2, 4);




    }



}
