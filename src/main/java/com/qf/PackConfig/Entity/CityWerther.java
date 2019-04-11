package com.qf.PackConfig.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
/**
 * 设置参数映射为不必须，否则json字符串有多少字段，这里就要写多少个字段。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityWerther {
   private String time;
   private CityInfo cityInfo;
   private String date;
   private String message;
   private int status;
}
