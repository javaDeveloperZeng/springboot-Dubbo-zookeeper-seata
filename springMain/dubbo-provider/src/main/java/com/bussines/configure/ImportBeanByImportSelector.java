package com.bussines.configure;/**
 * @title: ImportBeanByImportSelector
 * @projectName springMain
 * @description: TODO
 * @author ZLS
 * @date 2020/4/1012:58
 */

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2020/4/10 12:58
 **/
public class ImportBeanByImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String []{"com.bussines.bean.Red","com.bussines.bean.Blue","com.bussines.bean.Green"};
    }
}
