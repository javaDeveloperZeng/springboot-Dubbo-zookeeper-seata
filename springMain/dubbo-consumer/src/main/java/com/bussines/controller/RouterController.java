package com.bussines.controller;/**
 * @title: RouterController
 * @projectName springMain
 * @description: TODO
 * @author ZLS
 * @date 2019/8/1213:27
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2019/8/12 13:27
 **/
@Controller
@RequestMapping("/router")
public class RouterController {
    @RequestMapping("/toHelloWordPage")
    public String tohelloWordPage(HttpServletRequest request){
        return "index";
    }
    @RequestMapping("/toMainPage")
    public String toMainPage(HttpServletRequest request){
        return "views/main";
    }
}
