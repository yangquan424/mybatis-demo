package com.cheer.mybatis.dao;
import com.cheer.mybatis.model.Author;
import com.cheer.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthorMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSession();
        List<Integer> idlist = new ArrayList<>(Arrays.asList(1,2,3));
        List<Author> list = sqlSession.getMapper(AuthorMapper.class).FindAuthorIng(idlist);
        Assert.assertEquals(3,list.size());
        for (Author author : list) {
            System.out.println(author);
        }
        MybatisUtils.close(sqlSession);
    }
}