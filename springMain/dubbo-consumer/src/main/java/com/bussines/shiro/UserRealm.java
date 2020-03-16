package com.bussines.shiro;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bussines.po.User;
import com.bussines.service.IUserService;
import com.bussines.utils.SpringUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2019/8/15 9:05
 **/
public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //在数据库中查询用户拥有的角色/权限
       /* authorizationInfo.setRoles(userService.findRoles(username));
        authorizationInfo.setStringPermissions(userService.findPermissions(username));*/
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        IUserService userService  = (IUserService)SpringUtil.getBean("userService");
         User user= userService.findByUsername(username);
        if(user == null){
            throw new UnknownAccountException(); //没找到账号
        }
        if(Boolean.TRUE.equals(user.getLocked())){
            throw new LockedAccountException(); //账号被锁定
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,user.getPassWord(),getName());
        return authenticationInfo;
    }
}
