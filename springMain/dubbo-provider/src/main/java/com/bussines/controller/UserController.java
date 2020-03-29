package com.bussines.controller;/**
 * @title: UserController
 * @projectName springMain
 * @description: TODO
 * @author ZLS
 * @date 2020/3/1612:29
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.bussines.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2020/3/16 12:29
 **/
@RestController
public class UserController {
   @Autowired
    private IUserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id) {
        System.out.println(id);
        return userService.Sel(id).toString();
    }
    @RequestMapping("login")
    public String login(){
        return "login sussess 8090";
    }


    @RequestMapping("logout/success")
    public String logout(){
        return "logout-success";
    }
}
