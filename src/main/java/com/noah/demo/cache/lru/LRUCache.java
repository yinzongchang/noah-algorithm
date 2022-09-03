package com.noah.demo.cache.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: LRUCache.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/2
 */
public class LRUCache {

    /**
     * 缓存的大小
     */
    int size;

    /**
     * 容量
     */
    int capacity;

    /**
     * 虚拟头节点
     */
    DLinkedNode head;

    /**
     * 虚拟尾节点
     */
    DLinkedNode tail;

    /**
     * keyNode Map
     */
    Map<Integer, DLinkedNode> keyNode;


    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.size = 0;

        this.head = new DLinkedNode(0, 0);
        this.tail = new DLinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;

        this.keyNode = new HashMap<>(capacity);
    }

    public int get(int key) {

        DLinkedNode node = keyNode.get(key);
        if (node == null) {
            return -1;
        }

        // 将最近访问的节点 移动至 头部
        moveToHead(node);

        return node.value;
    }


    public void put(int key, int value) {

        DLinkedNode node = keyNode.get(key);

        if (node == null) {

            if (size == capacity) {

                // 移除尾部节点
                keyNode.remove(tail.prev.key);
                removeTail();
                size--;
            }

            DLinkedNode newNode = new DLinkedNode(key, value);
            keyNode.put(key, newNode);
            addToHead(newNode);

            size++;
        } else {

            node.value = value;
            moveToHead(node);
        }

    }

    public void removeTail() {

        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }

    public void removeNode(DLinkedNode node) {

        node.next.prev = node.prev;
        node.prev.next = node.next;

    }


    public void moveToHead(DLinkedNode node) {

        removeNode(node);
        addToHead(node);
    }

    public void addToHead(DLinkedNode node) {

        node.next = head.next;
        head.next.prev = node;

        node.prev = head;
        head.next = node;
    }


    static class DLinkedNode {

        /**
         * key
         */
        int key;

        /**
         * value
         */
        int value;

        /**
         * prev
         */
        DLinkedNode prev;

        /**
         * next
         */
        DLinkedNode next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}
