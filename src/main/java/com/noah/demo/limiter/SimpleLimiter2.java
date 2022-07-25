package com.noah.demo.limiter;

import java.util.concurrent.TimeUnit;

/**
 * Title: SimpleLimiter2.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/6/20
 */
public class SimpleLimiter2 {

    /**
     * 当前令牌桶个数
     */
    private long tokenNum = 0;

    /**
     * 令牌桶最大个数
     */
    private final long maxTokenNum = 3;

    /**
     * 1秒
     * 单位：纳秒
     */
    private final long speed = 1000000000;

    /**
     * 下一次产生令牌的时间
     */
    private long next = System.nanoTime();


    /**
     * 重置时间、令牌
     * <p>
     * 如果当前时间大于next时间，需要重置令牌个数
     * next = now
     *
     * @param now
     */
    private void reSync(long now) {

        if (now > next) {

            // 按时间分块，能够产生的令牌数量
            long produceNum = (now - next) / speed;

            // 重置令牌桶个数
            tokenNum = Math.min(maxTokenNum, produceNum + tokenNum);

            next = now;
        }

    }

    /**
     * 计算下一次令牌产生时间
     *
     * @param now
     * @return
     */
    private synchronized long reverse(long now) {

        // 请求时间在下一次令牌产生之后 - 重置逻辑
        reSync(now);

        long at = next;

        // 有令牌
        if (tokenNum > 0) {

            tokenNum--;
        } else {
            // 没有令牌
            next = next + speed;
        }

        return at;
    }

    public void acquire() {

        long now = System.nanoTime();
        long reverse = reverse(now);

        long waitTime = reverse - now;
        if (waitTime > 0) {

            try {
                TimeUnit.NANOSECONDS.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
