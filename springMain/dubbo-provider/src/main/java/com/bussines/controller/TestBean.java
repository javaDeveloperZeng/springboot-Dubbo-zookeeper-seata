package com.bussines.controller;/**
 * @title: TestBean
 * @projectName springMain
 * @description: TODO
 * @author ZLS
 * @date 2020/4/1012:40
 */

import com.bussines.bean.Color;
import com.bussines.configure.ConfigBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2020/4/10 12:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBean {
    @Test
    public  void testImportBean(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConfigBean.class);
        String [] beanNames=annotationConfigApplicationContext.getBeanNamesForType(Color.class);
       Map mapBean=  annotationConfigApplicationContext.getBeansOfType(Color.class);
       for(String item:beanNames){
            System.out.println("bean名称："+item+"--- 输出bean对象："+mapBean.get(item));
        }
    }
}
