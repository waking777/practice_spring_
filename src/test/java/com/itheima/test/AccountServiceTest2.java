package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.service.IAccountService2;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用单元测试junit
 * spring整合junit的配置
 *      1.导入spring整合junit的jar包
 *      2.使用junit提供的一个注解吧原有的main方法替换了，替换成spring提供的
 *              @runwith
 *      3.告知spring的运行器，spring和ioc创建时基于xml还是注解开发，并且说明位置
 *          @ContextConfiguration
 *                      locations:指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                      classes:指定注解类所在的位置
 *       当我们使用spring 5.x版本的时候，要求junit的jar包必须是4.1.2及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest2 {

    @Autowired
    private IAccountService2 as = null;

    @Test
    public void testFindAll() {
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
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
        IAccountService2 as = ac.getBean("accountService2", IAccountService2.class);
        //3.调用方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("hh");
        account.setMoney(100.0f);
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取业务层对象
        IAccountService2 as = ac.getBean("accountService2", IAccountService2.class);
        //3.调用方法
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
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
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取业务层对象
        IAccountService2 as = ac.getBean("accountService2",IAccountService2.class);
        //3.调用方法
        as.deleteAccount(1);
    }

}
