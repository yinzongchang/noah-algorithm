package com.noah.demo.linkedlist;

import org.junit.Test;

/**
 * Title: ReverseKGroup.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/17
 */
public class ReverseKGroup {


    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;


        ListNode dummyNew = dummyNode;

        ListNode nextHead = null;

        // 节点不为空
        while (head != null) {

            // fast 先判断够不够 k 个
            ListNode fast = dummyNew;
            for (int i = 0; i < k; i++) {

                ListNode next = fast.next;
                if (next == null) {
                    return dummyNode.next;
                }
                fast = next;
            }

            // 下一个 k 分组的头节点
            nextHead = fast.next;

            ListNode slow = head;

            // 将 尾节点 设置为下一个循环的头节点
            ListNode pre = nextHead;
            while (pre != fast) {

                ListNode next = slow.next;
                slow.next = pre;
                pre = slow;
                slow = next;
            }

            // 关键的一步，把哑头指向反转后的头节点
            dummyNew.next = pre;

            dummyNew = head;
            head = nextHead;
        }


        return dummyNode.next;
    }


    @Test
    public void test() {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        new ReverseKGroup().reverseKGroup(head, 2);


    }

}
