package com.qf.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2019/4/1.
 */
@ToString
public class MenuInfoDto implements Serializable{
    int id;
    int pid;
    int seqno;
    String name;
    String url;
    String icon;
    int open = 1;
    int checked;
    List<MenuInfoDto> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSeqno() {
        return seqno;
    }

    public void setSeqno(int seqno) {
        this.seqno = seqno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isOpen() {
        if(this.open==1){
            return true;
        }else{
            return false;
        }
    }

    public void setOpen(int open) {
        this.open = open;
    }

//    public boolean isChecked(){
//        if(checked==1){
//            return true;
//        }else{
//            return false;
//        }
//    }

    public int getChecked() {
        return checked;
    }
    public void setChecked(int checked) {
        this.checked = checked;
    }

    public List<MenuInfoDto> getChildren() {
        return children;
    }

    public void setChildren(List<MenuInfoDto> children) {
        this.children = children;
    }
}
