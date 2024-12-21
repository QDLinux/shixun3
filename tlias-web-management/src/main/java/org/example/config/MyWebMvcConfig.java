package org.example.config;

import org.example.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration// 表明身份  此类就是一个配置类
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;
    /**
     * 此方法就是为了给 spring boot中添加拦截器的配置
     *  InterceptorRegistry registry 参数就是 拦截器注册器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //将我们自定义的拦截器 交给spring boot处理
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/login")  //exclude 排除..
                .addPathPatterns("/**"); //给拦截器设置拦截路径  /**表示拦截所有
    }
}
