package com.jiuyun.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer stuId;
    private String stuName;
    private String sex;
    private Integer age;
    private String remark;
}
