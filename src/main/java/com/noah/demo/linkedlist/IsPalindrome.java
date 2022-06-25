package com.noah.demo.linkedlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: IsPalindrome.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/18
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {

        ListNode curr = head;

        List<ListNode> list = new ArrayList<>();
        while (curr != null)  {
            list.add(curr);
            curr = curr.next;
        }

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {

            ListNode listNode1 = list.get(i);
            ListNode listNode2 = list.get(j);
            if (listNode1.val != listNode2.val) {
                return false;
            }

            i++;
            j--;

        }
        return true;
    }


    public boolean isPalindrome2(ListNode head) {


        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // 奇数个，放在前半段
        ListNode right = slow.next;

        ListNode rightReverse = reverseListNode(right);


        ListNode p1 = head;
        ListNode p2 = rightReverse;


        boolean result = true;
        while (result && p2 !=null) {

            if (p1.val != p2.val) {
                result = false;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        slow.next = reverseListNode(rightReverse);

        return result;
    }

    public ListNode reverseListNode(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode pre = null;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = pre;
            pre = curr;

            curr = next;
        }

        return pre;
    }

    @Test
    public void test() {

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(new IsPalindrome().isPalindrome2(head));


    }

}
