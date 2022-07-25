package com.noah.demo.linkedlist;

/**
 * Title: ReverseBetween.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/21
 */
public class ReverseBetween {

    /**
     * 92. 反转链表 II
     * <p>
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     * <p>
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     * <p>
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-linked-list-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {


        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode curr = dummyNode;
        for (int i = 0; i < left - 1; i++) {

            curr = curr.next;
        }

        // 左半段
        ListNode leftNode = curr;

        ListNode newHead = curr.next;


        for (int i = 0; i <= right - left; i++) {

            curr = curr.next;
        }

        ListNode rightHead = curr.next;

        // 断开链表
        curr.next = null;


        // 反转链表
        ListNode pre = rightHead;

        while (newHead != null) {

            ListNode next = newHead.next;
            newHead.next = pre;
            pre = newHead;
            newHead = next;
        }


        leftNode.next = pre;

        return dummyNode.next;
    }

}
