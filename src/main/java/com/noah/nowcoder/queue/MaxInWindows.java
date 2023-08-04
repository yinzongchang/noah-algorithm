package com.noah.nowcoder.queue;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * MaxInWindows.java
 *
 * @author yinzongchang
 * 创建时间 2023/6/26
 * @since 1.0
 */
public class MaxInWindows {


    /**
     * BM45 滑动窗口的最大值
     * <p>
     * 描述
     * 给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
     * <p>
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     * <p>
     * 窗口大于数组长度或窗口长度为0的时候，返回空。
     * <p>
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param num  int整型一维数组
     * @param size int整型
     * @return int整型ArrayList
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        // write code here

        ArrayList<Integer> result = new ArrayList<>();

        Deque<Integer> deque = new ArrayDeque<>();
        if (size < 1) {
            return result;
        }

        for (int i = 0; i < num.length; i++) {

            if (i < size) {

                if (deque.isEmpty()) {
                    deque.offerLast(i);
                    continue;
                }

                while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                continue;
            }

            result.add(num[deque.peekFirst()]);

            if (deque.peekFirst() == i - size) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        if (num.length >= size) {
            result.add(num[deque.peekFirst()]);
        }


        return result;
    }


    public static void main(String[] args) {

        int[] arr = {10, 14, 12, 11};

        System.out.println(new MaxInWindows().maxInWindows(arr, 1));


        JSONObject jsonObject = JSONObject.parseObject("{}");
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("aaa"));


//        JSONObject jsonObject2 = new JSONObject();
//        System.out.println(jsonObject2.toJSONString());
//
//        System.out.println(new Date(null));

        Map<String, Integer> map = new HashMap<>();
        map.put("aaa", 10);

        for (int i = 0; i < 3; i++) {

            Integer value = map.get("aaa");
            System.out.println(value);
            value -= 1;
        }

        System.out.println(null == null);

        MaxInWindows maxInWindows = JSONObject.parseObject(null, MaxInWindows.class);
        List<MaxInWindows> maxInWindowsList = JSONObject.parseArray(null, MaxInWindows.class);
        System.out.println(JSONObject.toJSONString(maxInWindows));
        System.out.println(JSONObject.toJSONString(maxInWindowsList));

    }
}
