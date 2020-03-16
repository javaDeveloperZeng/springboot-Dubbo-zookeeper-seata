package com.bussines.dao;/**
 * @title: UserMapper
 * @projectName demo
 * @description: TODO
 * @author ZLS
 * @date 2019/8/511:56
 */

import com.bussines.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2019/8/5 11:56
 **/
@Repository
public interface UserMapper {
    User Sel(int id);
    User findByUsername( String username);
}
