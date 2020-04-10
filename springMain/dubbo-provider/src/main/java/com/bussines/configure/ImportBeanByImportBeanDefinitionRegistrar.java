package com.bussines.configure;/**
 * @title: ImportBeanAux
 * @projectName springMain
 * @description: TODO
 * @author ZLS
 * @date 2020/4/1012:48
 */

import com.bussines.bean.Blue;
import com.bussines.bean.Red;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2020/4/10 12:48
 **/
public class ImportBeanByImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        beanDefinitionRegistry.registerBeanDefinition("red1", BeanDefinitionBuilder.rootBeanDefinition(Red.class).getBeanDefinition());
        beanDefinitionRegistry.registerBeanDefinition("blue1", BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition());
    }
}
