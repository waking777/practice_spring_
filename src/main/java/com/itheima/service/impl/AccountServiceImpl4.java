package com.itheima.service.impl;

import com.itheima.service.IAccountService3;
import org.springframework.stereotype.Service;

/**
 * 业务层的实现类
 */
@Service("accountService4")
public class AccountServiceImpl4 implements IAccountService3{
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
