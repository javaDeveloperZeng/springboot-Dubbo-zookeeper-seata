package com.bussines.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bussines.dao.AccountInfoBankDao;
import com.bussines.service.AccountInfoBank1Service;
import com.bussines.service.AccountInfoService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service("accountInfoServiceImplBank1")
public class AccountInfoServiceImplBank1 implements AccountInfoBank1Service {

    @Autowired
    AccountInfoBankDao accountInfoBankDao;

    @Reference
    AccountInfoService accountInfoService;

    @GlobalTransactional//开启全局事务
    @Transactional
    @Override
    public void updateAccountBalance(String accountNo, Double amount) {
        //System.out.println("开始全局事务。XID="+RootContext.getXID());
        //扣减张三的金额
        accountInfoBankDao.updateAccountBalance(accountNo,amount *-1);
        //调用李四微服务，转账
        accountInfoService.updateAccountBalance("2",amount);

        if(amount == 2){
            //人为制造异常
            throw new RuntimeException("bank1 make exception..");
        }
    }
}
