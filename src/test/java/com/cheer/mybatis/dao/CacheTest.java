package com.cheer.mybatis.dao;

import com.cheer.mybatis.util.MybatisUtils;
import com.cheer.mybatis.dao.EmpMapper;
import com.cheer.mybatis.model.Emp;
import org.apache.ibatis.session.SqlSession;

public class CacheTest {
    public static void main(String[] args) {

        // 创建线程并且实现了run方法
        Thread thread = new Thread(() -> {
            try {
                // 线程睡眠毫秒
                System.out.println("睡眠ing……");
                Thread.sleep(10 * 1000);
                System.out.println("睡好了，开始干活……");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SqlSession sqlSession = MybatisUtils.getSession();
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            Emp emp = empMapper.getEmp(7788);
            System.out.println(emp.hashCode());
            System.out.println(emp);
            MybatisUtils.close(sqlSession);
        });
        // 创建线程并且实现了run方法
        Thread thread1 = new Thread(() -> {
            SqlSession sqlSession = MybatisUtils.getSession();
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            Emp emp = empMapper.getEmp(7788);
            System.out.println(emp.hashCode());
            System.out.println(emp);
            MybatisUtils.close(sqlSession);
        });

        // 启动线程
        thread.start();
        thread1.start();
    }
}
