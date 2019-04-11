package com.qf.service.impl;

import com.qf.Entity.User;
import com.qf.dto.RoleInfoDto;
import com.qf.mapper.UserInfoMapper;
import com.qf.service.UserService;
import com.qf.vo.userInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//声明是一个服务（可以创建对象）
@Service
public class Userserviceimpl implements UserService {
    //这里其实是一个动态代理
    //类似于mybatis中的
    // UserInfoMapper m = sqlSeeion.getMapper(UserInfoMapper.class);
    //由于和spring整合了，又在主配置中配置了mapper.xml，所以spring能自动去装配
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public List<User> queryAll(int id){
        List<User> users = userInfoMapper.queryAll(id);
        return users;
    }
    @Override
    public List<User> query(String username) {
        return userInfoMapper.query(username);
    }

    @Override
    public Boolean chenlogin(User user){
        User checklogin = userInfoMapper.checklogin(user);
        return checklogin!=null?true:false;
    }

    @Override
    public Integer deleteUser(int id){
        return userInfoMapper.deleteUser(id);
    }

    @Override
    public Integer updateUser(User user) {
        return userInfoMapper.updateUser(user);
    }

    @Override
    public Integer deleteUserBatch(List<?> list) {
        Integer is_success = userInfoMapper.deleteUserBatch(list);
        return is_success;
    }

    @Override
    public List<RoleInfoDto> getrolenamebyuserid(userInfoVo userInfoVo) {

        return userInfoMapper.getrolenamebyuserid(userInfoVo);
    }

    @Override
    public Integer insertUser(User user){
        Integer is_success = userInfoMapper.insertInfo(user);
        return is_success;
    }
}
