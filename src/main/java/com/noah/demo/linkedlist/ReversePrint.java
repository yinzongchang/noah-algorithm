package com.noah.demo.linkedlist;

/**
 * Title: ReversePrint.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/6
 */
public class ReversePrint {



    public int[] reversePrint(ListNode head) {


        int len = 0;

        ListNode pre = null;
        while (head != null) {

            ListNode next = head.next;

            head.next = pre;
            pre = head;

            head = next;

            len++;
        }

        int[] ans = new int[len];
        int i = 0;

        while (pre != null) {

            ans[i] = pre.val;
            i++;
            pre = pre.next;
        }

        return ans;
    }

}
