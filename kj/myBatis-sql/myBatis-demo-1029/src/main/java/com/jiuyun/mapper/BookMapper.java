package com.jiuyun.mapper;

import com.jiuyun.bean.Book;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月29日 09:36:06
 */
public interface BookMapper {
    Book selectById(Integer bookId);
    List<Book> selectAll();
}
