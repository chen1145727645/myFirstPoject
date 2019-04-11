package com.qf.Controller;

import com.qf.dto.MenuInfoDto;
import com.qf.dto.Role_menuDto;
import com.qf.service.MenuService;
import com.qf.vo.RoleMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author admin
 * 作为菜单的控制层
 */
@RestController
public class MenuController {
    @Autowired
    MenuService menuService;
    @RequestMapping(value = "getAllMenu",method = RequestMethod.GET)
   public List<MenuInfoDto> getAllMenu(@RequestParam Integer roleid){
        //获取中间表信息
        List<Role_menuDto> role_menuDtos =menuService.getrole_menu(roleid);
        //思路：查询中间表，获取status，如果查询出来的checked和中间表不一样，那么就认为不显示的。
        List<MenuInfoDto> allMenu = menuService.getAllMenu(roleid);
        System.out.println(role_menuDtos);
        //遍历主菜单(1.5.9不会被比较，原因是它们属于父菜单，有数据库的数据决定的)
        for (MenuInfoDto menuInfoDto:allMenu){
            //遍历下面的小菜单
            for(int i=0;i<menuInfoDto.getChildren().size();i++){
                //遍历中间表
                for(Role_menuDto role_menuDto:role_menuDtos){
                    //如果小菜单的id和中间表的菜单id一致，则判断中间表的菜单是否显示，如果不显示，则小菜单也不显示
                    if(role_menuDto.getMid()==menuInfoDto.getChildren().get(i).getId()){
                        if(role_menuDto.getStatus()==1){
                            menuInfoDto.getChildren().get(i).setChecked(1);
                        }else{
                            menuInfoDto.getChildren().get(i).setChecked(0);
                        }
                    }
                }
                System.out.println(menuInfoDto.getChildren().get(i));
            }
        }
        return allMenu;
    }

    /**
     * 分配许可
     * @param roleMenuVo
     */
    @RequestMapping(value = "checkRole",method = RequestMethod.POST)
    public void checkRole(@RequestBody RoleMenuVo roleMenuVo){
        System.out.println(roleMenuVo);
        //思路：1.先清空所有当前角色的id
        //2、把获取的角色id和菜单id插入到中间表。
        System.out.println(roleMenuVo);
       menuService.checkRole(roleMenuVo);
       menuService.Insertbymenuid(roleMenuVo);
    }
}
