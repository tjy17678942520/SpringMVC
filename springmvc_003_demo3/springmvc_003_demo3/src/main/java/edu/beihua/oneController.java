package edu.beihua;

import edu.beihua.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class oneController {
    @RequestMapping("/one")
    public String toOne(String name,int age){
        System.out.println(name+"\t"+(age+100));
        return "main";
    }

    @RequestMapping("/two")
    public String toOne(User user){
        System.out.println("通过对象方式传入参数……");
        System.out.println("姓名："+ user.getUname()+"\t年龄: "+(user.getUage()+100));
        return "main";
    }

    @RequestMapping("/three/{name}/{age}")
    //即使是路径中{}中的名字与形参名字一样，springmvc也不能封装入形参、
    //必须使用@@PathVariable()
    public String toThree(@PathVariable() String name,@PathVariable() int age){
        System.out.println("通过动态占位符传入参数");
        System.out.println("姓名："+ name+"\t年龄: "+(age+100));
        return "main";
    }

    @RequestMapping("/four")
    public String toFour(@RequestParam("username") String name, @RequestParam("userage") int age){
        System.out.println("使用RequestParam"+"传入参数");
        System.out.println("姓名："+ name+"\t年龄: "+(age+100));
        return "main";
    }

    @RequestMapping("/five")
    public String tofive(HttpServletRequest request){
        System.out.println("HttpServletRequest"+"获取传入参数");
        System.out.println("姓名："+request.getParameter("name")+"\t年龄: "+((Integer.parseInt(request.getParameter("age")))+100));
        return "main";
    }

}
