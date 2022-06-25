package com.noah.demo.suanfa;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: MaxDepthN.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2021/11/21
 */
public class MaxDepthN {


    public int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }

        int result = 0;

        Deque<Node> nodeDeque = new LinkedList<>();

        nodeDeque.offer(root);

        while (!nodeDeque.isEmpty()) {

            int size = nodeDeque.size();

            for (int i = 0; i < size; i++) {

                Node parentNode = nodeDeque.poll();
                if (parentNode == null) {
                    continue;
                }
                List<Node> childNodes = parentNode.children;
                for (Node childNode : childNodes) {
                    nodeDeque.offer(childNode);
                }
            }

            result++;
        }

        return result;
    }


    public int maxDepth2(Node root) {

        if (root == null) {
            return 0;
        }

        int maxDepth = 0;
        List<Node> childNodes = root.children;

        for (Node childNode : childNodes) {

            int childDepth = maxDepth2(childNode);
            maxDepth = Math.max(maxDepth, childDepth);
        }

        return maxDepth + 1;
    }

}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

