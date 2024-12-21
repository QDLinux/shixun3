package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private String id;
    private String username;
    private String name;
    private String password;
    private String gender;
    private String image;
    private String job;
    private Date entrydate;
    private String deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
