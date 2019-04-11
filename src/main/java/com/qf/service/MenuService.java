package com.qf.service;

import com.qf.dto.MenuInfoDto;
import com.qf.dto.Role_menuDto;
import com.qf.vo.RoleMenuVo;

import java.util.List;

public interface MenuService {
    /**
     * 获取所有的菜单，返回一个list集合
     * @return
     * @param roleid 角色id
     */
    List<MenuInfoDto> getAllMenu(Integer roleid);

    /**
     * 角色分配修改
     * @param roleMenuVo
     */
    void checkRole(RoleMenuVo roleMenuVo);
    void Insertbymenuid(RoleMenuVo roleMenuVo);

    /**
     * @author admin
     * 获取中间表信息
     */
    public List<Role_menuDto> getrole_menu(int roleid);
}
