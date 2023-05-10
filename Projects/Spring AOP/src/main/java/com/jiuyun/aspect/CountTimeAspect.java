package com.jiuyun.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * 统计性能的切面
 */
@Slf4j
@Component
public class CountTimeAspect {
    /**
     * 如果需要使用环绕通知，必须要将ProceedingJoinPoint参数作为参数列表中的第一个参数
     * @param joinPoint
     */
    public void countTime(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("开始计时");
        long start = System.currentTimeMillis();
        //开始执行连接点的方法
        joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("共耗时：" + (end - start) + "毫秒！");
    }
}
