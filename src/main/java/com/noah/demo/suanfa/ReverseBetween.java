package com.noah.demo.suanfa;

/**
 * Title: ReverseBetween.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2021/11/21
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        // 初始化虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 初始化节点
        ListNode a = dummyHead;
        ListNode b = head;

        // 共同往前移动
        for (int i = 0; i < left - 1; i++) {
            a = a.next;
            b = b.next;
        }

        // 交换节点
        for (int i = 0; i < right - left; i++) {

            ListNode remove = b.next;
            a.next = remove;
            b.next = remove.next;

            remove.next = a.next;

            b = b.next;
        }

        return dummyHead;
    }

}
