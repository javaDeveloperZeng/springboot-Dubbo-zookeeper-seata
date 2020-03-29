package com.bussines; /**
 * @title: springBootProviderApplication
 * @projectName springMain
 * @description: TODO
 * @author ZLS
 * @date 2019/8/913:30
 */

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.bussines.configure.ConfigureBean;
import net.unicon.cas.client.configuration.EnableCasClient;
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
@Import(ConfigureBean.class)
@EnableDubbo
@EnableCasClient
public class SpringBootProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProviderApplication.class,args);
    }

}
