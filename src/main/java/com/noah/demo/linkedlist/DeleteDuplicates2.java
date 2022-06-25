package com.noah.demo.linkedlist;

/**
 * Title: DeleteDuplicates2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/16
 */
public class DeleteDuplicates2 {

    public ListNode deleteDuplicates2(ListNode head) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode curr = dummyNode;


        while (curr.next != null && curr.next.next != null) {

            if (curr.next.val == curr.next.next.val) {

                int value = curr.next.val;
                while (curr.next != null && curr.next.val == value) {

                    curr.next = curr.next.next;
                }
            } else {

                curr = curr.next;
            }
        }


        return dummyNode.next;
    }

    public ListNode deleteDuplicates2V2(ListNode head) {


        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;

            while (next != null && curr.val == next.val) {

                next = next.next;
            }

            // 说明移动过
            if (next != curr.next) {

                // 跳过了重复元素
                pre.next = next;
                curr = next;

            } else {

                // 没有移动
                pre = curr;
                curr = next;
            }
        }

        return dummyNode.next;
    }

}
