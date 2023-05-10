package com.jiuyun.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cj
 * @create 2022年11月25日 18:57:58
 */
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
