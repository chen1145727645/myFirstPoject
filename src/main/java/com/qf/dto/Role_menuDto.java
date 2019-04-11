package com.qf.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Role_menuDto {
    int rmid;
    int mid;
    int roleid;
    int status;

    public int getRmid() {
        return rmid;
    }

    public void setRmid(int rmid) {
        this.rmid = rmid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Role_menuDto{");
        sb.append("rmid=").append(rmid);
        sb.append(", mid=").append(mid);
        sb.append(", roleid=").append(roleid);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
