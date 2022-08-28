package com.noah.demo.dfs;

/**
 * Title: FindCircleNum.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/27
 */
public class FindCircleNum {

    /**
     * 547. 省份数量
     *
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
     * 返回矩阵中 省份 的数量。
     *
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/number-of-provinces
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {

        // 城市数量
        int n = isConnected.length;

        // 已经访问过的城市
        boolean[] visited = new boolean[n];

        // 省份数量
        int ans = 0;

        for (int i = 0; i < n; i++) {


            if (!visited[i]) {

                dfs(isConnected, visited, i);
                ans++;
            }
        }

        return ans;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {


        for (int j = 0; j < isConnected.length; j++) {

            if (isConnected[i][j] == 1 && !visited[j]) {

                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }


}
