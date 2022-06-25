package com.noah.demo.linkedlist;

/**
 * Title: SortList2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/18
 */
public class SortList2 {

    public ListNode sortList(ListNode head) {


        return sort(head);

    }

    public ListNode sort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }


        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {

            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;

        // 断开链表
        slow.next = null;

        // 递归从最左面开始
        ListNode left = sort(head);
        ListNode right = sort(mid);

        return merge(left, right);
    }


    public ListNode merge(ListNode left, ListNode right) {

        ListNode dummyNode = new ListNode(0);

        ListNode temp = dummyNode;


        while (left != null && right != null) {

            if (left.val <= right.val) {

                temp.next = left;
                left = left.next;

            } else {

                temp.next = right;
                right = right.next;
            }

            temp = temp.next;
        }

        if (left != null) {

            temp.next = left;
        }

        if (right != null) {
            temp.next = right;
        }

        return dummyNode.next;
    }


}
