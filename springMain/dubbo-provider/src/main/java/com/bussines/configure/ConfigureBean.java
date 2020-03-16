package com.bussines.configure;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @title: ConfigureBean
 * @projectName springMain
 * @description: TODO
 * @author ZLS
 * @date 2020/3/1612:59
 */

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2020/3/16 12:59
 **/
@Configuration
public class ConfigureBean {

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
        return new GlobalTransactionScanner("dubbo-provider", "my_test_tx_group");
    }

}
