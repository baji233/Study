package com.jiuyun.aspect;

import lombok.extern.slf4j.Slf4j;

/**
 * 记录日志的切面
 */
@Slf4j
public class LogAspect {
    public void startLog(){
        log.info("开始记录日志");
    }

    public void alLog(){
        log.info("记录日志结束");
    }

}
