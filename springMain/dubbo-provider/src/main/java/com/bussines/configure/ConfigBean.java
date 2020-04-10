package com.bussines.configure;/**
 * @title: ConfigBean
 * @projectName springMain
 * @description: TODO
 * @author ZLS
 * @date 2020/4/1012:34
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2020/4/10 12:34
 **/
@Configuration
/*@Import({Red.class,  Blue.class})*/
@Import({ImportBeanByImportBeanDefinitionRegistrar.class})
/*@Import({ImportBeanByImportSelector.class})*/
public class ConfigBean {
}
