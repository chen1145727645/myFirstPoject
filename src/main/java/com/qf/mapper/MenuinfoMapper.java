package com.qf.mapper;

import com.qf.dto.MenuInfoDto;
import com.qf.dto.Role_menuDto;
import com.qf.vo.RoleMenuVo;

import java.util.List;

public interface MenuinfoMapper {
    int deleteByPrimaryKey(Integer menuid);
    /**
     * 获取所有的菜单，返回一个list集合
     * @return
     * @param id:角色id
     */
    List<MenuInfoDto>getAllMenu(Integer id);

    /**
     * 清空菜单
     * @param roleMenuVo
     */
    void checkRole(RoleMenuVo roleMenuVo);
    /**
     * 插入菜单
     */
    void Insertbymenuid(RoleMenuVo roleMenuVo);
    /**
     * @author admin
     * 获取中间表信息
     */
    public List<Role_menuDto> getrole_menu(int roleid);
}