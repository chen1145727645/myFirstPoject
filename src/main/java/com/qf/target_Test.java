package com.qf;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.Entity.User;
import com.qf.dto.RoleInfoDto;
import com.qf.service.RoleService;
import com.qf.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class target_Test{
  private  ApplicationContext context=new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
    //根据用户id去查询用户所拥有的角色
    @Test
    public void fun1(){
        //service交由spring代理
        UserService us = context.getBean(UserService.class);
        //反射调用serviceimpl的方法queryAll
        List<User> users = us.queryAll(2);
        System.out.println(users);
    }
    @Test
    public void fun2(){
        //service交由spring代理
        UserService us = context.getBean(UserService.class);
        User user=new User();
        user.setUsername("刘德华");
        user.setPassword("123444");
        user.setEmail("1457665@163.com");
        Integer is_success = us.insertUser(user);
        System.out.println(is_success);
    }
    @Test
    public void fun3(){
        //service交由spring代理
        UserService us = context.getBean(UserService.class);
        //分页操作，在执行sql前自动将limit添加到sql语句中
        //第三个参数为count查询，如果为true会查询两次，并且计算页数
        //隐藏的坑1：PageHelper.startPage必须先写在查询的前面，因为要在sql执行前进行拦截
        //隐藏的坑2：这里返回的结果list并不会直接打印，而是会输出分页信息，只能for循环遍历
        Page<User> users = PageHelper.startPage(1, 2);
//        List<User>list = us.query();
//        for (User u:list){
//            System.out.println(u);
//        }
    }
    @Test
    public void fun4(){
        UserService bean = context.getBean(UserService.class);
        User user=new User();
        user.setUsername("zs");
        user.setPassword("122231");
        Boolean chenlogin = bean.chenlogin(user);
        System.out.println(chenlogin);
    }
    @Test
    public void fun5(){
        RoleService bean = context.getBean(RoleService.class);
        List<RoleInfoDto> role = bean.getRole(1);
        System.out.println(role);
    }
}