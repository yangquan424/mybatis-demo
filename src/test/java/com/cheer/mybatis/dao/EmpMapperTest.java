package com.cheer.mybatis.dao;

import com.cheer.mybatis.util.MybatisUtils;
import com.cheer.mybatis.model.Emp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class EmpMapperTest {
    private static final Logger LOGGER = LogManager.getLogger(EmpMapperTest.class);

    @Test
    public void getEmp() {
        SqlSession session = MybatisUtils.getSession();

        EmpMapper empMapper = session.getMapper(EmpMapper.class);

        Emp emp = empMapper.getEmp(7788);
        Assert.assertNotNull(emp);

        //System.out.println(empMapper.getEmp(7788));
        LOGGER.info(emp);
        LOGGER.info("fsfsdf");

        MybatisUtils.close(session);
    }

    @Test
    public void insert() {
        SqlSession session = MybatisUtils.getSession();
        EmpMapper empMapper = session.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setEmpno(1152);
        emp.setEname("yash");
        emp.setDeptno(20);

        System.out.println(empMapper.insert(emp));
        MybatisUtils.close(session);
    }

    @Test
    public void getEmpAll() {
        SqlSession session = MybatisUtils.getSession();
        EmpMapper empMapper = session.getMapper(EmpMapper.class);

        List<Emp> list = empMapper.getEmpAll();
        for (Emp l : list) {
            System.out.println(l);
        }
        MybatisUtils.close(session);
    }

    @Test
    public void doDelete() {
        SqlSession session = MybatisUtils.getSession();

        EmpMapper empMapper = session.getMapper(EmpMapper.class);

        Emp emp = new Emp();
        emp.setEmpno(1111);

        System.out.println(empMapper.doDelete(emp));
        MybatisUtils.close(session);
    }

    @Test
    public void doUpdate() {

        SqlSession session = MybatisUtils.getSession();

        EmpMapper empMapper = session.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setEmpno(1152);
        emp.setEname("yash");
        emp.setDeptno(20);
        System.out.println(empMapper.doUpdate(emp));
        MybatisUtils.close(session);
    }

    @Test
    public void PagehelpTest() {
        //pageNum:表示要显示的页码，pageSize：表示每页的行数
        PageHelper.startPage(1, 5);

        SqlSession session = MybatisUtils.getSession();

        List<Emp> list = session.getMapper(EmpMapper.class).PagehelpTest();

        PageInfo<Emp> pageInfo = new PageInfo<>(list);

        List<Emp> pagelist = pageInfo.getList();

        for (Emp e : pagelist) {
            System.out.println(e);
        }


        Assert.assertEquals(5, pagelist.size());

        MybatisUtils.close(session);


    }
}
