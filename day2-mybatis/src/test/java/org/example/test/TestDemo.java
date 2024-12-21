package org.example.test;


import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestDemo {
    @Test
    public void testFinAll() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        //----------------------------------------------------------------------------------------------------
        //以下代码要求记忆
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        //----------------------------------------------------------------------------------------------------
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSave() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        //----------------------------------------------------------------------------------------------------
        //以下代码要求记忆
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("张三");
        user.setPassword("1234");
        user.setEmail("123@qq.com");
        user.setBirthday(new Date());
        userMapper.save(user);


        //----------------------------------------------------------------------------------------------------
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testUpdate() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        //----------------------------------------------------------------------------------------------------
        //以下代码要求记忆
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUid(6);
        user.setName("李四");
        user.setPassword("xxxx");
        user.setEmail("123@qq.com");
        user.setBirthday(new Date());
        userMapper.update(user);


        //----------------------------------------------------------------------------------------------------
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testDelete() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        //----------------------------------------------------------------------------------------------------
        //以下代码要求记忆
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.delete(6);


        //----------------------------------------------------------------------------------------------------
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findByCondition() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //------------------------------------------------------------ 以上代码加载配置文件
        List<User> userList = userMapper.findByCondition(3, "1234");

//        User tempUser = new User();
//        tempUser.setPassword("1234");
//        tempUser.setUid(3);
//        List<User> userList = userMapper.findByCondition2(tempUser);
        for (User user : userList) {
            System.out.println(user);
        }

        //------------------------------------------------------------ 以下代码释放资源
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findByName() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //------------------------------------------------------------ 以上代码加载配置文件
        // List<User> userList = userMapper.findByCondition(10, "1234");


        List<User> userList = userMapper.findByName("o");
        for (User user : userList) {
            System.out.println(user);
        }

        //------------------------------------------------------------ 以下代码释放资源
        sqlSession.commit();
        sqlSession.close();
    }
}

