package com.qf.Entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.util.List;

//get、set、tostring

@ToString
public class User {
    private Integer id;
   /*使用校验框架数据*/
    @Length(min = 6,max = 18,message = "用户名长度不合法")
    private String username;
    //判断null和空串
    @NotBlank(message = "名字不能为空")
    private String name;
    @Length(min = 6,max = 18,message = "密码长度不合法")
    private String password;
    @Email(message = "邮箱不合法")
// @Pattern() ->使用正则验证
    private String email;
    List<role>roleList;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<role> roleList) {
        this.roleList = roleList;
    }
}
