package com.qf.service.impl;

import com.qf.Entity.role;
import com.qf.dto.RoleInfoDto;
import com.qf.mapper.RoleInfoMapper;
import com.qf.service.RoleService;
import com.qf.vo.RoleInfoVo;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public  class RoleServiceiml implements RoleService{
    @Autowired
  private RoleInfoMapper roleInfoMapper;
    @Override
    public List<RoleInfoDto> getRole(Integer id) {
        return roleInfoMapper.getRole(id);
    }
    @Override
    public void postRoleInfo(RoleInfoVo roleInfoVo) {
        roleInfoMapper.postRoleInfo(roleInfoVo);
    }
    @Override
    public void insertRole(RoleInfoVo roleInfoVo) {
        roleInfoMapper.insertRole(roleInfoVo);
    }

    @Override
    public List<role> getAllRole() {
        return roleInfoMapper.getAllRole();
    }
}
