package com.qf.mapper;

import com.qf.Entity.User;
import com.qf.dto.RoleInfoDto;
import com.qf.vo.userInfoVo;

import java.util.List;

public interface UserInfoMapper extends baseMapper<User>{
    //查询一个用户所对应的角色
    @Override
    public List<User> queryAll(int id);
    //插入一个用户
    @Override
    public Integer insertInfo(User user);
    //查询用户表中所用信息
    @Override
    public List<User> query(String username);
    public User checklogin(User user);
    Integer deleteUser(int id);
    Integer updateUser(User user);
    Integer deleteUserBatch(List<?>list);
    /**
     *  根据用户名和密码获取角色信息
     * @param userInfoVo
     * @return List<RoleInfoDto>
     */
    List<RoleInfoDto>getrolenamebyuserid(userInfoVo userInfoVo);

}
