package com.bussines; /**
 * @title: springBootProviderApplication
 * @projectName springMain
 * @description: TODO
 * @author ZLS
 * @date 2019/8/913:30
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2019/8/9 13:30
 **/

@SpringBootApplication
@MapperScan("com.bussines.dao")
public class SpringBootProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProviderApplication.class,args);
    }

}
