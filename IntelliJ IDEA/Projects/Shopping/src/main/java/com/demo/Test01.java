package com.demo;

import org.slf4j.Logger;

/**
 *
 */
public class Test01 {

    //声明日志常量
    private static final Logger log=org.slf4j.LoggerFactory.getLogger(Test01.class);

    public static void main(String[] args){
        //日志级别如下（）
        log.debug("Hello Log4j");
        log.info("Hello Log4j");
        log.warn("Hello Log4j");
        log.error("Hello Log4j");

        System.out.println("\n");

        try{
            int i=10/0;
        }catch (Exception e){
            log.error(e.getClass().getName()+":"+e.getMessage());
            StackTraceElement[] stackTraceElements=e.getStackTrace();
            for(StackTraceElement ste:stackTraceElements){
                log.error(ste.toString());
            }
        }
    }
}
