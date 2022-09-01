package com.noah.demo.stack;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Title: ValidateStackSequences.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/31
 */
public class ValidateStackSequences {

    /**
     * 946. 验证栈序列
     * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false。
     * <p>
     * 示例 1：
     * <p>
     * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * 输出：true
     * 解释：我们可以按以下顺序执行：
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/validate-stack-sequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> stack = new ArrayDeque<>();

        int len = pushed.length;

        int j = 0;
        for (int i = 0; i < len; i++) {

            stack.push(pushed[i]);

            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {

                stack.pop();
                j++;
            }
        }

        return j == popped.length;
    }

    public static void main(String[] args) {

       int[] pushed = {1,2,3,4,5}, popped = {4,3,5};


        System.out.println(new ValidateStackSequences().validateStackSequences(pushed, popped));

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        new ValidateStackSequences().test(list1, list2);

        System.out.println(JSONObject.toJSONString(list1));
        System.out.println(JSONObject.toJSONString(list2));

    }


    public void test(final List<String> list1, List<String> list2) {

        list1.add("nihao");
        list2.add("nihao2");
    }


}
