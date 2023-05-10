package com.jiuyun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author cj
 * @create 2022年11月25日 20:20:44
 */
@Slf4j
@Controller
public class WorkerController {
    @RequestMapping(value = "/worker/{workId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer workId) {
        log.info("删除的学号为：" + workId);
        return "success";
    }

    @RequestMapping(value = "/worker/{workId}", method = RequestMethod.GET)
    public String select(@PathVariable Integer workId) {
        log.info("查找的学号为：" + workId);
        return "success";
    }

    @RequestMapping(value = "/worker/{workId}", method = RequestMethod.PUT)
    public String save(@PathVariable Integer workId) {
        log.info("保存的学号为：" + workId);
        return "success";
    }


}
