package com.jiuyun.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cj
 * @create 2022年11月23日 20:31:34
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String remark;
}
