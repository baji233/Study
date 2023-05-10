package com.jiuyun.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author cj
 * @create 2022年11月23日 19:38:43
 * 统计性能的自包含切面
 */
@Slf4j
@Component
public class CountTimeAdvisor implements MethodBeforeAdvice, AfterReturningAdvice {
    private long start;
    private long end;
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        log.info("准备调用" + o.getClass().getName() + "." + method.getName() + "()方法！");
        start = System.currentTimeMillis();
    }

    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        end = System.currentTimeMillis();
        log.info(o1.getClass().getName() + "." + method.getName() + "()共耗时：" + (end - start) + "毫秒！");
    }


}
