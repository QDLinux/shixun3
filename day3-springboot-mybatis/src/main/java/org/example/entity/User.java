package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String userName;//数据库是下划线 但java中是驼峰式命名规则
    private String password;
    private String name;
    private String age;
    private String sex;
    private String birthday;
    private String note;
    private String created;
    private String updated;

}

