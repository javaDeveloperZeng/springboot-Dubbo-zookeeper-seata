package com.bussines.service.impl;/**
 * @title: UserService
 * @projectName demo
 * @description: TODO
 * @author ZLS
 * @date 2019/8/511:55
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.bussines.dao.UserMapper;
import com.bussines.po.User;
import com.bussines.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2019/8/5 11:55
 **/

@Service
@org.springframework.stereotype.Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;
    public User Sel(int id){
        return userMapper.Sel(id);
    }

    @Override
    public User findByUsername(String userName) {
        return userMapper.findByUsername(userName);
    }
}
