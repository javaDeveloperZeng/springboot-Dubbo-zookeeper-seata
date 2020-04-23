package com.bussines.service;/**
 * @title: AsyncTaskService
 * @projectName Inspur.Dzzw.InvestmentApproval
 * @description: TODO
 * @author ZLS
 * @date 2020/4/2312:45
 */

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 *@Description TODO
 *@Author ZLS
 *@Date 2020/4/23 12:45
 **/
@Service
public class AsyncTaskService {

    public String uuid() {
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
            String nowDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S").format(new Date());
            System.out.println(nowDate + "--->工作线程(" + Thread.currentThread().getName() + ")");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return UUID.randomUUID().toString();
    }
    @Async
    public String getUuid() {
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
            String nowDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S").format(new Date());
            System.out.println(nowDate + "--->工作线程(" + Thread.currentThread().getName() + ")");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return UUID.randomUUID().toString();
    }
}
