package com.noah.demo.cache.lfu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Title: LFUCache.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/9/1
 */
public class LFUCache {

    // 容量
    int capacity;

    // 时间戳
    int time;


    Map<Integer, Node> keyTable;

    TreeSet<Node> treeSet;

    public LFUCache(int capacity) {

        this.capacity = capacity;
        this.time = 0;

        keyTable = new HashMap<>();
        treeSet = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {

                int count = o1.count - o2.count;
                return count == 0 ? o1.time - o2.time : count;
            }
        });
    }

    public int get(int key) {

        if (capacity == 0) {
            return -1;
        }

        // 哈希表中无key，直接返回
        if (!keyTable.containsKey(key)) {
            return -1;
        }

        // 获取旧的缓存
        Node node = keyTable.get(key);

        // 从treeSet中删除node
        treeSet.remove(node);

        node.count += 1;
        node.time = ++time;

        // 将node重新放进去排序
        treeSet.add(node);

        keyTable.put(key, node);

        return node.value;
    }


    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // 缓存中不包含key
        if (!keyTable.containsKey(key)) {

            // 达到上限
            if (keyTable.size() == capacity) {

                // 要移除的node
                Node node = treeSet.first();
                treeSet.remove(node);
                keyTable.remove(node.key);
            }

            Node newNode = new Node(1, ++time, key, value);
            treeSet.add(newNode);
            keyTable.put(key, newNode);
        } else {

            // 缓存中包含key

            // 获取旧的缓存
            Node node = keyTable.get(key);

            // 从treeSet中删除node
            treeSet.remove(node);

            node.count += 1;
            node.time = ++time;
            node.value = value;

            // 将node重新放进去排序
            treeSet.add(node);

            keyTable.put(key, node);
        }
    }

}

class Node {

    /**
     * 次数
     */
    int count;

    /**
     * 时间
     */
    int time;

    /**
     * key
     */
    int key;

    /**
     * value
     */
    int value;

    public Node(int count, int time, int key, int value) {

        this.count = count;
        this.time = time;
        this.key = key;
        this.value = value;
    }
}
