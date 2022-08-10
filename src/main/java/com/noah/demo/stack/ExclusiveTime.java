package com.noah.demo.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Title: ExclusiveTime.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/8
 */
public class ExclusiveTime {

    /**
     * 作者：capital-worker
     * 链接：https://leetcode.cn/problems/exclusive-time-of-functions/solution/han-shu-by-capital-worker-0kac/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @param logs
     * @return
     */
    public int[] exclusiveTime(int n, List<String> logs) {

        int[] ans = new int[n];

        // 存放当前执行的 线程号
        Deque<Integer> stack = new ArrayDeque<>();

        int preTime = 0;

        for (String log : logs) {

            String[] split = log.split(":");
            //当前时间
            int curTime = Integer.parseInt(split[2]);
            //当前的线程号
            int threadId = Integer.parseInt(split[0]);

            //当前线程的类型是 start
            if ("start".equals(split[1])) {

                if (!stack.isEmpty()) {
                    //挂起栈顶线程 记录答案
                    ans[stack.peek()] += (curTime - preTime);
                }
                stack.push(threadId);
                preTime = curTime;
            } else {

                //当前线程的类型是 end
                ans[stack.pop()] += (curTime - preTime + 1);

                // 线程恢复
                preTime = curTime + 1;
            }
        }

        return ans;
    }

}
