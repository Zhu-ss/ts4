package com.baizhi.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * @ClassName Aop
 * @Author
 * @Date 2020/1/1 14:13
 * @Version 1.0
 **/
//@Aspect
//@Configuration
public class Aop {

    @Around("within(com.baizhi.service.T1)")
    public void before(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("这是一个前置通知");
        proceedingJoinPoint.proceed();
        System.out.println("后置通知");
    }
}
