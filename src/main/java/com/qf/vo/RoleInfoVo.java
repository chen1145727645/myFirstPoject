package com.qf.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@ToString
@Getter
@Setter
public class RoleInfoVo {
    private int userid;
    private List<Integer>roleid_array;
//    public int getUserid() {
//        return userid;
//    }
//
//    public void setUserid(int userid) {
//        this.userid = userid;
//    }
//
//    public List<Integer> getRoleid_array() {
//        return roleid_array;
//    }
//
//    public void setRoleid_array(List<Integer> roleid_array) {
//        this.roleid_array = roleid_array;
//    }
}
