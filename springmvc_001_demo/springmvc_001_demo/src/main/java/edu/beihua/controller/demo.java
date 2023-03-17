package edu.beihua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class demo {
    @RequestMapping("/demo")
    public String tomain(){
        return "main";
    }

}
