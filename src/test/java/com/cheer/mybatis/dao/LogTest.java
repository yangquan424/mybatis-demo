package com.cheer.mybatis.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class LogTest {
    private static final Logger LOGGER = LogManager.getLogger(LogTest.class);

    @Test
    public void test() {
        LOGGER.debug("sssss");
    }
}
