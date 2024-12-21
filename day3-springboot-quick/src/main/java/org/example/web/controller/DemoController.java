package org.example.web.controller;

import org.example.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务器有三层:
 * web层: 跟浏览器交互
 * service层: 处理服务器业务逻辑
 * mapper层: 数据库访问 跟数据库交互
 * controller 控制器: 跟浏览器交互 负责与浏览器之间数据传递使用
 */
@RestController //表明身份 类中有这个注解 将被springboot解析
public class DemoController {

    /**
     * @请求方式Mapping   请求方式 有七种 但常用只有四种, get post delete put
     * @GetMapping("/sayHello")
     * 携带此注解的方法 将可以被访问 但是需要设置请求路径
     * 默认浏览器通过地址栏访问服务器 都是get请求
     */
    @GetMapping("/sayHello")
    public String sayHello(){
        return "hello spring boot  !!!!!!!!!!!!";
    }


    /**
     * 如果代码想获得配置文件中的属性 使用@Value注解 注解中输入配置文件中的属性名称
     * 但是有特殊的语法规定 必须使用el表达式 ${ key }
     * ${username} 获得的不是配置文件数据 而是计算机的名称
     * 建议大家不要使用username
     */
    @Value("${username}")
    private String username;
    @Value("${name}")
    private String name;
    @Value("${password}")
    private String password;
    @Value("${age}")
    private Integer age;


    //对象中属性需要获得 使用语法 对象.属性
    @Value("${user.username}")
    private String userUsername;
    @Value("${user.name}") //也是获得计算机名称
    private String userName;
    @Value("${user.password}")
    private String userPassword;
    @Value("${user.age}")
    private Integer userAge;

    @Autowired //自动注入 , 从springboot中拿出定义好的对象
    private UserConfig userConfig;
    //获得配置文件中的数据
    @GetMapping("/sayHello2")
    public String sayHello2(){
        System.out.println(username);
        System.out.println(name);
        System.out.println(password);
        System.out.println(age);
        System.out.println("----------------------------------");
        System.out.println(userUsername);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(userAge);
        System.out.println("---------------------------------");
        System.out.println(userConfig);
        return "hello spring boot !!!!!!!!!!!!";
    }

}


