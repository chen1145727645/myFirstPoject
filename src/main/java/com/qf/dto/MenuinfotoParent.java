package com.qf.dto;

import lombok.ToString;

@ToString
public class MenuinfotoParent {
    private Integer menuid;
    private String menuname;
    private String menupath;
    private String menuicon;
    private Integer prientid;
    private Integer status;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMenupath() {
        return menupath;
    }

    public void setMenupath(String menupath) {
        this.menupath = menupath;
    }

    public String getMenuicon() {
        return menuicon;
    }

    public void setMenuicon(String menuicon) {
        this.menuicon = menuicon;
    }

    public Integer getPrientid() {
        return prientid;
    }

    public void setPrientid(Integer prientid) {
        this.prientid = prientid;
    }

    public boolean isStatus() {
        return this.status==1?true:false;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
