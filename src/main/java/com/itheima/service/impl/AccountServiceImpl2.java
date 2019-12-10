package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.IAccountDao2;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户业务层的实现类
 */
@Service("accountService2")
public class AccountServiceImpl2 implements IAccountService2 {

    @Autowired
    private IAccountDao2 accountDao2;


    public List<Account> findAllAccount() {
        return accountDao2.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao2.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao2.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao2.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao2.deleteAccount(accountId);
    }
}
