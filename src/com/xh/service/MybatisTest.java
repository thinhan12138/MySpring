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

public class MybatisTest {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        getUserList(session);
    }

    public static void getUserList(SqlSession session){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        userList.stream().forEach(System.out::println);
    }
}
