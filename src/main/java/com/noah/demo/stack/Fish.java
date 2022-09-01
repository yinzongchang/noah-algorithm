package com.noah.demo.stack;

import java.util.Stack;

/**
 * Title: Fish.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/29
 */
public class Fish {


    public int solution(int[] fishSize, int[] fishDirection) {

        // 首先拿到鱼的数量
        // 如果鱼的数量小于等于1，那么直接返回鱼的数量
        final int fishNum = fishSize.length;

        if (fishNum <= 1) {

            return fishNum;
        }

        // 0 表示鱼向左游
        final int left = 0;

        // 1 表示鱼向右游
        final int right = 1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < fishNum; i++) {

            // 鱼的游动方向
            int curFishDirection = fishDirection[i];

            // 鱼的大小
            int curFishSize = fishSize[i];

            // 当前的鱼是否被栈中的鱼吃掉了
            boolean hasEat = false;

            // 如果栈中有鱼，并且栈中鱼向右，当前的鱼向左游，那么就会相遇
            while (!stack.isEmpty() && fishDirection[stack.peek()] == right && curFishDirection == left) {

                // 如果栈顶的鱼比较大
                if (fishSize[stack.peek()] > curFishSize) {
                    hasEat = true;
                    break;
                }

                // 如果是栈中的鱼比较小，就直接消除掉
                stack.pop();
            }

            // 如果心来的鱼没有被吃掉，就入栈
            if (!hasEat) {
                stack.push(i);
            }
        }

        return stack.size();
    }


}
