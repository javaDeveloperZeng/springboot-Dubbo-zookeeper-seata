package com.bussines; /**
 * @title: springBootProviderApplication
 * @projectName springMain
 * @description: TODO
 * @author ZLS
 * @date 2019/8/913:30
 */

import com.bussines.configuration.SpringBeanConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2019/8/9 13:30
 **/

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.bussines.dao")
@Import(SpringBeanConfiguration.class)
public class SpringBootConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsumerApplication.class,args);
    }
}
