package com.noah.demo.linkedlist;

/**
 * Title: ReverseList.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/16
 */
public class ReverseList {




    public ListNode reverseList(ListNode head) {


        ListNode listNode = head;

        ListNode result = null;

        while (listNode != null) {

            ListNode next = listNode.next;
            listNode.next = result;
            result = listNode;

            listNode = next;
        }

        return result;
    }



}
