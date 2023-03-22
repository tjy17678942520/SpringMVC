package com.itbaizhan.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DataController {
   /* @RequestMapping("/date")
    public String toShow(  @DateTimeFormat(pattern = "yyyy-MM-dd")  Date data){
        System.out.println(data);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(data));
        return "show";
    }
*/

    @InitBinder
    public void initDate(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"),true
        ));
    }
    @RequestMapping("/date")
    public String toShow(Date data){
        System.out.println(data);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(data));
        return "show";
    }
}
