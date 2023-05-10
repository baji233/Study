package com.jiuyun.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author cj
 * @create 2022年11月23日 20:38:42
 * 添加日志的切面
 */
@Slf4j
@Component
@Aspect
public class LogAspect {
    /**
     * 配置全局切入点
     */
    @Pointcut("execution(public * com.jiuyun.service.impl.*.*(..))")
    public void logPointcut(){}

    /**
     * 配置了一个前置通知，并指定了切入点为logPointcut
     */
    @Before("logPointcut()")
    public void startLog() {
        log.info("准备开始记录日志！");
    }


    @After("logPointcut()")
    public void endLog() {
        log.info("日志保存完毕！");
    }

}
