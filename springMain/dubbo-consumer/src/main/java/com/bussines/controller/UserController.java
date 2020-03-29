package com.bussines.controller;/**
 * @title: UserController
 * @projectName demo
 * @description: TODO
 * @author ZLS
 * @date 2019/8/511:55
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.bussines.service.AccountInfoBank1Service;
import com.bussines.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 *@Description TODO
 *@Author ZLS
 *@Date 2019/8/5 11:55
 **/
@RestController
public class UserController {
    @Reference
    private IUserService userService;
    @Autowired
    @Qualifier("accountInfoServiceImplBank1")
    private AccountInfoBank1Service accountInfoService;

    @RequestMapping("login")
    public String login(){
        return "login success 8092";
    }


    @RequestMapping("logout/success")
    public String logout(){
        return "logout-success";
    }
    @RequestMapping("test")
    public String test( Double amount ){
        accountInfoService.updateAccountBalance("1",amount);
        return "test OK";
    }
    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id) {
        System.out.println(id);
        return userService.Sel(id).toString();
    }
    @Bean(name = "userService")
    public IUserService getIUserService(){
        return userService;
    }



}
