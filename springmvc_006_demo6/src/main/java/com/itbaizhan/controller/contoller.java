package com.itbaizhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class contoller {

    @RequestMapping("/one")
    public String one(){
        System.out.println("默认的请求转发！");
        //使用视图解析器拼接前后缀进行页面跳转
        return "main";
    }

    @RequestMapping("/two")
    public String two(){
        System.out.println("请求转发action跳转");
        //forward:字符串可以屏蔽前缀和后缀的拼接.实现请求转发跳转
        //不加上的话会拼接为：/admin/other.do.jsp
        return "forward:/other.do";
    }


    @RequestMapping("/three")
    public String three(){
        System.out.println("默认重定向跳转界面");
        //forward:字符串可以屏蔽前缀和后缀的拼接.实现请求转发跳转
        //不加上的话会拼接为：/admin/other.do.jsp
        return "redirect:/other.do";
    }

    @RequestMapping("/four")
    public String four(){
        System.out.println("默认重定向跳转界面");
        //redirect:字符串可以屏蔽前缀和后缀的拼接.实现请求转发跳转
        return "redirect:/admin/main.jsp";
    }

    @RequestMapping("/five")
    public String five(){
        System.out.println("这是随便跳.......");

        return "forward:/fore/login.jsp";
    }
}
