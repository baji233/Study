package com.jiuyun.mapper;

import com.jiuyun.bean.Book;
import com.jiuyun.util.SqlSessionUtil;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月29日 09:42:04
 */
public class BookMapperTest {
    private static final Logger log = LoggerFactory.getLogger(BookMapperTest.class);
    private BookMapper bookMapper;

    @Before
    public void before() {
        bookMapper = (BookMapper) SqlSessionUtil.getMapper(BookMapper.class);
    }

    @Test
    public void selectById() {
        log.info("查询结果：" + bookMapper.selectById(1));
    }

    @Test
    public void selectAll() {
        List<Book> bookList = bookMapper.selectAll();
        for (Book book : bookList) {
            log.info("book:" + book);
        }
        log.info("查询结果：");
    }
}