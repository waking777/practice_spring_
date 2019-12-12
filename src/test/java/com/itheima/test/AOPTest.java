package com.itheima.test;

import com.itheima.service.IAccountService;
import com.itheima.service.IAccountService3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试aop的配置
 */
public class AOPTest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean3.xml");
        //2.获取对象
        IAccountService3 as3 = (IAccountService3)ac.getBean("accountService3");
        //3.执行方法
        as3.saveAccount();
    }
}
