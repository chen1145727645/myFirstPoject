package com.qf.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.Entity.User;
import com.qf.dto.RoleInfoDto;
import com.qf.service.UserService;
import com.qf.utils.MD5Utils;
import com.qf.vo.userInfoVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

//声明这是一个控制器
@Controller
public class UserController{
    @Autowired
   private UserService userService;
   //前端映射路径(请求必须是post，映射名是loginCheck)
   @RequestMapping(value = "loginCheck",method = RequestMethod.POST)
   //响应文本（如果不加这个默认返回的是一个html文件，原因是springMVC里配置了后缀为HTML）
   @ResponseBody//自动装json格式
   //@RequestBody 可以将前端传递过来的数据封装成一个对象，前提是名字得一样，
   //并且要使用 JSON.stringify({
   //                "username":$("#username").val(),
   //                "password":$("#password").val()
   //            }),
   //将javascript数据转成JSON数据
    public String loginCheck(@RequestBody User user,HttpSession httpSession){
       if(user.getUsername()==null||"".equals(user.getUsername())||user.getPassword()==null||"".equals(user.getPassword())){return "false";}
       //将用户输入的密码进行加密，然后和数据库比对
       System.out.println(user);
       user.setPassword(MD5Utils.encodePassword(user.getPassword()));
       Boolean chenlogin = userService.chenlogin(user);
       if(chenlogin){
           httpSession.setAttribute("user",user);
       }
       return chenlogin.toString();
    }
    //获取用户信息
    @ResponseBody
    @RequestMapping(value = "getUserAll",method = RequestMethod.GET)
    public Object getUserAll(@RequestParam(required = false) String page, @RequestParam(required = false)String username){
        System.out.println(username);
       if(page==null||page==""){page="1";}
        PageHelper.startPage(Integer.parseInt(page),5);
        List<User> query = userService.query(username);
        System.out.println(query);
        PageInfo<User>pageInfo=new PageInfo<User>(query);
        return  pageInfo;
    }
    @ResponseBody
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public String addUser(@RequestBody @Valid User user, BindingResult result){
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                return error.getDefaultMessage();
            }
        }
        Integer is_success = userService.insertUser(user);
        return is_success==1?"true":"false";
    }

    //批量删除
    @ResponseBody
    @RequestMapping(value = "deleteBatch",method = RequestMethod.POST)
    public String deleteBatch(@RequestParam(value = "checkid[]") List<String> checkid){
        //批量获取到id
        Integer is_success = userService.deleteUserBatch(checkid);
        System.out.println(checkid);
        return is_success==1?"true":"false";
    }

    //根据id查询，将结果回显
    @ResponseBody
    @RequestMapping(value = "getUserbyId",method = RequestMethod.GET)
    public Object getUserbyId(@RequestParam String id){
        List<User> list = userService.queryAll(Integer.parseInt(id));
        System.out.println(list);
        User u=new User();
        for (User user:list) {
            u.setId(user.getId());
            u.setUsername(user.getUsername());
            u.setName(user.getName());
            u.setEmail(user.getEmail());
        }
        return u!=null?u:"false";
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public String updateUser(@RequestBody User user){
        Integer is_success = userService.updateUser(user);
        return is_success==1?"true":"false";
    }

    //单个数据删除
    @ResponseBody
    @RequestMapping(value = "delone",method = RequestMethod.POST)
    public String delone(@RequestParam String id){
        Integer is_success = userService.deleteUser(Integer.parseInt(id));
        return is_success==1?"true":"false";
    }

    /**
     *  根据用户名和密码获取角色信息
     * @param userInfoVo
     *
     */
    @ResponseBody
    @RequestMapping(value = "getrolenamebyuserid",method = RequestMethod.POST)
    public Object getrolenamebyuserid(@RequestBody userInfoVo userInfoVo){
        //对密码进行加密。
        userInfoVo.setPassword(MD5Utils.encodePassword(userInfoVo.getPassword()));
       return userService.getrolenamebyuserid(userInfoVo);
    }
}
