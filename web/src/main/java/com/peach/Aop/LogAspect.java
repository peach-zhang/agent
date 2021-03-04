package com.peach.Aop;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author zhangtao
 */
@Slf4j
@Aspect
@Component
public class LogAspect {



    /**
     * 定义切入点，切入点为cn.unbug.controller.*下所有的类的中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("@annotation(com.peach.Aop.Log)")
    public void BrokerPointcut(){

    }

    /**
    * @description  在连接点执行之前执行的通知
    */
    @Before("BrokerPointcut() && @annotation(log)")
    public void doBefore(JoinPoint joinPoint,Log log){
        System.out.println(String.format("即将进入方法:{%s}, 参数为:{%s} ",log.tag(), JSON.toJSONString(joinPoint.getArgs())));
        System.out.println(String.format("即将进入方法：{%s} ",log.tag()));
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("BrokerPointcut()")
    public void doAfter(){
        System.out.println("在连接点执行之后执行的通知");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning(pointcut = "BrokerPointcut()",returning = "result")
    public void doAfterReturning(JoinPoint joinPoint,Object result){

    }

    /**
     * @description  在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing(pointcut = "BrokerPointcut()")
    public void doAfterThrowing(JoinPoint joinPoint){
        System.out.println("在连接点执行之后执行的通知（异常通知）");
    }
}
