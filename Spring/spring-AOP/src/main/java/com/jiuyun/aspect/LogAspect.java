package com.jiuyun.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author cj
 * @create 2022年11月22日 19:16:04
 * 记录日志的切面
 */
@Slf4j
@Component
public class LogAspect {

    public void startLog() {
        log.info("准备开始记录日志！");
    }

    public void log() {
        log.info("记录正常日志！");
    }

    public void logError() {
        log.info("记录错误日志！");
    }

    public void afterLog() {
        log.info("记录日志完毕！");
    }
}
