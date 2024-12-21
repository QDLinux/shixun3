package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/*
此类是一个配置类 目的 获得配置文件的数据
prefix = "user" 前缀
 */
@Data
@Configuration//表明身份  此类就是一个配置类
@ConfigurationProperties(prefix = "user") //加载配置文件的数据
public class UserConfig {
    private String username;
    private String name;
    private String password;
    private Integer age;
}
