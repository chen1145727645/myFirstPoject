package com.qf.service;

import com.qf.Entity.User;
import com.qf.dto.RoleInfoDto;
import com.qf.vo.userInfoVo;

import java.util.List;

public interface UserService extends baseService<User>{
    @Override
    List<User> queryAll(int id);

    @Override
    Integer insertUser(User user);

    @Override
    public List<User> query(String username);
    //登录验证
    Boolean chenlogin(User user);
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
