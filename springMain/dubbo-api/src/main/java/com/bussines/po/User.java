package com.bussines.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @title: User
 * @projectName demo
 * @description: TODO
 * @author ZLS
 * @date 2019/8/511:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
    private String locked;
    private String credentialsSalt;
    private String type;


}

