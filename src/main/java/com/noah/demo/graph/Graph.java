package com.noah.demo.graph;

import java.util.LinkedList;

/**
 * Title: Graph.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/12
 */
public class Graph {

    private LinkedList<Edge>[] adj; // 邻接表
    private int v; // 顶点个数

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) { // 添加一条边
        this.adj[s].add(new Edge(s, t, w));
    }

    private class Edge {
        public int sid; // 边的起始顶点编号
        public int tid; // 边的终止顶点编号
        public int w; // 权重

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    // 下面这个类是为了 dijkstra 实现用的
    private class Vertex {

        public int id; // 顶点编号 ID
        public int dist; // 从起始顶点到这个顶点的距离

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }


    // 因为 Java 提供的优先级队列，没有暴露更新数据的接口，所以我们需要重新实现一个
    private class PriorityQueue { // 根据 vertex.dist 构建小顶堆
        private Vertex[] nodes;
        private int count;

        public PriorityQueue(int v) {
            this.nodes = new Vertex[v + 1];
            this.count = v;
        }

        public Vertex poll() { // TODO: 留给读者实现...

            return null;
        }

        public void add(Vertex vertex) { // TODO: 留给读者实现...
        }

        // 更新结点的值，并且从下往上堆化，重新符合堆的定义。时间复杂度 O(logn)。
        public void update(Vertex vertex) { // TODO: 留给读者实现...
        }

        public boolean isEmpty() { // TODO: 留给读者实现...
            return true;
        }
    }


    public void dijkstra(int s, int t) { // 从顶点 s 到顶点 t 的最短路径

        int[] predecessor = new int[this.v]; // 用来还原最短路径

        // vertexes 数组，记录从起始顶点到每个顶点的距离（dist）
        Vertex[] vertexes = new Vertex[this.v];

        // 我们把所有顶点的 dist 都初始化为无穷大（也就是代码中的 Integer.MAX_VALUE）
        for (int i = 0; i < this.v; ++i) {

            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }


        PriorityQueue queue = new PriorityQueue(this.v);// 小顶堆

        boolean[] inqueue = new boolean[this.v]; // 标记是否进入过队列

        // 我们把起始顶点的 dist 值初始化为 0，然后将其放到优先级队列中
        vertexes[s].dist = 0;
        queue.add(vertexes[s]);

        inqueue[s] = true;


        while (!queue.isEmpty()) {

            // 取堆顶元素并删除
            // 优先级队列中取出 dist 最小的顶点 minVertex
            Vertex minVertex = queue.poll();

            if (minVertex.id == t) {

                break; // 最短路径产生了
            }


            // 遍历所有边
            // 考察这个顶点可达的所有顶点（代码中的 nextVertex）。
            // 如果 minVertex 的 dist 值加上 minVertex 与 nextVertex 之间边的权重 w 小于 nextVertex 当前的 dist 值，也就是说，存在另一条更短的路径，它经过 minVertex 到达 nextVertex
            for (int i = 0; i < adj[minVertex.id].size(); ++i) {


                Edge e = adj[minVertex.id].get(i); // 取出一条 minVetex 相连的边

                Vertex nextVertex = vertexes[e.tid]; // minVertex-->nextVertex

                if (minVertex.dist + e.w < nextVertex.dist) { // 更新 next 的 dist

                    nextVertex.dist = minVertex.dist + e.w;

                    predecessor[nextVertex.id] = minVertex.id;

                    if (inqueue[nextVertex.id] == true) {
                        queue.update(nextVertex); // 更新队列中的 dist 值
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }
        // 输出最短路径
        System.out.print(s);
        print(s, t, predecessor);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }


}


