package com.jiuyun.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 记录日志的切面
 */
@Slf4j
@Component
public class LogAspect {
    /**
     * 通知
     */
    public void startLog() {
        log.info("准备开始记录日志！");
    }

    public void afterLog() {
        log.info("记录日志完毕！");
    }

    public void logging() {
        log.info("记录正常日志！");
    }

    public void logError() {
        log.info("记录错误日志！");
    }
}
