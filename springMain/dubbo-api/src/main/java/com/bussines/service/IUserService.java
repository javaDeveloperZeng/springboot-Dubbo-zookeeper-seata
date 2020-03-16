package com.bussines.service;/**
 * @title: IUserService
 * @projectName dubbo-api
 * @description: TODO
 * @author ZLS
 * @date 2019/8/515:03
 */

import com.bussines.po.User;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2019/8/5 15:03
 **/
public interface IUserService {
    public User Sel(int id);
    public User findByUsername(String userName);
}
