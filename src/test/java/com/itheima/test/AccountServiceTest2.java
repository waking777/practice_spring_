package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用单元测试junit
 */
public class AccountServiceTest2 {
    @Test
    public void testFindAll() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService2 as = ac.getBean("accountService2", IAccountService2.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService2 as = ac.getBean("accountService2", IAccountService2.class);
        //3.调用方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("周冬雨");
        account.setMoney(100.0f);
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取业务层对象
        IAccountService2 as = ac.getBean("accountService2", IAccountService2.class);
        //3.调用方法
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取业务层的对象
        IAccountService2 as = ac.getBean("accountService2",IAccountService2.class);
        //3.调用方法
        Account account = as.findAccountById(4);
        account.setMoney(123f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取业务层对象
        IAccountService2 as = ac.getBean("accountService2",IAccountService2.class);
        //3.调用方法
        as.deleteAccount(1);
    }

}
