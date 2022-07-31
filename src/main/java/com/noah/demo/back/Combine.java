package com.noah.demo.back;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Title: Combine.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/26
 */
public class Combine {


    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        if (k <= 0 || n < k) {
            return res;
        }

        // 从 1 开始 - 题目设定
        Deque<Integer> path = new ArrayDeque<>();

        dfs(n, k, 1, path, res);

        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {

        // 终止条件
        if (path.size() == k) {

            res.add(new ArrayList<>(path));
            return;
        }


        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {

            // 添加数据
            path.offerLast(i);

            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, res);

            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.pollLast();
        }
    }


}
