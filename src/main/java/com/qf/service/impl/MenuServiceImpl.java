package com.qf.service.impl;

import com.qf.dto.MenuInfoDto;
import com.qf.dto.Role_menuDto;
import com.qf.mapper.MenuinfoMapper;
import com.qf.service.MenuService;
import com.qf.vo.RoleMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MenuService的实现类
 * @author admin
 *
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuinfoMapper menuinfoMapper;
    @Override
    public List<MenuInfoDto> getAllMenu(Integer roleid) {
        return menuinfoMapper.getAllMenu(roleid);
    }

    @Override
    public void checkRole(RoleMenuVo roleMenuVo) {
        menuinfoMapper.checkRole(roleMenuVo);
    }

    @Override
    public void Insertbymenuid(RoleMenuVo roleMenuVo) {
        menuinfoMapper.Insertbymenuid(roleMenuVo);
    }

    @Override
    public List<Role_menuDto> getrole_menu(int roleid) {
        return menuinfoMapper.getrole_menu(roleid);
    }
}
