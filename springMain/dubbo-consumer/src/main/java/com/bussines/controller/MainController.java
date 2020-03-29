package com.bussines.controller;/**
 * @title: MainController
 * @projectName springMain
 * @description: TODO
 * @author ZLS
 * @date 2019/8/1914:25
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2019/8/19 14:25
 **/
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

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String login(@RequestParam("userName") String username, @RequestParam("passWord") String password, ModelMap modelMap) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            modelMap.put("msg","未知账户");
        } catch (IncorrectCredentialsException ice) {
            modelMap.put("msg","密码不正确");
        } catch (LockedAccountException lae) {
            modelMap.put("msg","账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            modelMap.put("msg","用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            modelMap.put("msg","用户名或密码不正确！");
        }
        if (subject.isAuthenticated()) {
            return "redirect:/index";
        } else {
            token.clear();
            return "redirect:/login";
        }
    }
}
