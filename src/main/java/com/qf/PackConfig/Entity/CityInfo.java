package com.qf.PackConfig.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CityInfo {
     private String city;
     private Long cityId;
     private String parent;
     private String  updateTime;
}
