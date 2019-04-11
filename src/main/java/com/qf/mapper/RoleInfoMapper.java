package com.qf.mapper;

import com.qf.Entity.role;
import com.qf.dto.RoleInfoDto;
import com.qf.dto.Role_menuDto;
import com.qf.vo.RoleInfoVo;

import java.util.List;

public interface RoleInfoMapper {
    public List<RoleInfoDto> getRole(Integer id);

    //角色分配
    //第一步：删除所有角色
    public void postRoleInfo(RoleInfoVo roleInfoVo);
    /**
     * @param roleInfoVo
     *  第二步：添加角色
     */
    public void insertRole(RoleInfoVo roleInfoVo);
    /**
     * 返回所有角色
     * @author
     * @return list
     *
     */
    public List<role> getAllRole();

}
