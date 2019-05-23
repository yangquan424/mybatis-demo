package com.cheer.mybatis.dao;

import com.cheer.mybatis.model.Blog;
import com.cheer.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class BlogMapperTest {
    private static final Logger LOGGER = LogManager.getLogger(EmpMapperTest.class);

    @Test
    public void test1(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper blogMapper = session.getMapper(BlogMapper.class);
        List<Blog> blogList = blogMapper.FindBlog("ACTIVE","%贸易%");
        for (Blog blog : blogList) {
            System.out.println(blog);
            LOGGER.info(blog);
        }
        MybatisUtils.close(session);

        Assert.assertEquals(2,blogList.size());

    }
    @Test
    public void Test2(){
        SqlSession session = MybatisUtils.getSession();
        List<Map> list = session.getMapper(BlogMapper.class).FindBlog2("&贸易&");
        for (Map map : list) {
            System.out.println(map);
        }
        //Assert.assertEquals(2,list.size());
        MybatisUtils.close(session);
    }
    @Test
    public void test3(){
        Map<String, Object> params = new HashMap<>();
        params.put("state", "ACTIVE");
        params.put("title", "%贸易%");
        params.put("username", "KEITH");
        SqlSession session = MybatisUtils.getSession();
        List<Blog> blogList =  session.getMapper(BlogMapper.class).FindBlog3(params);
        Assert.assertEquals(1,blogList.size());
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        MybatisUtils.close(session);
    }
    @Test
    public void test4(){
        Map<String,Object> params = new HashMap<>();
        params.put("title","DELETE");
        params.put("author.id",5);
        params.put("id",1);
        SqlSession session = MybatisUtils.getSession();
        int i = session.getMapper(BlogMapper.class).UpdateBlog(params);
        Assert.assertEquals(1,i);
        System.out.println(i);
        MybatisUtils.close(session);
    }
}
