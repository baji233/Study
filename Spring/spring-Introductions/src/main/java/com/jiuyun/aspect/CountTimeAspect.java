package com.jiuyun.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author cj
 * @create 2022年11月23日 18:59:57
 */
@Slf4j
@Component
public class CountTimeAspect {
    public void countTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info(joinPoint.getTarget().getClass().getName()  + "共耗时：" + (end - start) + "毫秒！");
    }
}
