package edu.beihua;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class demo2 {
    @RequestMapping("/demo2")
    public String tomain(){
        return "main";
    }
}
