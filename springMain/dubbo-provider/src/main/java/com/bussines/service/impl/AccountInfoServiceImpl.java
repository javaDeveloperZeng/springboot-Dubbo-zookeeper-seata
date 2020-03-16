package com.bussines.service.impl;

import com.bussines.dao.AccountInfoBankDao;
import com.bussines.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @version 1.0
 **/
@org.springframework.stereotype.Service
@com.alibaba.dubbo.config.annotation.Service
public class AccountInfoServiceImpl implements AccountInfoService {
     @Autowired
     AccountInfoBankDao accountInfoBankDao;


    @Transactional
    @Override
    public void updateAccountBalance(String accountNo, Double amount) {
       //李四增加金额
        accountInfoBankDao.updateAccountBalance(accountNo,amount);
        if(amount==3){
            //人为制造异常
            throw new RuntimeException("bank2 make exception..");
        }
    }
}
