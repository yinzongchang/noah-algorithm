package com.noah.demo.structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Title: AllOne.java <br>
 * <p>
 * <p>
 * 链接：https://leetcode.cn/problems/all-oone-data-structure/solution/by-ac_oier-t26d/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author yinzo 2022/8/28
 */
public class AllOne {


    // 头节点
    Node head;

    // 尾节点
    Node tail;

    Map<String, Node> map = new HashMap<>();

    public AllOne() {

        head = new Node(-1000);
        tail = new Node(-1000);

        head.next = tail;
        tail.prev = head;
    }

    /**
     * 插入值
     *
     * @param key
     */
    public void inc(String key) {

        // 如果存在key
        if (map.containsKey(key)) {

            Node node = map.get(key);
            node.set.remove(key);
            int cnt = node.cnt;
            Node next = null;

            if (node.next.cnt == cnt + 1) {

                next = node.next;
            } else {
                next = new Node(cnt + 1);
                next.next = node.next;
                next.prev = node;
                node.next.prev = next;
                node.next = next;
            }
            next.set.add(key);
            map.put(key, next);
            clear(node);
        } else {
            Node node = null;
            if (head.next.cnt == 1) {
                node = head.next;
            } else {
                node = new Node(1);
                node.next = head.next;
                node.prev = head;
                head.next.prev = node;
                head.next = node;
            }
            node.set.add(key);
            map.put(key, node);
        }
    }


    /**
     * 删除值
     *
     * @param key
     */
    public void dec(String key) {

        Node node = map.get(key);
        node.set.remove(key);
        int cnt = node.cnt;

        if (cnt == 1) {
            map.remove(key);
        } else {
            Node prev = null;
            if (node.prev.cnt == cnt - 1) {
                prev = node.prev;
            } else {
                prev = new Node(cnt - 1);
                prev.next = node;
                prev.prev = node.prev;
                node.prev.next = prev;
                node.prev = prev;
            }
            prev.set.add(key);
            map.put(key, prev);
        }
        clear(node);
    }


    /**
     * 获取最大值
     *
     * @return
     */
    public String getMaxKey() {

        Node node = tail.prev;

        for (String str : node.set) {
            return str;
        }
        return "";
    }

    /**
     * 获取最小值
     *
     * @return
     */
    public String getMinKey() {

        Node node = head.next;
        for (String str : node.set) {
            return str;
        }
        return "";
    }


    // 删除节点
    void clear(Node node) {

        if (node.set.size() == 0) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }


    class Node {

        // 记录节点的累计数量
        int cnt;

        // 存放的key
        Set<String> set = new HashSet<>();

        // 前一个节点
        Node prev;

        // 后一个节点
        Node next;

        Node(int _cnt) {
            cnt = _cnt;
        }
    }


}
