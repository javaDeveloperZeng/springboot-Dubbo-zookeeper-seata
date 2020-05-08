package com.bussines.bean;/**
 * @title: Food
 * @projectName springMain
 * @description: TODO
 * @author ZLS
 * @date 2020/4/2612:39
 */

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2020/4/26 12:39
 **/
public interface Food {
    enum Coffee implements Food{
        BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
    }
    enum Dessert implements Food{
        FRUIT, CAKE, GELATO
    }
}
