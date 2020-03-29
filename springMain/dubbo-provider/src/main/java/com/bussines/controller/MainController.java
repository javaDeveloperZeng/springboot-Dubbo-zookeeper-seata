package com.bussines.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @Value("${casClientLogoutUrl}")
    private String clientLogoutUrl;//http://cas.server.com:8443/cas/logout?service=http://cas.client1.com:9002/logout/success

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();//销毁session
        //使用cas退出成功后,跳转到http://cas.client1.com:9002/logout/success
        return "redirect:" + clientLogoutUrl;
    }
}
