package com.noah.demo.linkedlist;

/**
 * Title: CycleInsert.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/18
 */
public class CycleInsert {

    public Node insert(Node head, int insertVal) {

        Node node = new Node(insertVal);

        if (head == null) {

            node.next = node;

            return node;
        }

        if (head.next == head) {

            head.next = node;
            node.next = head;
            return head;
        }

        Node curr = head;
        Node next = head.next;

        while (next != head) {


            if (curr.val <= insertVal && insertVal <= next.val) {

                break;
            }

            if (curr.val > next.val) {

                if (next.val > insertVal || insertVal > curr.val) {

                    break;
                }
            }

            curr = curr.next;
            next = next.next;
        }


        curr.next = node;
        node.next = next;

        return head;

    }

}
