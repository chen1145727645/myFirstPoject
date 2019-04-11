package com.qf.service;

import com.qf.Entity.role;
import com.qf.dto.RoleInfoDto;
import com.qf.vo.RoleInfoVo;

import java.util.List;

public interface RoleService {
    public List<RoleInfoDto> getRole(Integer id);
    public void postRoleInfo(RoleInfoVo roleInfoVo);
    public void insertRole(RoleInfoVo roleInfoVo);
    /**
     * 返回所有角色
     * @author
     * @return list
     *
     */
    public List<role> getAllRole();
}
