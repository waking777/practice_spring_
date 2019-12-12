package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用单元测试junit
 * @runwith 是替换原来的main方法
 * @ContextConfiguration 配置 locations 等于bean.xml文档  ----xml配置方法
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll() {
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
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
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取业务层对象
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.调用方法
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取业务层的对象
//        IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.调用方法
        Account account = as.findAccountById(4);
        account.setMoney(123f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取业务层对象
//        IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.调用方法
        as.deleteAccount(1);
    }

    @Test
    public void testMoney(){
        as.transfer("bbb","ccc",750f);
    }

}
