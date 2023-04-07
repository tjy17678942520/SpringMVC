package com.beihua.controller;

import com.beihua.pojo.User;
import com.beihua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private static final int PAGE_SIZE = 5;


    @RequestMapping("/selectUserPage")
    public List<User> selectUserPage(String userName,String userSex,Integer page){
        int starRow = 0;
        if (page != null){
            starRow = (page - 1) * PAGE_SIZE;
            System.out.println("***********************"+starRow);
        }
        return userService.selectUserPage(userName,userSex,starRow);
    }

    @RequestMapping("/getRowCount")
    public int  getRowCount(String userName,String userSex){

        return userService.getRowCount(userName,userSex);
    }

    @RequestMapping("/deleteUserById")
    public int  deleteUserById(String userId){

        return userService.deleteUserById(userId);
    }


    @RequestMapping("/createUser")
    public int  createUser(User user){
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userService.createUser(user);
    }

}
