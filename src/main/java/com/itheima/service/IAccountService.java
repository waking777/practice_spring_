package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查账户
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存账户
     */
    void saveAccount(Account account);

    /**
     * 更新用户
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     */
    void deleteAccount(Integer accountId);

    /**
     *转账--从A转到B
     */
    void transfer(String sourceName,String targetName,Float money);
}
