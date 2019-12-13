package com.itheima.Utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 用于几率日志的工具类，它里面提供了公共的代码
 */
@Component("logger4")
@Aspect//当前类是个切面类
public class Logger4 {

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pt1(){}
    /**
     * 用于打印日志，计划让其在切入点方法之前执行（切入点方法就是业务层方法）
     */
    @Before("pt1()")
    public void printLog(){
        System.out.println("Logger类中的printLog方法开始记录日志了。。。");
    }
}
