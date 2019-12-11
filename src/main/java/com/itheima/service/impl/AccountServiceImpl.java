package com.itheima.service.impl;

import com.itheima.Utils.TransactionManager;
import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;

import java.util.List;

/**
 * 账户业务层的实现类
 */
public class AccountServiceImpl implements IAccountService {

    private TransactionManager txManager;
    private IAccountDao accountDao;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        try{
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;
        }catch(Exception e){
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally{
            //6.释放资源
            txManager.release();
        }
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        try{
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作

            //1.根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //3.转出账户减钱
            source.setMoney(source.getMoney() - money);
            //4.转入账户加钱
            target.setMoney(target.getMoney() + money);
            //5.更新转出账户
            updateAccount(source);

//            int i = 1/0;

            //6.更新转入账户
            updateAccount(target);

            //3.提交事务
            txManager.commit();
        }catch(Exception e){
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally{
            //6.释放资源
            txManager.release();
        }
    }
}
