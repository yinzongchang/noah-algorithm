package com.noah.demo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: AsteroidCollision.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/7/13
 */
public class AsteroidCollision {


    public int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int asteroid : asteroids) {

            boolean isAlive = true;

            while (isAlive && asteroid < 0 && !stack.isEmpty() && stack.peekLast() > 0) {

                if (stack.peekLast() > -asteroid) {
                    isAlive = false;
                } else if (stack.peekLast() == -asteroid) {

                    isAlive = false;
                    stack.pollLast();
                } else {

                    stack.pollLast();
                }
            }

            if (isAlive) {
                stack.offerLast(asteroid);
            }

        }

        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pollLast();
        }

        return ans;
    }


}
