package com.bussines.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainController {
  /*  @Value("${casClientLogoutUrl}")
    private String clientLogoutUrl;//http://cas.server.com:8443/cas/logout?service=http://cas.client1.com:9002/logout/success

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();//销毁session
        //使用cas退出成功后,跳转到http://cas.client1.com:9002/logout/success
        return "redirect:" + clientLogoutUrl;
    }*/
    @RequestMapping("home")
    public String home(){
        return "home";
    }
    @RequestMapping("/")
    public String page(){
        return "home";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/hello")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String hello(){
        return "hello";
    }
}
