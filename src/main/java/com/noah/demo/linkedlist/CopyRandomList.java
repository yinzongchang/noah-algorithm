package com.noah.demo.linkedlist;

/**
 * Title: CopyRandomList.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/15
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {


        if (head == null) {
            return null;
        }


        Node node1 = head;
        while (node1 != null) {


            Node nodeNew = new Node(node1.val);
            nodeNew.next = node1.next;
            node1.next = nodeNew;

            // 中间隔了nodeNew
            node1 = node1.next.next;
        }

        Node node2 = head;
        while (node2 != null) {

            Node nodeNew = node2.next;

            if (node2.random == null) {
                nodeNew.random = null;
            } else {
                nodeNew.random = node2.random.next;
            }

            node2 = node2.next.next;
        }


        Node node3 = head;
        Node newHead = head.next;

        while (node3 != null) {

            Node nodeNew = node3.next;
            node3.next = node3.next.next;

            nodeNew.next = nodeNew.next == null ? null :nodeNew.next.next;

            node3 = node3.next;

        }


        return newHead;
    }


}
