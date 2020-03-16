package com.bussines.configuration;/**
 * @title: SpringBeanConfiguration
 * @projectName springMain
 * @description: TODO
 * @author ZLS
 * @date 2020/3/59:24
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bussines.service.IUserService;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2020/3/5 9:24
 **/
@Configuration
public class SpringBeanConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Primary
    @Bean("dataSource")
    public DataSource dataSource(DruidDataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource);
    }
    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner("dubbo-consumer", "my_test_tx_group");
    }

}
