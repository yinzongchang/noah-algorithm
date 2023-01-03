package com.noah.demo.limiter;

import java.util.concurrent.TimeUnit;

/**
 * Title: SimpleLimiter.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/20
 */
public class SimpleLimiter {


    // 1个/s，容量为1的令牌桶算法

    /**
     * 下一次产生令牌的时间
     */
    private long next = System.nanoTime();

    /**
     * 1秒 = 10E9 纳秒
     * 单位：纳秒
     */
    private final long speed = 1000000000;


    /**
     * 计算下一次令牌产生时间
     *
     * @param now
     * @return
     */
    private synchronized long reserve(long now) {

        if (now > next) {
            next = now;
        }


        // 能够获取令牌的时间
        long at = next;

        next = next + speed;

        return at;
    }

    public void acquire() {

        long now = System.nanoTime();
        long next = reserve(now);

        long waitTime = next - now;

        if (waitTime > 0) {
            try {

                TimeUnit.NANOSECONDS.sleep(waitTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
