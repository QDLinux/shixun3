package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Insert;

import java.util.Date;

/**
 * 	  uid int primary key auto_increment,
 * 	  name varchar(100) not null,
 * 	  password varchar(50) not null,
 *
 * 	  email varchar(50),
 * 	  birthday date
 * 	  ctrl + shift + u 快速大小写
 */
@Data  //包含@Getter@Setter@ToString@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //alt + 鼠标左键  矩形编辑
    private Integer uid;
    private String name;
    private String password;

    private String email;
    private Date birthday;

}

