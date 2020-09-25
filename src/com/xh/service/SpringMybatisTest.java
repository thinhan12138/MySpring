package com.xh.service;

import com.xh.entity.Role;
import com.xh.entity.User;
import com.xh.mapper.RoleMapper;
import com.xh.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Spring整合Mybatis使用
 *      解析Spring配置文件，根据datasource和mybatis配置文件生成SqlSessionFactory的bean，然后生成Mapper的bean，
 *      该bean依赖于mapperInterface和sqlSessionFactory属性，根据MapperFactoryBean生成
 */
public class SpringMybatisTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        List<User> userList = userMapper.getUserList();
        userList.forEach(user -> {
            System.out.println(user.getUserId() + " " + user.getUserName() + " " + user.getUserPhone());
        });

        User user = new User();
        user.setUserName("test3");
        user.setUserPhone("123456");
        user.setRoleId(1);
        userMapper.addUser(user);

        RoleMapper roleMapper = (RoleMapper) applicationContext.getBean("roleMapper");
        List<Role> roleList = roleMapper.getRoleList();
        roleList.forEach(role -> {
            System.out.println(role.getRoleId() + " " + role.getRoleName());
        });

        Role role = new Role();
        role.setRoleName("role2");
        roleMapper.addRole(role);
    }
}
