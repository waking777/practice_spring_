package com.itheima.service.impl;

import com.itheima.service.IAccountService3;

/**
 * 业务层的实现类
 */
public class AccountServiceImpl3  implements IAccountService3{
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount() {
        System.out.println("执行了更新");
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
