package com.itbaizhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ontherContoler {
    @RequestMapping("/other")
    public String ther(){
        System.out.println("this is other action！");
        return "main";
    }
}
