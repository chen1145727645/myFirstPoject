package com.qf.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@Getter
@Setter
public class RoleMenuVo implements Serializable {
    private Integer roleid;
    private List<Integer>menuid;
}
