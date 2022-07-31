package com.noah.demo.linkedlist;

/**
 * Title: MergeKLists.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/25
 */
public class MergeKLists {


    public ListNode mergeKLists(ListNode[] lists) {

        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {

        if (left == right) {
            return lists[left];
        }

        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));

    }


    /**
     * 合并两个链表
     */
    public ListNode mergeTwoLists(ListNode a, ListNode b) {

        if (a == null || b == null) {
            return a == null ? b : a;
        }

        ListNode head = new ListNode(-1);

        ListNode aNode = a;
        ListNode bNode = b;

        ListNode curr = head;
        while (aNode != null && bNode != null) {

            if (aNode.val < bNode.val) {
                curr.next = aNode;
                aNode = aNode.next;
            } else {

                curr.next = bNode;
                bNode = bNode.next;
            }

            curr = curr.next;
        }

        curr.next = (aNode != null ? aNode : bNode);

        return head.next;
    }

}
