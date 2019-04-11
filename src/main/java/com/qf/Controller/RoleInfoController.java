package com.qf.Controller;

import com.qf.Entity.role;
import com.qf.dto.RoleInfoDto;
import com.qf.service.RoleService;
import com.qf.service.UserService;
import com.qf.vo.RoleInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleInfoController {
    @Autowired
   private RoleService roleService;
//    这里由于RestController中有了@ResponseBody（向客户端响应json数据），所以这里不需要添加了。
    @RequestMapping(value = "getRoleInfo",method = RequestMethod.GET)
    public List<RoleInfoDto> getRoleInfo(@RequestParam int id){
        List<RoleInfoDto> role = roleService.getRole(id);
        return role;
    }

    //获取修改后的角色分配
    @RequestMapping(value = "postRoleInfo",method = RequestMethod.POST)
    public String  postRoleInfo(@RequestBody RoleInfoVo roleInfoVo){
        //删除角色
           roleService.postRoleInfo(roleInfoVo);
           //添加角色
          roleService.insertRole(roleInfoVo);
        return "true";
    }
    //获取修改后的角色分配
    @RequestMapping(value = "getRoleAll",method = RequestMethod.GET)
    public Object getRoleAll(){
        List<role> allRole = roleService.getAllRole();
        return allRole;
    }
}
