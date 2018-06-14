package top.itmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: AllenLei (leicong@foxmail.com)
 * @date: 2018/06/14
 * @Description:
 */
@Controller
public class HelloController {

    @Autowired
    private Environment environment;

    @Value("${name}")
    private String name;

    @Value("${url}")
    private String url;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        /**
         * 就可以直接把配置文件信息打印出来。
         * 注意包名是：org.springframework.core.env.Environment
         *  获取配置文件 application.properties 中的内容
         */
        System.out.println(environment.getProperty("name"));
        System.out.println(environment.getProperty("url"));
        System.out.println(name);
        System.out.println(url);
        return "hello spring boot!";
    }

    // 响应数据为静态html页面： http://localhost:8080/user
    @GetMapping("/user")
    public String user(){
        return "/html/user.html";
    }
}
