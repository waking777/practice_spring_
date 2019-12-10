package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao2 {
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
    void deleteAccount(Integer id);
}
