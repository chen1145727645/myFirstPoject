package com.qf.dto;

import com.qf.Entity.role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@Getter
@Setter
public class RoleInfoDto implements Serializable {
    private Integer userid;
    private String rolename;
    private Integer roleid;
    private List<role>Allrole;
}
