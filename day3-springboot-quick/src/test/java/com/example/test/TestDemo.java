package com.example.test;

import org.example.SpringBootQuickMain;
import org.example.config.UserConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单纯的测试类 只会运行当前测试类中的代码
 * 如果我们希望测试springboot的程序  必须要加上两个注解
 * 此测试类必须跟启动类同名同包下 或者 启动类的子包下
 * 如果测试类跟启动类不在同包下 或者子包下 需要额外声明启动类的位置
 */
@SpringBootTest(classes = SpringBootQuickMain.class ) //表明身份 表示此类就是一个springboot的测试类
@RunWith(SpringRunner.class) //RunWith 运行在....生成一个运行环境  Spring 的运行的环境
public class TestDemo {

    @Autowired
    private UserConfig userConfig;
    @Test
    public void test01(){
        System.out.println(userConfig);
    }
}

