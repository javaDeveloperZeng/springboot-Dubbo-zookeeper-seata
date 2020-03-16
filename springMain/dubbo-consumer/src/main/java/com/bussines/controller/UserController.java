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
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;


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


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            return "密码不正确";
        } catch (LockedAccountException lae) {
            return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            return "用户名或密码不正确！";
        }
        if (subject.isAuthenticated()) {
            return "登录成功";
        } else {
            token.clear();
            return "登录失败";
        }
    }
}
