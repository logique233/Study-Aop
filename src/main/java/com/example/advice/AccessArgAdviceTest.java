package com.example.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
@Aspect
public class AccessArgAdviceTest {
    private static Log log = LogFactory.getLog(AccessArgAdviceTest.class);

    @AfterReturning(
            pointcut = "execution(* com.example.service.*.access*(..)) && args(time, name)",
            returning = "returnValue")
    public void access( Date time, Object returnValue, String name) {
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        Long start = time.getTime();
        Date endDate = new Date();
        Long end = endDate.getTime();
        System.out.println("目标方法中的参数String = " + name);
        System.out.println("目标方法中的参数Date = " + format0.format(time));
        System.out.println("执行时间：" + (end - start) + "毫秒");
        log.info("【请求耗时】："+(end - start)+"毫秒");
        System.out.println("结束时间：" + format0.format(endDate));
        System.out.println("目标方法的返回结果returnValue = " + returnValue);
    }

    @Before("execution(* com.example.service.*.access*(..))")
    public void log(JoinPoint point) {
        System.out.println("之前");
        System.out.println("@Before:  " + point.getArgs().length);
    }
}
