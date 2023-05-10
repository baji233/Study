package com.jiuyun.service.impl;

import com.jiuyun.service.MyService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author cj
 * @create 2022年11月23日 19:10:10
 */
@Slf4j
public class DefaultMyService implements MyService {
    public void service() {
        log.info("this is DefaultMyService.service() method!");
    }
}
