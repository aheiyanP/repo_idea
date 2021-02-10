package com.zx.dao;

import com.zx.domain.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DeptTest {
    @Test
    public void  testfindAll() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        DeptDao mapper = sqlSession.getMapper(DeptDao.class);


        List<Dept> all = mapper.findAll();
        //List<Dept> all = mapper.findAllWithEmp();

        for (Dept dept : all) {
            System.out.println(dept);
            //System.out.println(dept.getEmployeeList());
        }
        sqlSession.close();
    }

    @Test
    public void  testfindBy() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        DeptDao mapper = sqlSession.getMapper(DeptDao.class);

        Dept dept = new Dept();
        //dept.setDept_id(1);
        dept.setDept_name("市场部");
        //dept.setMajor_name("拉钩招聘");
        //dept.setTelephone("400-400-4008");
        dept.setEmail("laggou@163.com");

        List<Dept> all = mapper.findBy(dept);

        if(all.isEmpty()){
            System.out.println("无数据");
        }
        else{
            for (Dept d : all) {
                System.out.println(d);
            }
        }

        sqlSession.close();
    }
}
