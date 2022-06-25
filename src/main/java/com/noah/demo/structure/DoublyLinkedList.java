package com.noah.demo.structure;

/**
 * Title: DoublyLinkedList.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2019-07-06
 */
public class DoublyLinkedList {

    private Node head; // 头节点指针
    private Node last; // 尾节点指针
    private int size; // 链表实际长度

    /**
     * 链表插入元素
     *
     * @param data  插入元素
     * @param index 插入位置
     * @throws Exception
     */
    public void insert(int data, int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围!");
        }

        Node insertedNode = new Node(data);
        if (size == 0) {

            // 空链表
            head = insertedNode;
            last = insertedNode;
        } else if (index == 0) {

            // 插入头部
            insertedNode.next = head;
            head = insertedNode;
        } else if (size == index) {

            // 插入尾部
            last.next = insertedNode;
            last = insertedNode;
        } else {

            // 插入中间
            Node prevNode = get(index - 1);
            insertedNode.next = prevNode.next;
            prevNode.next = insertedNode;
        }
        size++;
    }

    /**
     * 删除节点
     *
     * @param index
     * @return
     */
    public Node remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围!");
        }

        Node removedNode = null;
        if (index == 0) {

            // 删除头节点
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {

            // 删除尾节
            Node prevNode = get(index - 1);
            removedNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {

            // 删除中间节点
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removedNode;
    }

    /**
     * 链表查找元素
     *
     * @param index
     * @return
     */
    public Node get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    /**
     * 输出链表
     */
    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


    /**
     * 链表节点
     */
    private static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(3, 0);
        list.insert(7, 1);
        list.insert(9, 2);
        list.insert(5, 3);
        list.insert(6, 1);
        list.remove(0);
        list.output();


    }

}



