package com.noah.demo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Title: TestLFU.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/28
 */
public class TestLFU {

    int cap;

    int size;

    Map<Integer, Node> keyTable;

    TreeSet<Node> nodeList;


    public TestLFU(int cap) {
        this.cap = cap;
        keyTable = new HashMap<>();
        nodeList = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.countNode() - o2.countNode();
            }
        });

    }

    public int get(int key) {

        if (size == 0) {
            return -1;
        }

        Node node = keyTable.get(key);
        if (node == null) {
            return -1;
        }

        nodeList.remove(node);

        node.count = node.count + 1;

        nodeList.add(node);
        keyTable.put(key, node);

        return node.value;

    }


    public void add(int key, int value) {

        if (keyTable.containsKey(key)) {

            Node node = keyTable.get(key);
            node.count = node.count + 1;
            node.value = value;
            nodeList.add(node);
            keyTable.put(key, node);
        } else {

            if (this.size == this.cap) {

                Node firstNode = nodeList.first();

                keyTable.remove(firstNode.key);
                nodeList.remove(firstNode);
                size--;
            }

            Node newNode = new Node(key, value, 0);
            nodeList.add(newNode);
            keyTable.put(key, newNode);

            size++;
        }
    }


    public static void main(String[] args) {


        TestLFU testLFU = new TestLFU(3);

        testLFU.add(1, 1);
        testLFU.add(2, 2);
        testLFU.add(3, 3);

        testLFU.get(1);
        testLFU.get(2);

        testLFU.add(4, 4);

        System.out.println(testLFU.get(3));


    }


}

class Node {

    int key;

    int value;

    int count;

    public Node(int key, int value, int count) {
        this.key = key;
        this.value = value;
        this.count = count;
    }

    public int countNode() {

        return this.count * 1000000 + this.key * 100000 + this.value;
    }

}


