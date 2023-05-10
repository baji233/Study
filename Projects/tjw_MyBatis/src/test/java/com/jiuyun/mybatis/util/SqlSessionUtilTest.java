package com.jiuyun.mybatis.util;

import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SqlSessionUtilTest extends TestCase {

    @Test
    public void testGetSqlSession() {
        assertTrue(SqlSessionUtil.getSqlSession() !=null);
    }
}