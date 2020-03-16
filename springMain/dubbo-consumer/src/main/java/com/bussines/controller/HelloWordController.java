package com.bussines.controller;/**
 * @title: HelloWordController
 * @projectName demo
 * @description: TODO
 * @author ZLS
 * @date 2019/8/511:29
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2019/8/5 11:29
 **/
@RestController
@RequestMapping("helloController")
public class HelloWordController {


    @RequestMapping("/helloWord")
    public String hello(HttpServletRequest request){
        return "helloWord";
    }
}
