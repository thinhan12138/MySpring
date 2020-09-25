package com.xh.service;

import com.xh.entity.User;
import com.xh.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * 单独使用Mybatis
 *      1、解析mybatis配置文件
 *      2、生成SqlSessionFactory对象
 *      3、开启SqlSession,获取相应Mapper接口对象
 *      4、调用Mapper接口对象相应的方法
 */
public class MybatisTest {

    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        getUserList();
        addUser();
    }

    public static void getUserList(){
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        userList.stream().forEach(System.out::println);
        session.close();
    }

    public static void addUser(){
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User();
        user.setUserId(2);
        user.setUserName("test2");
        user.setUserPhone("15912345678");
        user.setRoleId(1);
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.addUser(user);
        session.commit();
        session.close();
    }
}
