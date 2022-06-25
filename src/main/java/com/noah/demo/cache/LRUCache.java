package com.noah.demo.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: LRUCache.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/5/21
 */
public class LRUCache {

    private LRUCache() {

    }

    int size;
    int capacity;

    Map<Integer, DLinkedNode> cache;

    DLinkedNode head = new DLinkedNode();
    DLinkedNode tail = new DLinkedNode();


    public LRUCache(int capacity) {

        cache = new HashMap<>(capacity);
        this.size = 0;
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {

        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }

    }

    public void put(int key, int value) {

        DLinkedNode node = cache.get(key);
        if (node == null) {

            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            this.addToHead(newNode);


            if (size == capacity) {
                removeTail();
            } else {
                size++;
            }

        } else {

            node.value = value;
            moveToHead(node);
        }

    }


    private void moveToHead(DLinkedNode node) {

        // 删除节点
        DLinkedNode prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;

        // 添加到头部
        this.addToHead(node);
    }

    private void addToHead(DLinkedNode node) {

        // 添加到头部
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    private void removeTail() {

        DLinkedNode node = tail.prev;
        cache.remove(node.key);
        node.prev.next = tail;
        tail.prev = node.prev;
    }



}
